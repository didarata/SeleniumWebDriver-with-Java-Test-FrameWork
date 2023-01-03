package homework;

import com.gfk.saucedemo.page.LoginPage;
import homework.Configuration;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyProductPriceInAllPages extends Configuration {

    @Test
    public void verifyIfLogoutIsSuccessful() throws IOException, ParseException {

        new LoginPage(driver).goToLoginPage()
                .loginUserOnSauceLabs()
                .verifyInventoryPage()
                .verifyProducsOnPage()
                .allProductsByNameAndPrice()
                .clickProductName()
                .verifyItemDetailsPageIsOpen()
                .verifyPriceOfItem()
                .clickAddToCartButton()
                .clickCartBtn()
                .verifyPriceOfItemInYourCartPage()
                .logOut();
    }
}

//6th Test: Verify the Product Price in All Pages.
//        1. Login on SauceDemo
//        2. Verify the Products Page.
//        3. Any Product By Name and Price should be Present and Store the Price of Product.
//        4. Click and Select the Above Product By Name.
//        5. Verify product description page opened.
//        6. Verify The Price of the Product is same Like in Products List Page.
//        7. Add to Cart the Product.
//        8. Click Cart Icon.
//        9. Verify in the Cart Page the product Price is Still Same.
//        10. Logout User.
