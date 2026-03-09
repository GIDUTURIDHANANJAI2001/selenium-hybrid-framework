package tests;

import base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pages.LoginPage;

import pages.PIMPage;

import utilities.TestDataUtil;

public class PIMTests extends BaseTest {

    PIMPage pim;

    @BeforeMethod

    public void loginBeforeTest() {

        LoginPage login = new LoginPage(getDriver());

        login.login("Admin", "admin123");

        pim = new PIMPage(getDriver());

    }

    // TC11 Navigate to PIM

    @Test

    public void TC11_navigateToPIM(){

        pim.clickPIM();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("pim"));

    }

    // TC12 Open Add Employee Page

    @Test

    public void TC12_openAddEmployeePage(){

        pim.clickPIM();

        pim.clickAddEmployee();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("addEmployee"));

    }

    // TC13 Enter First Name

    @Test

    public void TC13_enterFirstName(){

        pim.clickPIM();

        pim.clickAddEmployee();

        String firstName = TestDataUtil.generateFirstName();

        pim.enterFirstName(firstName);

    }

    // TC14 Enter Last Name

    @Test

    public void TC14_enterLastName(){

        pim.clickPIM();

        pim.clickAddEmployee();

        String firstName = TestDataUtil.generateFirstName();

        String lastName = TestDataUtil.generateLastName();

        pim.enterFirstName(firstName);

        pim.enterLastName(lastName);

    }

    // TC15 Save Employee

    @Test

    public void TC15_saveEmployee(){

        pim.clickPIM();

        pim.clickAddEmployee();

        String firstName = TestDataUtil.generateFirstName();

        String lastName = TestDataUtil.generateLastName();

        String empId = TestDataUtil.generateEmployeeId();

        pim.enterFirstName(firstName);

        pim.enterLastName(lastName);

        pim.enterEmployeeId(empId);

        pim.clickSave();

        Assert.assertTrue(pim.isPersonalDetailsDisplayed());

    }

    // TC16 Verify Personal Details Page

    @Test

    public void TC16_verifyPersonalDetailsPage(){

        pim.clickPIM();

        pim.clickAddEmployee();

        String firstName = TestDataUtil.generateFirstName();

        String lastName = TestDataUtil.generateLastName();

        String empId = TestDataUtil.generateEmployeeId();

        pim.enterFirstName(firstName);

        pim.enterLastName(lastName);

        pim.enterEmployeeId(empId);

        pim.clickSave();

        Assert.assertTrue(pim.isPersonalDetailsDisplayed());

    }

    // TC17 Navigate to Employee List

    @Test

    public void TC17_navigateToEmployeeList(){

        pim.clickPIM();

        pim.clickEmployeeList();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("viewEmployeeList"));

    }

    // TC18 Search Employee

    @Test

    public void TC18_searchEmployee(){

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee("Dhanu");

        pim.clickSearch();

    }

    // TC19 Verify Employee Search

    @Test

    public void TC19_verifyEmployeeSearch(){

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee("Dhanu");

        pim.clickSearch();

    }

    // TC20 Delete Employee

    @Test

    public void TC20_deleteEmployee(){

        pim.clickPIM();

        pim.clickAddEmployee();

        String firstName = TestDataUtil.generateFirstName();

        String lastName = TestDataUtil.generateLastName();

        String empId = TestDataUtil.generateEmployeeId();

        pim.enterFirstName(firstName);

        pim.enterLastName(lastName);

        pim.enterEmployeeId(empId);

        pim.clickSave();

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee(firstName + " " + lastName);

        pim.clickSearch();

        pim.deleteEmployee();

    }

}
