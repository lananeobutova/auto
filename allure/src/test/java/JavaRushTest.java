import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("Настройка тестов")
@Listeners({AllureTestNg.class})
public class JavaRushTest {

    private WebDriver driver;

    @BeforeClass
    @Description("Настройка WebDriver перед запуском тестов.")
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер: " + browser);
        }
    }

    @Test
    @Description("Проверка заголовка главной страницы")
    @Feature("Главная страница")
    @Story("Проверка доступности")
    @Severity(SeverityLevel.MINOR)
    public void checkHomePageTitle() {
        openHomePage();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("JavaRush"));
        logStep("Успешно проверен заголовок главной страницы");
    }

    @Step("Открыть главную страницу")
    @Attachment(value = "Главная страница", type = "text/plain")
    public void openHomePage() {
        driver.get("https://javarush.com/");
        logStep("Главная страница загружена: " + driver.getCurrentUrl());
    }

    @AfterClass
    @Step("Закрытие драйвера")
    @Description("Закрытие WebDriver после выполнения тестов.")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Логирование шага: {stepDescription}")
    public void logStep(String stepDescription) {
        System.out.println(stepDescription);
    }
}
