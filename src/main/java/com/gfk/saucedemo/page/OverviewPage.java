package com.gfk.saucedemo.page;

import com.gfk.saucedemo.vault.Jsonreader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class OverviewPage extends OpenMenu {

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getOverviewPageSameItem() {
        return driver.findElement(By.cssSelector(".inventory_item_name")).getText();
    }

    public OverviewPage verifyOverviewPageSameItem() throws IOException, ParseException {
        String productName = Jsonreader.jsonUser(System.getProperty("product"));
        if(!getOverviewPageSameItem().equalsIgnoreCase(productName))
            throw new RuntimeException("Not able to verify Check Out Page has the same Item.");
        return this;
    }

    public String getVerificationForOverviewPage() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public OverviewPage verifyOverviewPage() {
        if (!getVerificationForOverviewPage().equalsIgnoreCase("Checkout: Overview"))
            throw new RuntimeException("Not able to verify Overview Page");
        return this;
    }

    public CompletePage clickFinishBtn() {
        driver.findElement(By.cssSelector("#finish")).click();
        return new CompletePage(driver);
    }
}