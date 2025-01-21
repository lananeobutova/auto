import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TestAllure {

    WebDriver driver;

    @BeforeTest
    @Epic("Инициализация тестов")
    @Description("Настройка WebDriver перед запуском тестов.")
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    @Step("Переход на сайт JavaRush")
    @Feature("Тестирование главной страницы")
    @Story("Проверка заголовка страницы")
    @Description("Тест проверяет возможность перехода на сайт JavaRush и выводит заголовок страницы.")
    @Severity(SeverityLevel.MINOR)
    public void test1() {
        driver.get("https://javarush.com");

        String title = driver.getTitle();
        System.out.print(title + "=====");
        Allure.addAttachment("Заголовок страницы", title);
    }

    @AfterTest
    @Step("Закрытие драйвера")
    @Description("Закрытие WebDriver после выполнения тестов.")
    public void quit() {
        if (driver != null) {
            // driver.quit();
            driver.close();
        }
    }
}
