import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.wait = new WebDriverWait(driver, 10);
    }

    private String javaFullStack = "//div[contains(text(), 'Java FullStack')]";
    private String javaFullStackButton = "//div[@class = 'sidebar-nav-label' and text() = 'Java FullStack']/ancestor::a";

    public void open() {
        driver.get("https://javarush.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(javaFullStack)));
    }

    public void goToJavaFullStack() {
        driver.findElement(By.xpath(javaFullStackButton)).click();
    }
}