package homework;

import com.gfk.saucedemo.page.LoginPage;
import homework.Configuration;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyPriceFilterOnProductsPage extends Configuration {

    @Test
    public void verifyIfLogoutIsSuccessful() throws IOException, ParseException, InterruptedException {

        new LoginPage(driver).goToLoginPage().loginUserOnSauceLabs()
                .verifyInventoryPage()
                .clickFilterMenu()
                .clickFilterPriceLowHigh()
                .verifyFilterPriceLowerToHigher()
                .clickFilterMenu()
                .clickFilterPriceHighLow()
                .verifyFilterPriceHigherToLower()
                .logOut();
    }
}

//3rd Test: Verify the Price Filter on Products Page.
//        1. Login on SauceDemo
//        2. Verify the Products Page.
//        3. Select Price Filter -> Low to High
//        4. Verify the Products are now listed as Low to High Price products.
//        5. Select Price Filter -> High to Low.
//        6. Verify the Products are now listed as High to Low Price products on the page.
//        7. Click Logout.

