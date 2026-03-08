package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;

public class DashboardTests extends BaseTest {

    // Test 1
    @Test
    public void TC_06_verifyDashboardLoaded(){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        Assert.assertTrue(dashboardPage.verifyDashboardMenu(),
                "Dashboard menu not visible");
    }

    // Test 2
    @Test
    public void TC_07_verifyDashboardWidget(){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        Assert.assertTrue(dashboardPage.verifyDashboardWidget(),
                "Dashboard widget not displayed");
    }

    // Test 3
    @Test
    public void TC_08_verifySideNavigationMenu(){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        Assert.assertTrue(dashboardPage.verifySideMenu(),
                "Side navigation menu not visible");
    }

    // Test 4
    @Test
    public void TC_09_navigateToPIMPage(){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        dashboardPage.clickPIM();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("pim"),
                "PIM page not opened");
    }

    // Test 5
    @Test
    public void TC_10_verifyLogoutFunctionality(){

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("Admin","admin123");

        DashboardPage dashboardPage = new DashboardPage(getDriver());

        dashboardPage.logout();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("login"),
                "Logout failed");
    }
}