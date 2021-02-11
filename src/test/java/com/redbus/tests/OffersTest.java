package com.redbus.tests;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.OffersPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class OffersTest extends BaseTest {
	
	@Test
	public void Valid_Offer() {
		String sheetName=prop.getProperty("OfferSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Valid_Offer";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Valid_Offer");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		OffersPage Offer = new OffersPage(driver);
		Offer.bushire();
		Log4jFile1.logger.info("Clicked on bus hire.");
		extentTest.log(LogStatus.INFO, "Clicked on bus hire.");
		Offer.Booking();
		Log4jFile1.logger.info("Clicked on booking.");
		extentTest.log(LogStatus.INFO, "Clicked on booking.");
		Offer.offers();
		Log4jFile1.logger.info("Clicked on offfer.");
		extentTest.log(LogStatus.INFO, "Clicked on offfer.");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Offer.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
		
	}

}
