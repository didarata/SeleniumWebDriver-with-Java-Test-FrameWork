package com.gfk.saucedemo.page;

import com.gfk.saucedemo.vault.Jsonreader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class InventoryPage extends OpenMenu {

    String PRODUCTNAME = Jsonreader.jsonUser(System.getProperty("product"));
    List<WebElement> ITEMSLIST = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
    static HashMap<String, String> NAMEANDPRICE = new HashMap<>();

    public InventoryPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }

    public InventoryItemDetailPage clickProductImage() {

        driver.findElement(By.xpath("//img[@alt='" + PRODUCTNAME + "']")).click();
        return new InventoryItemDetailPage(driver);
    }

    public InventoryItemDetailPage clickProductName() {
        driver.findElement(By.xpath("//div[normalize-space()='" + PRODUCTNAME + "']")).click();
        return new InventoryItemDetailPage(driver);
    }

    public InventoryPage verifyInventoryPage() {
        if (!getVerificationForInvetoryPage().equalsIgnoreCase("Products"))
            throw new RuntimeException("Not able to verify Inventory Item Page");
        return this;
    }

    public InventoryPage clickFilterMenu() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        return this;
    }

    public InventoryPage clickFilterPriceLowHigh() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Price (low to high)')]"))).click();
        return this;
    }

    public InventoryPage clickFilterPriceHighLow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Price (high to low)')]"))).click();
        return this;
    }

    public YourCartPage clickCartBtn() {
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        return new YourCartPage(driver);
    }

    private String getVerificationForInvetoryPage() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public InventoryPage verifyFilterPriceLowerToHigher() {
        double lastItemPrice = 0.0;
        for (int i = 1; i < ITEMSLIST.size() + 1; i++) {
            String currentPriceStr = driver.findElement(By.xpath("//div[@class='inventory_list']//div[" + i + "]//div[2]//div[2]//div[1]")).getText();
            double currentPrice = Double.parseDouble(currentPriceStr.substring(1));
            if (lastItemPrice <= currentPrice) {
                lastItemPrice = currentPrice;
            } else {
                throw new RuntimeException("Filter is not showing the items in Lower to Higher price order");
            }
        }
        return this;
    }

    public InventoryPage verifyFilterPriceHigherToLower() {
        double lastItemPrice = Double.MAX_VALUE;
        for (int i = 1; i < ITEMSLIST.size() + 1; i++) {
            String currentPriceStr = driver.findElement(By.xpath("//div[@class='inventory_list']//div[" + i + "]//div[2]//div[2]//div[1]")).getText();
            double currentPrice = Double.parseDouble(currentPriceStr.substring(1));
            if (lastItemPrice >= currentPrice) {
                lastItemPrice = currentPrice;
            } else {
                throw new RuntimeException("Filter is not showing the items in Higher to Lower price order");
            }
        }
        return this;
    }

    public InventoryPage allProductsByNameAndPrice() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_description']"));
        for (WebElement item : items) {
            String name = item.findElement(By.className("inventory_item_name")).getText();
            String price = item.findElement(By.className("inventory_item_price")).getText();
            InventoryPage.NAMEANDPRICE.put(name, price);
        }
        return this;
    }

    public InventoryPage verifyProducsOnPage() {
        if (ITEMSLIST.size() < 1)
            throw new RuntimeException("No products available.");
        return this;
    }
}

