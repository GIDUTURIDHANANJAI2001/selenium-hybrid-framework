package utilities;

import org.testng.annotations.DataProvider;

public class TestUtil {

    @DataProvider(name="loginData")

    public Object[][] getLoginData(){

        return ExcelUtil.getTestData("LoginData");

    }

}