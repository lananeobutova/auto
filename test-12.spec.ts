import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://kc-dev.aprf.parma.local/szi/auth/?redirect_uri=http://kc-dev.aprf.parma.local/gdl/');
  await page.getByRole('button', { name: 'Войти через ЕСИА' }).click();
  await page.getByText('Портал государственных услуг Российской ФедерацииТелефон / Email').click();
  await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).click();
  await page.getByRole('textbox', { name: 'Логин - введите телефон,' }).fill('488-271-116 16');
  await page.getByRole('textbox', { name: 'Пароль' }).click();
  await page.getByRole('textbox', { name: 'Пароль' }).fill('K~_u)g1Ui@3');
  await page.getByRole('button', { name: 'Войти', exact: true }).click();

  await page.getByRole('link', { name: 'Жизненные ситуации' }).click();
  await page.getByRole('tab', { name: 'Региональные' }).click();
  await page.getByRole('columnheader', { name: 'Жизненная ситуация caret-up' }).getByRole('button').click();
  await page.getByRole('searchbox', { name: 'Введите значение для поиска' }).click();
  await page.getByRole('searchbox', { name: 'Введите значение для поиска' }).fill('ржсдев');
  await page.getByText('РЖСдев2').click();
  await page.getByRole('button', { name: 'Поиск' }).click();
  await page.getByLabel('Региональные').getByText('РЖСдев').click();
  await page.getByRole('tab', { name: 'Бизнес-процесс' }).click();

  await page.waitForSelector('.ant-spin', { state: 'detached' }); 

  const editButton = page.locator("//div[@class = '_business-process-action-panel_a9a245ba']//button[1]");
  await editButton.waitFor({ state: 'attached' });
  await expect(editButton).toBeVisible();
  await expect(editButton).toBeEnabled();
  await page.waitForTimeout(300); 
  await editButton.click();

  await page.locator("(//div[@class='_constructor-tools-panel__group_d32e5ca7']//button)[6]").click();
  await page.locator('#container').getByRole('img').nth(1).click();
  await page.getByTestId('dictionary-select').getByLabel('down').click();
  await page.getByLabel('Начало бизнес-процесса').click();
  await page.getByRole('textbox', { name: 'Название события*' }).click();
  await page.getByRole('textbox', { name: 'Название события*' }).fill('начало');
  await page.getByRole('button', { name: 'Создать' }).click();

  
  
});