import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaRushTest {



    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            MainPage mainPage = new MainPage(driver);
            mainPage.open();
            mainPage.goToJavaFullStack();

            JavaFullStackPage javaFullStackPage = new JavaFullStackPage(driver);
            javaFullStackPage.clickSignUpButton();

            EnrollPage enrollPage = new EnrollPage(driver);
            enrollPage.enterName("Имя");
            enrollPage.enterMail("124@gmail.com");
            enrollPage.enterPhone("9655128823");
            enrollPage.clickSignUpBtn();
            enrollPage.verifySuccessMessage();

        } finally {
            driver.quit();
        }
    }
}
