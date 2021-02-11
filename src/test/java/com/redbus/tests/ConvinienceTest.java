package com.redbus.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.ConviniencePage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class ConvinienceTest extends BaseTest {
	
	
	@Test
	public void Convinience() throws InterruptedException {
		String sheetName=prop.getProperty("ConvinienceSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Convinience";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Convinience");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		ConviniencePage conviniencePage = new ConviniencePage(driver);
		conviniencePage.enterNo(testData.get("PhoneNo"));
		Log4jFile1.logger.info("PhoneNo entered.");
		extentTest.log(LogStatus.INFO, "PhoneNo entered.");
		Thread.sleep(2000);
		conviniencePage.SendMeLink();
		Log4jFile1.logger.info("clicked on send me link.");
		extentTest.log(LogStatus.INFO, "clicked on send me link.");
		Thread.sleep(4000);
		conviniencePage.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
