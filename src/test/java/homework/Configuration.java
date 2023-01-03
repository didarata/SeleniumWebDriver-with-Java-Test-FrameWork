package homework;

import com.gfk.webdriverprovider.WebDriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.IOException;

public class Configuration {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException {
        driver = WebDriverProvider.getWebDriverInstance("CHROME");
        System.setProperty("user", "userNameOne");
        System.setProperty("pass", "passwordOne");
        System.setProperty("product", "productOne");
        System.setProperty("firstName", "firstNameOne");
        System.setProperty("lastName", "lastNameOne");
        System.setProperty("zipCode", "zipCodeOne");
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    @AfterMethod
    public void screenShot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File("./src/test/screenshots/" + result.getName() + System.currentTimeMillis() + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}