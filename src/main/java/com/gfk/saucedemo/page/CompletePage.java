package com.gfk.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends OpenMenu {

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public String GetVerificationForSuccessfulOrder() {
        return driver.findElement(By.cssSelector(".complete-text")).getText();
    }

    public void verifySuccessfulOrder() {
        if (!GetVerificationForSuccessfulOrder().equalsIgnoreCase("Your order has been dispatched, and will arrive just as fast as the pony can get there!"))
            throw new RuntimeException("Not able to verify Successful Order");
    }
}
