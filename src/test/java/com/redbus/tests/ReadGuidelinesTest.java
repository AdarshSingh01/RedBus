package com.redbus.tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.ReadGuidelinesPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class ReadGuidelinesTest extends BaseTest{
	
	@Test
	public void ReadGuidelines() {
		String sheetName=prop.getProperty("ReadGuidelinesTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="ReadGuidelines";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("ReadGuidelines");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		ReadGuidelinesPage ReadGuides= new ReadGuidelinesPage(driver);
		ReadGuides.bushire();
		Log4jFile1.logger.info("Click on bus hire.");
		extentTest.log(LogStatus.INFO, "Click on bus hire.");
		ReadGuides.knowMore();
		Log4jFile1.logger.info("Click on knowmore.");
		extentTest.log(LogStatus.INFO, "Click on knowmore.");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		ReadGuides.readguidelines();
		Log4jFile1.logger.info("Click on delhi.");
		extentTest.log(LogStatus.INFO, "Click on delhi.");
		ReadGuides.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
		
	}

}
