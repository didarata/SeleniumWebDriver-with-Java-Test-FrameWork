package homework;

import com.gfk.saucedemo.page.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyLogout extends Configuration {

    @Test
    public void verifyIfLogoutIsSuccessful() throws IOException, ParseException {

        new LoginPage(driver).goToLoginPage()
                .loginUserOnSauceLabs()
                .verifyInventoryPage()
                .clickProductImage()
                .logOut();
    }
}

//    Second UseCase:
//        1.	Login on SauceDemo
//        2.	Verify Page after Login.
//        3.	Select the Product By Image.
//        4.	Click Logout and User should be Logged Out
