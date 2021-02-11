package com.redbus.tests;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.CancelHiredBusPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class CancelHiredBusTest extends BaseTest {
	
	
	@Test
	public void Invalid_Cancellation() throws Exception
	{
		String sheetName=prop.getProperty("CancelBusSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Invalid_Cancellation";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Invalid_Cancellation");
		Log4jFile1.logger.info("Test Execution started");
		extentTest.log(LogStatus.INFO, "Test Execution started");
		CancelHiredBusPage cancelBus = new CancelHiredBusPage(driver);
		cancelBus.bushire();
		Log4jFile1.logger.info("Click on bushire");
		extentTest.log(LogStatus.INFO, "Click on bushire");
		cancelBus.Managebooking(); 
		Log4jFile1.logger.info("Click on Manage booking");
		extentTest.log(LogStatus.INFO, "Click on Manage booking");
		cancelBus.cancellation();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(1000);
		cancelBus.EnterBookingId(testData.get("BookingId"));
		Log4jFile1.logger.info("BookingId entered. ");
		extentTest.log(LogStatus.INFO, "BookingId entered.");
		cancelBus.EnterPhoneNo(testData.get("PhoneNo"));
		Log4jFile1.logger.info("PhoneNo entered.");
		extentTest.log(LogStatus.INFO, "PhoneNo entered.");
		cancelBus.ClickOnVerify();
		Log4jFile1.logger.info("Click on verify.");
		extentTest.log(LogStatus.INFO, "Click on verify.");
		cancelBus.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
