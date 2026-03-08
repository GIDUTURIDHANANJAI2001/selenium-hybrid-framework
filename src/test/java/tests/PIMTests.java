package tests;

import base.BaseTest;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PIMPage;

public class PIMTests extends BaseTest {

    PIMPage pim;

    @BeforeMethod
    public void loginBeforeTest() {

        LoginPage login = new LoginPage(getDriver());

        login.login("Admin", "admin123");

        pim = new PIMPage(getDriver());

    }

    // TC01 Navigate to PIM
    @Test
    public void TC11_navigateToPIM(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("pim"));

    }

    // TC02 Open Add Employee Page
    @Test
    public void TC12_openAddEmployeePage(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickAddEmployee();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("addEmployee"));

    }

    // TC03 Enter First Name
    @Test
    public void TC13_enterFirstName(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickAddEmployee();

        pim.enterFirstName("Apex");

    }

    // TC04 Enter Last Name
    @Test
    public void TC14_enterLastName(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickAddEmployee();

        pim.enterFirstName("Apex");

        pim.enterLastName("Tester");

    }

    // TC05 Save Employee
    @Test
    public void TC15_saveEmployee(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickAddEmployee();

        pim.enterFirstName("Apex");

        pim.enterLastName("Tester");

        String empId = String.valueOf((int)(Math.random()*900000)+100000);

        pim.enterEmployeeId(empId);

        pim.clickSave();

        Assert.assertTrue(pim.isPersonalDetailsDisplayed());

    }

    // TC06 Verify Personal Details Page
    @Test
    public void TC16_verifyPersonalDetailsPage(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickAddEmployee();

        pim.enterFirstName("John");

        pim.enterLastName("Doe");

        String empId = String.valueOf((int)(Math.random()*900000)+100000);

        pim.enterEmployeeId(empId);

        pim.clickSave();

        Assert.assertTrue(pim.isPersonalDetailsDisplayed());

    }

    // TC07 Navigate to Employee List
    @Test
    public void TC17_navigateToEmployeeList(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickEmployeeList();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("viewEmployeeList"));

    }

    // TC08 Search Employee
    @Test
    public void TC18_searchEmployee(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee("Apex");

        pim.clickSearch();

    }

    // TC09 Verify Employee Search
    @Test
    public void TC19_verifyEmployeeSearch(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee("Apex");

        pim.clickSearch();

    }

    // TC10 Delete Employee
    @Test
    public void TC20_deleteEmployee(){

        PIMPage pim = new PIMPage(getDriver());

        pim.clickPIM();

        pim.clickEmployeeList();

        pim.searchEmployee("Dhanu Apex");

        pim.clickSearch();

        pim.deleteEmployee();

    }

}