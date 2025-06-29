import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  test.setTimeout(60*1000);
  await page.goto('http://kc-dev.aprf.parma.local/szi/auth/?redirect_uri=http://kc-dev.aprf.parma.local/gdl/');
  await page.getByRole('button', { name: 'Войти через ЕСИА' }).click();
  await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).click();
  await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).fill('340-452-534 40');
  await page.getByRole('textbox', { name: 'Пароль' }).click();
  await page.getByRole('textbox', { name: 'Пароль' }).fill('ckPekf}WPfm~');
  await page.getByRole('button', { name: 'Войти', exact: true }).click();
  await page.getByRole('link', { name: 'Жизненные ситуации' }).click();
  await page.getByRole('tab', { name: 'Региональные' }).click();
  await page.getByRole('button', { name: 'Создать задачу' }).click();
  await page.getByRole('combobox', { name: 'Организация*' }).click();
  await page.waitForTimeout(1000)
  await page.getByRole('combobox', { name: 'Организация*' }).click();

// Вводим часть названия — отфильтрует список
  await page.locator('#organization_0_roivAgencyId').fill('Минприроды');

// Ждём появления нужной опции
  const option = page.locator('div[aria-label="Минприроды Белгородской области"]');
  await option.waitFor({ state: 'visible' });

// Кликаем по опции
  await option.click();


  await page.getByRole('textbox', { name: 'Описание задачи*' }).click();
  await page.getByRole('textbox', { name: 'Описание задачи*' }).fill('описание2');
  await page.getByRole('textbox', { name: 'ДД.ММ.ГГГГ' }).click();
  await page.getByRole('button', { name: 'Следующий год (Control +' }).click();
  await page.getByText('25', { exact: true }).click();
  await page.getByRole('button', { name: 'Направить' }).click();
  //await page.close();
});