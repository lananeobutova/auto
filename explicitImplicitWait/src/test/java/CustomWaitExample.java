import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CustomWaitExample {
    public static void main(String[] args) {
        // Укажите путь до вашего драйвера Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Открываем сайт
            driver.get("https://javarush.com/");

            // Находим элемент по xPath
            WebElement element = driver.findElement(By.xpath("//div[@class = 'header__start svelte-b5iurl']"));

            // Ожидаем, пока элемент станет кликабельным
            waitForElementToBeClickable(driver, element, 10);

            // Кликаем на элемент
            element.click();

            // Дополнительные действия после клика, если нужно

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрываем браузер
            driver.quit();
        }
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
        Duration duration = Duration.ofSeconds(timeoutSeconds);
        long endTime = System.currentTimeMillis() + duration.toMillis();

        while (System.currentTimeMillis() < endTime) {
            try {
                if (element.isDisplayed() && element.isEnabled()) {
                    return; // Элемент кликабельный
                }
            } catch (Exception e) {
                // Игнорируем исключение, если элемент недоступен
            }

            // Ждем немного перед следующей проверкой
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Возобновляем прерывание
            }
        }
        throw new RuntimeException("Элемент не стал кликабельным за " + timeoutSeconds + " секунд.");
    }
}

