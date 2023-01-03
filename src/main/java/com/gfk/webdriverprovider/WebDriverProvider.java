package com.gfk.webdriverprovider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class WebDriverProvider {

    public static WebDriver getWebDriverInstance(String browserName) {
        WebDriver driver;
        if (browserName.contains("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.contains("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.contains("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else
            throw new RuntimeException("Browser Name is not Correct or Not Supported right now"+ browserName);

        return driver;
    }
}
