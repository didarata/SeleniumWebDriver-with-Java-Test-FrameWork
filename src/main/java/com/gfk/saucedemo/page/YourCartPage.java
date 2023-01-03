package com.gfk.saucedemo.page;

import com.gfk.saucedemo.vault.Jsonreader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Objects;

public class YourCartPage extends OpenMenu {

    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public String getCheckOutPageSameItem() {
        return driver.findElement(By.cssSelector(".inventory_item_name")).getText();
    }
    public YourCartPage verifyCheckOutPageSameItem() throws IOException, ParseException {
        String productName = Jsonreader.jsonUser(System.getProperty("product"));
        if(!getCheckOutPageSameItem().equalsIgnoreCase(productName))
            throw new RuntimeException("Not able to verify Check Out Page has the same Item!");
        return this;
    }

    public YourInformationPage clickCheckOutBtn() {
        driver.findElement(By.cssSelector("#checkout")).click();
        return new YourInformationPage(driver);
    }

    public String getVerificationForYourCardPage() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public YourCartPage verifyYourCardPage() {
        if (!getVerificationForYourCardPage().equalsIgnoreCase("Your Cart"))
            throw new RuntimeException("Not able to verify Inventory Item Page!");
        return this;
    }

    public YourCartPage verifyCartEmpty(){
        if (!driver.findElements(By.xpath("//div[@class='cart_item']")).isEmpty())
            throw new RuntimeException("Cart is not empty!");
        return this;
    }
    public YourCartPage verifyCheckoutBtnDisable(){
        if (driver.findElement(By.xpath("//button[@id='checkout']")).isEnabled())
            throw new RuntimeException("Checkout button is Enabled!");
        return this;
    }

    public YourCartPage verifyPriceOfItemInYourCartPage() throws IOException, ParseException {
        String productName = Jsonreader.jsonUser(System.getProperty("product"));
        String priceOnInventoryPage = InventoryPage.NAMEANDPRICE.get(productName);
        String priceOnDetailedPage = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        if(!Objects.equals(priceOnDetailedPage, priceOnInventoryPage))
            throw new RuntimeException("Price of the item are different");
        return this;
    }
}
