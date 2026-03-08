package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.TestUtil;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestUtil.class)

    public void TC_01_loginTest(String username, String password){

        LoginPage login = new LoginPage(getDriver());

        login.login(username, password);

/*
Logic:
Valid credentials → Dashboard
Invalid credentials → Error message
Empty fields → Required message
*/

        if(username.equals("Admin") && password.equals("admin123")){

            Assert.assertTrue(getDriver().getCurrentUrl().contains("dashboard"),
                    "Valid login failed");

        }

        else if(username.isEmpty() || password.isEmpty()){

            Assert.assertTrue(login.isRequiredMessageDisplayed(),
                    "Required message not displayed");

        }

        else{

            Assert.assertTrue(login.isErrorDisplayed(),
                    "Invalid credentials error not displayed");

        }

    }

}