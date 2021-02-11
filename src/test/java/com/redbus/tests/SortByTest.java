package com.redbus.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.SortByPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class SortByTest extends BaseTest
{
	
	@Test
	public void Sort_By()throws Exception
	{
		String sheetName=prop.getProperty("SortByTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Sort_By";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Sort_By");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		SortByPage SortBy = new SortByPage(driver);
		SortBy.Trip_Details(testData.get("Source"),testData.get("Destination"));
		Log4jFile1.logger.info("Source point and destination point entered.");
		extentTest.log(LogStatus.INFO, "Source point and destination point entered.");
		SortBy.SelectDate(testData.get("MonthYear"), testData.get("Day"));
		Log4jFile1.logger.info("Month, year and day entered.");
		extentTest.log(LogStatus.INFO, "Month, year and day entered.");
		SortBy.Search();
		Log4jFile1.logger.info("Clicked on search.");
		extentTest.log(LogStatus.INFO, "Clicked on search.");
		SortBy.Sortbus();
		Log4jFile1.logger.info("Clicked on sort by.");
		extentTest.log(LogStatus.INFO, "Clicked on sort by.");
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle,testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

	
}