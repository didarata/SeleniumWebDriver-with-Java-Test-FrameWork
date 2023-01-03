package com.gfk.saucedemo.page;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class OpenMenu {
    static WebDriver driver;

    public OpenMenu(WebDriver driver) {
        OpenMenu.driver = driver;
    }

    public OpenMenu clickOpenMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        return this;
    }
    public void clickLogOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link"))).click();
    }

    public void logOut() {
        clickOpenMenu().clickLogOut();
        new LoginPage(driver);
    }

    private String getVerificationForTwitterIcon() {
        return driver.findElement(By.xpath("//a[normalize-space()='Twitter']")).getAttribute("href");
    }

    public void verifyTwitter() {
        if (!getVerificationForTwitterIcon().contains("https://twitter.com/saucelabs"))
            throw new RuntimeException("Not able to verify Twitter social media link.");
    }

    private String getVerificationForFacebookIcon() {
        return driver.findElement(By.xpath("//a[normalize-space()='Facebook']")).getAttribute("href");
    }

    public void verifyFacebook() {
        if (!getVerificationForFacebookIcon().contains("https://www.facebook.com/saucelabs"))
            throw new RuntimeException("Not able to verify Facebook social media link.");
    }
    private String getVerificationForLinkedinIcon() {
        return driver.findElement(By.xpath("//a[normalize-space()='LinkedIn']")).getAttribute("href");
    }

    public void verifyLinkedin() {
        if (!getVerificationForLinkedinIcon().contains("https://www.linkedin.com/company/sauce-labs/"))
            throw new RuntimeException("Not able to verify Linkedin social media link.");
    }
    private String getVerificationForPrivacyText() {
        return driver.findElement(By.cssSelector(".footer_copy")).getText();
    }

    public void verifyPrivacyText() {
        if (!getVerificationForPrivacyText().contains(" Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"))
            throw new RuntimeException("Not able to verify Privacy text.");
    }

    public InventoryPage verifyFooter() throws IOException, ParseException {
        verifyPrivacyText();
        verifyTwitter();
        verifyLinkedin();
        verifyFacebook();
        return new InventoryPage(driver);
    }
}
