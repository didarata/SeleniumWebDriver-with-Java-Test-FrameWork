package StepDefs;

import com.gfk.saucedemo.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.gfk.webdriverprovider.WebDriverProvider;
import com.gfk.saucedemo.page.LoginPage;
import com.gfk.saucedemo.page.InventoryPage;
import com.gfk.saucedemo.page.OpenMenu;
import homework.Configuration;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {
    WebDriver driver;

    @io.cucumber.java.Before
    public void setUP() {
        driver = WebDriverProvider.getWebDriverInstance("CHROME");
        System.setProperty("user", "userNameOne");
        System.setProperty("pass", "passwordOne");
        System.setProperty("product", "productOne");
        System.setProperty("firstName", "firstNameOne");
        System.setProperty("lastName", "lastNameOne");
        System.setProperty("zipCode", "zipCodeOne");
    }

    @io.cucumber.java.After
    public void afterTests() {
            driver.quit();
    }

    @io.cucumber.java.en.Given("^User is on login page$")
    public void userIsOnLoginPage() throws IOException, ParseException {
        new LoginPage(driver)
                .goToLoginPage();
    }

    @io.cucumber.java.en.When("^User enters username, passwords and clicks on login button$")
    public void userEntersUsernamePasswordsAndClicksOnLoginButton() throws IOException, ParseException {
        new LoginPage(driver)
                .loginUserOnSauceLabs();
    }

    @io.cucumber.java.en.And("^User is redirected to Inventory Page$")
    public void userIsRedirectedToInventoryPage() throws IOException, ParseException {
        new InventoryPage(driver)
                .verifyInventoryPage();
    }

    @io.cucumber.java.en.And("^User clicks on product image$")
    public void userClicksOnProductImage() throws IOException, ParseException {
        new InventoryPage(driver)
                .clickProductImage();
    }

    @io.cucumber.java.en.Then("^User logs out$")
    public void userLogsOut() {
        new OpenMenu(driver)
                .logOut();
    }

    @When("User verifies Twitter, Facebook, Linkedin and Privacy text are in Footer")
    public void userVerifiesTwitterFacebookLinkedinAndPrivacyTextAreInFooter() throws IOException, ParseException {
        new InventoryPage(driver)
                .verifyFooter();
    }

    @And("User clicks on product name")
    public void userClicksOnProductName() throws IOException, ParseException {
        new InventoryPage(driver)
                .clickProductName();
    }

    @And("User verifies he is on Item Detail Page")
    public void userVerifiesHeIsOnItemDetailPage() {
    }
}
