package com.gfk.saucedemo.page;

import com.gfk.saucedemo.vault.Jsonreader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class LoginPage{

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    private LoginPage enterUsername() throws IOException, ParseException {
       driver.findElement(By.id("user-name")).sendKeys(Jsonreader.jsonUser(System.getProperty("user")));
       return this;
    }

    private LoginPage enterPassword() throws IOException, ParseException {
       driver.findElement(By.id("password")).sendKeys(Jsonreader.jsonUser(System.getProperty("pass")));
       return this;
    }

    private void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    public InventoryPage loginUserOnSauceLabs() throws IOException, ParseException {
      enterUsername().enterPassword().clickLoginButton();
      return new InventoryPage(driver);
    }
}
