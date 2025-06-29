import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Открываем сайт
            driver.get("https://javarush.com/");

            // Создаем явное ожидание
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Ожидаем загрузку элемента
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'header__start svelte-b5iurl']")));

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
}
