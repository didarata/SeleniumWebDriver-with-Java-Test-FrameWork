package homework;

import com.gfk.saucedemo.page.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyCheckOut extends Configuration {

    @Test
    public void verifyIfCheckoutIsSuccessful() throws IOException, ParseException {

        new LoginPage(driver).goToLoginPage()
                .loginUserOnSauceLabs()
                .verifyInventoryPage()
                .clickProductImage()
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

//    First UseCase:
//
//        1.	Login on SauceDemo
//        2.	Verify the Page after Login
//        3.	Select the Product By Name
//        4.	Verify the Description/Details page for the Product
//        5.	Click Add to Cart
//        6.	Verify the Value in Add to Cart
//        7.	Click Add to Cart Icon
//        8.	Verify CheckOut Page and Check if the same Item is there or not
//        9.	Click CHECKOUT button
//        10.	Enter Your Name, Last Name and Zip code.
//        11.	Click Continue Button
//        12.	Verify Checkout : Overview page and Check the Product Name again.
//        13.	Click Finish Button
//        14.	Verify the Order is placed Successfully.

