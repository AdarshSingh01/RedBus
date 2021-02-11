package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.TrackMyBusPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class TrackMyBusTest extends BaseTest {
	
	
	@Test
	public void TrackBus() throws InterruptedException {
		String sheetName=prop.getProperty("TrackMyBusTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="TrackBus";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("TrackBus");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		TrackMyBusPage trackBus = new TrackMyBusPage(driver);
		trackBus.knowMore();
		Log4jFile1.logger.info("Clicked on knowmore.");
		extentTest.log(LogStatus.INFO, "Clicked on knowmore.");
		Thread.sleep(2000);
		trackBus.enterTicketNo(testData.get("TicketNo"));
		Log4jFile1.logger.info("Ticket no entered.");
		extentTest.log(LogStatus.INFO, "Ticket no entered");
		Thread.sleep(2000);
		trackBus.enterEmail(testData.get("Email"));
		Log4jFile1.logger.info("Email entered.");
		extentTest.log(LogStatus.INFO, "Email entered.");
		Thread.sleep(2000);
		trackBus.Search();
		Log4jFile1.logger.info("Clicked on search.");
		extentTest.log(LogStatus.INFO, "Clicked on search.");
		Assert.assertFalse(driver.getTitle().contains(testData.get("ExpectedResult")));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
		
	}

}
