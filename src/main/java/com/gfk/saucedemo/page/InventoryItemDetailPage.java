package com.gfk.saucedemo.page;

import com.gfk.saucedemo.vault.Jsonreader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Objects;

public class InventoryItemDetailPage extends OpenMenu {

    public InventoryItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public String GetItemDetailsTitleText() {
        return driver.findElement(By.xpath("//div[@class = 'inventory_details_name large_size' ]")).getText();
    }

    public InventoryItemDetailPage verifyItemDetailsPageIsOpen() throws IOException, ParseException {
        String productName = Jsonreader.jsonUser(System.getProperty("product"));
        if (!GetItemDetailsTitleText().equalsIgnoreCase(productName))
            throw new RuntimeException("Not able to verify Inventory Item Page for Item with name: " + productName);
        return this;
    }

    public InventoryItemDetailPage clickAddToCartButton() {
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        return this;
    }

    public InventoryItemDetailPage verifyValueInAddCart(String itemsCount) {
        String count = driver.findElement(By.id("shopping_cart_container")).getText();
        if (!count.equalsIgnoreCase(itemsCount))
            throw new RuntimeException("Failed to verify Items In the Cart");
        return this;
    }

    public YourCartPage clickCartBtn() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        return new YourCartPage(driver);
    }

    public InventoryItemDetailPage verifyPriceOfItem() throws IOException, ParseException {
        String priceOnInventoryPage = InventoryPage.NAMEANDPRICE.get(Jsonreader.jsonUser(System.getProperty("product")));
        String priceOnDetailedPage = driver.findElement(By.cssSelector(".inventory_details_price")).getText();
        if(!Objects.equals(priceOnDetailedPage, priceOnInventoryPage))
            throw new RuntimeException("Price of the item are different");
        return this;
    }
}