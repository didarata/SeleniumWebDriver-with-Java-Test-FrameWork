package homework;

import com.gfk.saucedemo.page.LoginPage;
import homework.Configuration;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyFooterThreeSocialMediaIcons extends Configuration {

    @Test
    public void verifyIfLogoutIsSuccessful() throws IOException, ParseException {

        new LoginPage(driver).goToLoginPage().loginUserOnSauceLabs()
                .verifyInventoryPage()
                .verifyFooter()
                .clickProductName()
                .verifyItemDetailsPageIsOpen()
                .verifyFooter()
                .logOut();
    }
}

//5th Test: Verify the Footer has all 3 Social Media Icons.
//        1. Login on SauceDemo
//        2. Verify the Products Page.
//        3. Verify Twitter, Facebook and LinkedIn Icons are present in the Footer.
//        4. Verify the URL for all 3 Icons pointing to Correct Website.( No Need to click on the Icons Please.)
//        5. Verify in Footer 'Privacy Policy' Text is also Present.
//        6. Select Any Product By Name.
//        7. Verify product description page opened.
//        8. Verify Again the Twitter, Facebook and LinkedIn Icons are present in the Footer.
//        9. Logout the User.
