import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class JavaFullStackPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public JavaFullStackPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        this.wait = new WebDriverWait(driver, 10);
    }

    private String signUpButton = "//*[@id=\"about\"]/div/div[1]/div[3]/a/span";

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signUpButton)));
        driver.findElement(By.xpath(signUpButton)).click();
    }
}
