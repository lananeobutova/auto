import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AwaitilityLibrary {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWelcomeMessageVisibility() {
        driver.get("https://javarush.com/");

        // Ожидание, пока элемент с приветственным сообщением станет видимым
        await().atMost(10, SECONDS).until(() -> {
            WebElement welcomeMessage = driver.findElement(By.xpath("//span[contains(text(), 'Здесь ты станешь программистом')]"));
            return welcomeMessage.isDisplayed();
        });

        // Проверка, что сообщение видно
        WebElement welcomeMessage = driver.findElement(By.xpath("//span[contains(text(), 'Здесь ты станешь программистом')]"));
        assertTrue(welcomeMessage.isDisplayed(), "Сообщение приветствия должно быть видно.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
