package com.redbus.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
//import com.redbus.logging.Log4jFile1;
//import com.redbus.logging.Log4jFile1;
import com.redbus.pages.AwardPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class AwardTest extends BaseTest {

	String sheetName=prop.getProperty("CancelBusSheetName");
    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
	@Test
	public void Award_Recognition() throws InterruptedException
	{
	String testName="Award_Recognition";
	String sheetName=prop.getProperty("AwardTestSheetName");
    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
	HashMap<String,String>testData=new HashMap<String,String>();
	testData=reader.getRowTestData(sheetName,testName);
	RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
	extentTest=extent.startTest("Award_Recognition");
	Log4jFile1.logger.info("Test Execution started");
	extentTest.log(LogStatus.INFO, "Test Execution started");
	AwardPage Arp=new AwardPage(driver);
	Arp.Business_Data();
	Log4jFile1.logger.info("Clicked on awards");
	extentTest.log(LogStatus.INFO, "Clicked on awards");
	Log4jFile1.logger.info("Verify the expected result.");
	extentTest.log(LogStatus.INFO, "Verify the expected result.");
	Arp.Assertion(testData.get("ExpectedResult"));
	Log4jFile1.logger.info("Test Passed.");
	extentTest.log(LogStatus.INFO, "Test Passed.");
	Log4jFile1.logger.info("Test end.");
	extentTest.log(LogStatus.INFO, "Test end.");
	}
	
}
