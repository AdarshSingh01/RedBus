package com.redbus.tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.PreRegisterPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class PreRegisterTest extends BaseTest {
	
	@Test
	public void PreRegister() {
		String sheetName=prop.getProperty("PreRegisterTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="PreRegister";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("PreRegister");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		PreRegisterPage preRegister = new PreRegisterPage(driver);
		preRegister.BusTicket();
		Log4jFile1.logger.info("Clicked on bus ticket.");
		extentTest.log(LogStatus.INFO, "Clicked on bus ticket.");
		preRegister.PreRegister();
		Log4jFile1.logger.info("Clicked on bus pre register.");
		extentTest.log(LogStatus.INFO, "Clicked on bus pre register.");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		preRegister.SourcePoint();
		Log4jFile1.logger.info("clicked on Source point.");
		extentTest.log(LogStatus.INFO, "clicked on Source point.");
		preRegister.EnterSourcePoint(testData.get("SourcePoint"));
		Log4jFile1.logger.info("Source point entered.");
		extentTest.log(LogStatus.INFO, "Source point entered.");
		preRegister.ClickSourcePoint();
		Log4jFile1.logger.info("click on point.");
		extentTest.log(LogStatus.INFO, "click on point.");
		preRegister.DestinationPoint();
		Log4jFile1.logger.info("click on destination point.");
		extentTest.log(LogStatus.INFO, "click on destination point.");
		preRegister.EnterDestination(testData.get("DestinationPoint"));
		Log4jFile1.logger.info("Destination point entered.");
		extentTest.log(LogStatus.INFO, "Destination point entered.");
		preRegister.DestinationPoint1();
		Log4jFile1.logger.info("click on destination point.");
		extentTest.log(LogStatus.INFO, "click on destination point.");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		preRegister.EnterEmail(testData.get("Email"));
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		preRegister.EnterPhone(testData.get("Phone"));
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		preRegister.Verify();
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		preRegister.Register();
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		preRegister.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
		
	}

}
