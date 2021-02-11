package com.redbus.tests;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.BusSearchPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class BusSearchTest extends BaseTest {


	@Test
	public void validSearch() throws InterruptedException {
		Log4jFile1.logger.info("TestStarted");
		String sheetName=prop.getProperty("BusSearchSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="validSearch";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("validSearch");
		Log4jFile1.logger.info("Test Execution started");
		extentTest.log(LogStatus.INFO, "Test Execution started");
		BusSearchPage busSearch = new BusSearchPage(driver);
		busSearch.Source(testData.get("Source"));
		Log4jFile1.logger.info("Source Point Entered");
		extentTest.log(LogStatus.INFO, "Source Point Entered");
		busSearch.Destination(testData.get("Destination"));
		Log4jFile1.logger.info("Destination Point Entered");
		extentTest.log(LogStatus.INFO, "Destination Point Entered");
		Thread.sleep(500);
		busSearch.Date();
		Log4jFile1.logger.info("Click on date");
		extentTest.log(LogStatus.INFO, "Click on date");
		Thread.sleep(500);
		busSearch.SelectDate(testData.get("MonthYear"),testData.get("Day"));
		Log4jFile1.logger.info("Entered Date");
		extentTest.log(LogStatus.INFO, "Entered Date");
		busSearch.Search();
		Log4jFile1.logger.info("Clicked on search");
		extentTest.log(LogStatus.INFO, "Clicked on search");
		Thread.sleep(500);
		busSearch.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
		
	}

}
