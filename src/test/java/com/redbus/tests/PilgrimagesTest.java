package com.redbus.tests;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.PilgrimagesPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class PilgrimagesTest extends BaseTest {
	
	@Test
	public void Pilgrimages() {
		String sheetName=prop.getProperty("PilgrimagesTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName=" Pilgrimages";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Pilgrimages");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		PilgrimagesPage Pilgrimages = new PilgrimagesPage(driver);
		Pilgrimages.bushire();
		Log4jFile1.logger.info("Clicked on bus hire.");
		extentTest.log(LogStatus.INFO, "Clicked on bus hire.");
		Pilgrimages.Managebooking(); 
		Log4jFile1.logger.info("Clicked on manage booking.");
		extentTest.log(LogStatus.INFO, "Clicked on manage booking.");
		Pilgrimages.cancellation();
		Log4jFile1.logger.info("Clicked on cancellation.");
		extentTest.log(LogStatus.INFO, "Clicked on cancellation.");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Pilgrimages.pilgrimages();
		Log4jFile1.logger.info("Clicked on pilgrimages.");
		extentTest.log(LogStatus.INFO, "Clicked on pilgrimages.");
		Pilgrimages.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
