import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class EnrollPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EnrollPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        this.wait = new WebDriverWait(driver, 15);
    }

    private String inputName = "//input[@name = 'name']";
    private String inputMail = "//input[@name = 'email']";
    private String inputPhone = "//input[@name = 'phone']";
    private String signUp = "//button[@class = 'btn btn--lime svelte-c95fve btn--arrow btn--wide']";
    private String okBut = "//button[@class = 'btn btn--lime svelte-c95fve btn--wide']";



//    public void fillForm(String name, String email, String phone) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputName)));
//        driver.findElement(By.xpath(inputName)).sendKeys(name);
//        driver.findElement(By.xpath(inputMail)).sendKeys(email);
//        driver.findElement(By.xpath(inputPhone)).sendKeys(phone);
//        driver.findElement(By.xpath(signUp)).click();


    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputName)));
        driver.findElement(By.xpath(inputName)).sendKeys(name);
    }
    public void enterMail(String mail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputMail)));
        driver.findElement(By.xpath(inputMail)).sendKeys(mail);
    }
    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputPhone)));
        driver.findElement(By.xpath(inputPhone)).sendKeys(phone);
    }
    public void clickSignUpBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signUp)));
        driver.findElement(By.xpath(signUp)).click();
    }

    public void verifySuccessMessage() {
        WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(okBut)));
        okButton.click();
        // проверяем, что окно закрылось
        wait.until(ExpectedConditions.invisibilityOf(okButton));
    }
}

