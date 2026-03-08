package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilities.WaitUtil;

public class DashboardPage {

    WebDriver driver;

    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

// Locators

    By dashboardMenu = By.xpath("//span[text()='Dashboard']");

    By pimMenu = By.xpath("//span[text()='PIM']");

    By userDropdown = By.xpath("//span[@class='oxd-userdropdown-tab']");

    By logoutButton = By.xpath("//a[text()='Logout']");

    By timeAtWorkWidget = By.xpath("//p[text()='Time at Work']");

    By sideMenu = By.xpath("//aside[contains(@class,'oxd-sidepanel')]");


// Methods

    public boolean verifyDashboardMenu(){

        log.info("Verifying Dashboard menu");

        WaitUtil.waitForVisible(driver,dashboardMenu);

        return driver.findElement(dashboardMenu).isDisplayed();

    }

    public boolean verifyDashboardWidget(){

        log.info("Verifying Time at Work widget");

        WaitUtil.waitForVisible(driver,timeAtWorkWidget);

        return driver.findElement(timeAtWorkWidget).isDisplayed();

    }

    public boolean verifySideMenu(){

        log.info("Verifying side navigation menu");

        WaitUtil.waitForVisible(driver,sideMenu);

        return driver.findElement(sideMenu).isDisplayed();

    }

    public void clickPIM(){

        log.info("Clicking PIM menu");

        driver.findElement(pimMenu).click();

    }

    public void openUserMenu(){

        log.info("Opening user dropdown");

        driver.findElement(userDropdown).click();

    }

    public void logout(){

        log.info("Logging out user");

        openUserMenu();

        driver.findElement(logoutButton).click();

    }

}