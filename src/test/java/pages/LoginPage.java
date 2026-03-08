package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilities.WaitUtil;

public class LoginPage {

    WebDriver driver;

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Locators
    By usernameField = By.name("username");

    By passwordField = By.name("password");

    By loginButton = By.xpath("//button[@type='submit']");

    By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    By requiredMessage = By.xpath("//span[text()='Required']");

// Actions

    public void enterUsername(String username){

        log.info("Entering username");

        WaitUtil.waitForVisible(driver, usernameField);

        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);

    }

    public void enterPassword(String password){

        log.info("Entering password");

        WaitUtil.waitForVisible(driver, passwordField);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

    }

    public void clickLogin(){

        log.info("Clicking login button");

        driver.findElement(loginButton).click();

    }

    public void login(String username, String password){

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

    public boolean isErrorDisplayed(){

        log.info("Checking error message");

        return driver.findElement(errorMessage).isDisplayed();

    }

    public boolean isRequiredMessageDisplayed(){

        log.info("Checking required validation");

        return driver.findElement(requiredMessage).isDisplayed();

    }

}