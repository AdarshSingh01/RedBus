package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.LoginPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {
	
	@Test
	public void Valid_login() throws InterruptedException {
		String sheetName=prop.getProperty("LoginSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Valid_login";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Valid_login");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		LoginPage loginPage=new LoginPage(driver);
        //call the all method from the page class of SigninPage
        loginPage.Clicksignin();
        Log4jFile1.logger.info("Clicked on signin.");
		extentTest.log(LogStatus.INFO, "Clicked on signin.");
        loginPage.Signin();
        Log4jFile1.logger.info("Clicked on facebook.");
		extentTest.log(LogStatus.INFO, "Clicked on facebook.");
        loginPage.SwitchTabs(testData.get("Email"),testData.get("Pass"));
        Log4jFile1.logger.info("Email and password entered.");
		extentTest.log(LogStatus.INFO, "Email and password entered.");
        loginPage.Click_close();
        Log4jFile1.logger.info("Close the child window.");
		extentTest.log(LogStatus.INFO, "Close the child window");
        String title=driver.getTitle();
        Assert.assertEquals(title,testData.get("ExpectedResult"));
        Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
