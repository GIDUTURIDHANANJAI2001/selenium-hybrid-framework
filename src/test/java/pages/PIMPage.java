package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilities.WaitUtil;

import java.time.Duration;

public class PIMPage {

    WebDriver driver;

    private static final Logger log = LogManager.getLogger(PIMPage.class);

    public PIMPage(WebDriver driver){
        this.driver = driver;
    }

// Locators

    By pimMenu = By.xpath("//span[text()='PIM']");

    By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");

    By firstNameField = By.name("firstName");

    By lastNameField = By.name("lastName");

    By employeeIdField = By.xpath("//label[text()='Employee Id']/../following-sibling::div/input");

    By saveButton = By.xpath("//button[@type='submit']");

    By employeeListTab = By.xpath("//a[text()='Employee List']");

    By employeeNameSearch = By.xpath("//input[@placeholder='Type for hints...']");

    By searchButton = By.xpath("//button[normalize-space()='Search']");

    By deleteIcon = By.xpath("//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'trash')]");


// Actions

    public void clickPIM(){

        log.info("Clicking PIM menu");

        driver.findElement(pimMenu).click();

    }

    public void clickAddEmployee(){

        log.info("Clicking Add Employee");

        WaitUtil.waitForVisible(driver,addEmployeeBtn);

        driver.findElement(addEmployeeBtn).click();

    }

    public void enterFirstName(String firstName){

        log.info("Entering First Name: " + firstName);

        driver.findElement(firstNameField).sendKeys(firstName);

    }

    public void enterLastName(String lastName){

        log.info("Entering Last Name: " + lastName);

        driver.findElement(lastNameField).sendKeys(lastName);

    }

    public void enterEmployeeId(String id){

        log.info("Entering Employee ID: " + id);

        driver.findElement(employeeIdField).clear();

        driver.findElement(employeeIdField).sendKeys(id);

    }

    public void clickSave(){

        log.info("Clicking Save button");

        driver.findElement(saveButton).click();

    }

    public boolean isPersonalDetailsDisplayed(){

        log.info("Verifying Personal Details page");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));

        return driver.getCurrentUrl().contains("viewPersonalDetails");

    }

    public void clickEmployeeList(){

        log.info("Opening Employee List");

        driver.findElement(employeeListTab).click();

    }

    public void searchEmployee(String name){

        log.info("Searching Employee: " + name);

        driver.findElement(employeeNameSearch).sendKeys(name);

    }

    public void clickSearch(){

        log.info("Clicking Search button");

        driver.findElement(searchButton).click();

    }

    public void deleteEmployee(){

        log.info("Deleting employee");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();

    }

}