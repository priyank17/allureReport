package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;

    // Locate all elements of Login page
    By txtUsername = By.id("txtUsername");
    By txtPassword = By.id("txtPassword");
    By btnLogin = By.id("btnLogin");
    By lblWelcome = By.id("welcome");
    By linkLogout = By.xpath("//a[@href=\"/index.php/auth/logout\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setup() {
        // Initialize the driver
        System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
        driver = new ChromeDriver();

        // Open application URL
        driver.get("https://opensource-demo.orangehrmlive.com");

        // Maximize the window
        driver.manage().window().maximize();

        // Define implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void enterUsername(String username) {
        driver.findElement(txtUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(btnLogin).click();
    }

    public void clickLogOutBtn() {
        driver.findElement(lblWelcome).click();
        driver.findElement(linkLogout).click();
    }

}
