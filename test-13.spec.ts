import { test, expect } from '@playwright/test';
import * as fs from 'fs';

const rawData = fs.readFileSync('./tests/testData.json', 'utf-8');
const testData = JSON.parse(rawData);

test.describe('Тест авторизации (DDT)', () => {
  for (const data of testData) {
    test(`Логин: ${data.login}, Ожидаемый результат: ${data.expectSuccess ? 'Успех' : 'Ошибка'}`, async ({ page }) => {
      await page.goto('http://kc-dev.aprf.parma.local/szi/auth/?redirect_uri=http://kc-dev.aprf.parma.local/gdl/');

      await page.getByRole('button', { name: 'Войти через ЕСИА' }).click();
      await page.getByText('Портал государственных услуг Российской ФедерацииТелефон / Email').click();
      await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).fill(data.login);
      await page.getByRole('textbox', { name: 'Пароль' }).fill(data.password);
      await page.getByRole('button', { name: 'Войти', exact: true }).click();

      if (data.expectSuccess) {
        
        await expect(page.getByRole('link', { name: 'Жизненные ситуации' })).toBeVisible({ timeout: 5000 });
      } else {
        
        await expect(page.getByRole('link', { name: 'Жизненные ситуации' })).not.toBeVisible({ timeout: 5000 });
              }
    });
  }
});
