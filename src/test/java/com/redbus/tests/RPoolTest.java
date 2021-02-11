package com.redbus.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.RPoolPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class RPoolTest extends BaseTest {

	@Test
	public void RPool() throws InterruptedException {
		String sheetName=prop.getProperty("RPoolTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="RPool";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("RPool");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		RPoolPage rpool = new RPoolPage(driver);
		rpool.Rpool();
		Log4jFile1.logger.info("clicked on rpool");
		extentTest.log(LogStatus.INFO, "clicked on rpool");
		rpool.active();
		Log4jFile1.logger.info("Clicked on active.");
		extentTest.log(LogStatus.INFO, "Clicked on active.");
		rpool.OfferRide();
		Log4jFile1.logger.info("Clicked on offer ride.");
		extentTest.log(LogStatus.INFO, "Clicked on offer ride.");
		rpool.ChooseRide();
		Log4jFile1.logger.info("Clicked on choose offer ride.");
		extentTest.log(LogStatus.INFO, "Clicked on choose offer ride.");
		rpool.GetPoint();
		Log4jFile1.logger.info("Clicked on get point.");
		extentTest.log(LogStatus.INFO, "Clicked on get point.");
		rpool.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
		
	}
	
}
