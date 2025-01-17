import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitTest {
    public static void main(String[] args) {
        // Путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/chromedriver.exe");

        // Инициализация веб-драйвера
        WebDriver driver = new ChromeDriver();

        // Установка неявного ожидания на 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Открытие сайта
            driver.get("https://javarush.com/");

            // Проверка заголовка страницы
            String expectedTitle = "Java курс от JavaRush — обучение программированию для начинающих";
            String actualTitle = driver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Тест пройден. Заголовок страницы соответствует ожидаемому.");
            } else {
                System.out.println("Тест не пройден. Ожидался: " + expectedTitle + ", но получен: " + actualTitle);
            }
        } finally {
            // Закрытие драйвера
            driver.quit();
        }
    }
}
