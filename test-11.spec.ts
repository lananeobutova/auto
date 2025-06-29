import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://kc-dev.aprf.parma.local/szi/auth/?redirect_uri=http://kc-dev.aprf.parma.local/gdl/');
  await page.getByRole('button', { name: 'Войти через ЕСИА' }).click();
  await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).click();
  await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).fill('500-575-544 56');
  await page.getByRole('textbox', { name: 'Пароль' }).click();
  await page.getByRole('textbox', { name: 'Пароль' }).fill('1GWlaN4_!/!');
  await page.getByRole('button', { name: 'Войти', exact: true }).click();
  await page.getByRole('link', { name: 'Жизненные ситуации' }).click();
  await page.locator('tr.ant-table-row.ant-table-row-level-0 td div').first().click();

  await page.getByRole('tab', { name: 'Показатели' }).click();
  // Находим блок с названием показателя
const metricBlock = page.locator('div._measurements-metric_6b885140', {
  has: page.locator('div._measurements-metric__name_6b885140', { hasText: 'Количество запрашиваемых документов' })
});

// Внутри этого блока ищем кнопку с тремя точками
const menuButton = metricBlock.locator('button[aria-describedby]');
await menuButton.waitFor({ state: 'visible' });
await menuButton.click();

// Ждём появление пункта меню "Ввод значений показателей" и кликаем
const inputButton = page.locator('span', { hasText: 'Ввод значений показателей' });
await inputButton.waitFor({ state: 'visible' });
await inputButton.click();

  await page.locator('#calendarLevel').getByLabel('down').click();
  await page.getByLabel('Месяц').click();
  await page.getByRole('spinbutton', { name: 'Значение*' }).click();
  await page.getByRole('spinbutton', { name: 'Значение*' }).fill('555');
  await page.getByRole('button', { name: 'Сохранить' }).click();
  await page.locator('.ant-col > div > .ant-row > .ant-col.ant-col-24.ant-form-item-control > .ant-form-item-control-input > .ant-form-item-control-input-content > div > .ant-select > .ant-select-arrow > div > .anticon').click();
  await page.getByLabel('Целевое значение').click();
  await page.getByRole('spinbutton', { name: 'Значение*' }).click();
  await page.getByRole('spinbutton', { name: 'Значение*' }).fill('666');
  await page.getByRole('button', { name: 'Сохранить' }).click();
  await page.getByRole('dialog').locator('button').nth(2).click();
  await expect(page.getByText('Регламентное').nth(1)).toBeVisible();
  await expect(page.getByLabel('Показатели')).toContainText('Регламентное');
  await expect(page.getByText('555')).toBeVisible();
  await expect(page.getByLabel('Показатели')).toContainText('555');
  await expect(page.getByText('Целевое').nth(1)).toBeVisible();
  await expect(page.getByLabel('Показатели')).toContainText('Целевое');
  await expect(page.getByText('666')).toBeVisible();
  await expect(page.getByLabel('Показатели')).toContainText('666');
  await page.close();
});