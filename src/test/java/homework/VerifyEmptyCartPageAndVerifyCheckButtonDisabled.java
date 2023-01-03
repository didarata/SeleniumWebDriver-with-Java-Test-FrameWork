package homework;

import com.gfk.saucedemo.page.LoginPage;
import homework.Configuration;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyEmptyCartPageAndVerifyCheckButtonDisabled extends Configuration {

    @Test
    public void verifyIfLogoutIsSuccessful() throws IOException, ParseException {

        new LoginPage(driver).goToLoginPage().loginUserOnSauceLabs()
                .verifyInventoryPage()
                .clickCartBtn()
                .verifyYourCardPage()
                .verifyCartEmpty()
                .verifyCheckoutBtnDisable()
                .logOut();
    }
}

//4th Test: Verify the Empty Cart Page and Verify CHECKOUT Button is Disabled.
//        1. Login on SauceDemo
//        2. Verify the Products Page.
//        3. Click cart Icon from Top Corner.
//        4. Verify Your Cart Page Displayed.
//        5. Verify there is no Product In the Cart.
//        6. Verify As No product In Cart the CHECKOUT button should be Disabled.(Test should Fail Here)
//        7. Logout user.


