package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginTests {

    // Define Driver
    public WebDriver driver;
    LoginPage objLoginpage;
    String username;
    String password;


    @BeforeMethod(description = "Reading Username and Password")
    public void setupLogin() throws IOException {
        // Read Property file
        FileReader reader = new FileReader("resources\\Config.properties");
        Properties prop = new Properties();

        // load a properties file
        prop.load(reader);

        // Get values from property file
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }


    @Test(description = "Verify Valid Login")
    public void checkValidLogin() {

        objLoginpage = new LoginPage(driver);

        // Setup test
        objLoginpage.setup();

        // Perform Login
        objLoginpage.enterUsername(username);
        objLoginpage.enterPassword(password);
        objLoginpage.clickLoginBtn();

//        saveScreenshot(driver);

        // Perform Logout
        objLoginpage.clickLogOutBtn();

    }

    @Attachment(value = "Dashboard", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
