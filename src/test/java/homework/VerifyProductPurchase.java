package homework;

import com.gfk.saucedemo.page.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyProductPurchase extends Configuration {

    @Test
    public void verifyIfLogoutIsSuccessful() throws IOException, ParseException {

        new LoginPage(driver).goToLoginPage().loginUserOnSauceLabs()
                .verifyInventoryPage()
                .clickProductName()
                .verifyItemDetailsPageIsOpen()
                .verifyItemDetailsPageIsOpen()
                .clickAddToCartButton()
                .verifyValueInAddCart("1")
                .clickCartBtn()
                .verifyCheckOutPageSameItem()
                .clickCheckOutBtn()
                .enterCheckOutInformation()
                .verifyOverviewPage()
                .verifyOverviewPageSameItem()
                .clickFinishBtn()
                .verifySuccessfulOrder();
    }
}

//1st Test: Verify Product Purchase.
//        1.            Login on SauceDemo
//        2.            Verify the Page after Login
//        3.            Select the Product By Name
//        4.            Verify the Description/Details page for the Product
//        5.            Click Add to Cart
//        6.            Verify the Value in Add to Cart
//        7.            Click Add to Cart Icon
//        8.            Verify Checkout Page and Check if the same Item is there or not
