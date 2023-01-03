package com.gfk.saucedemo.page;

import com.gfk.saucedemo.vault.Jsonreader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class YourInformationPage extends OpenMenu {

    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    private YourInformationPage enterFirstName() throws IOException, ParseException {
        driver.findElement(By.id("first-name")).sendKeys(Jsonreader.jsonUser(System.getProperty("firstName")));
        return this;
    }

    private YourInformationPage enterLastName() throws IOException, ParseException {
        driver.findElement(By.id("last-name")).sendKeys(Jsonreader.jsonUser(System.getProperty("lastName")));
        return this;
    }

    private YourInformationPage enterZipCode() throws IOException, ParseException {
        driver.findElement(By.id("postal-code")).sendKeys(Jsonreader.jsonUser(System.getProperty("zipCode")));
        return this;
    }

    private void clickContinueBtn() {
        driver.findElement(By.id("continue")).click();
    }

    public OverviewPage enterCheckOutInformation() throws IOException, ParseException {
        enterFirstName().enterLastName().enterZipCode().clickContinueBtn();
        return new OverviewPage(driver);
    }
}
