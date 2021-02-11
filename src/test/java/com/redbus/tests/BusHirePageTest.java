package com.redbus.tests;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.BusHirePage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;


public class BusHirePageTest extends BaseTest{

	// WorkSheet Name used by all tests
	private String sheetName = prop.getProperty("busHirePageSheetName");

	// test case for valid out-station info
	@Test()
	public void whenUserEntersValidInformationForOutstation() {
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="InformationForOutstation";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("whenUserEntersValidInformationForOutstation");
		String pickUpLocation = testData.get("Pickup Location");
		String destinationLocation = testData.get("Destination Location");
		String numberOfPassengers = testData.get("Number of Passengers");
		String fromDateAndTimeVal = testData.get("From Date and Time");
		String tillDateAndTimeVal = testData.get("Till Date and Time");
		String expectedResult = testData.get("Expected Result");

		BusHirePage busHirePage = new BusHirePage(driver);


		busHirePage.clickOnBusHireLink();
		Log4jFile1.logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnOutstationMenu();
		Log4jFile1.logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");

		busHirePage.enterPickUpLocation(pickUpLocation);
		Log4jFile1.logger.info(pickUpLocation+" location was entered");
		extentTest.log(LogStatus.INFO, pickUpLocation+" location was entered");

		busHirePage.enterDropLocation(destinationLocation);
		Log4jFile1.logger.info(destinationLocation+" location was entered");
		extentTest.log(LogStatus.INFO, destinationLocation+" location was entered");

		busHirePage.enterDateAndTimeForOutstation(fromDateAndTimeVal, tillDateAndTimeVal);;
		Log4jFile1.logger.info(fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");
		extentTest.log(LogStatus.INFO, fromDateAndTimeVal+" and "+tillDateAndTimeVal+" was entered");

		busHirePage.enterNumberOfPassengers(numberOfPassengers);
		Log4jFile1.logger.info(numberOfPassengers+" was entered");
		extentTest.log(LogStatus.INFO, numberOfPassengers+" was entered");

		busHirePage.clickOnProceedButtonOnOutstationMenu();
		Log4jFile1.logger.info("Proceed Button was clicked");
		extentTest.log(LogStatus.INFO, "Proceed Button was clicked");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabelsummary']")).getText().toLowerCase();
		Log4jFile1.logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");

		// ----------------------- Test Ends --------------------------------------------------
	}
	
	@Test
	public void whenUserEntersClickOnOutstation() {
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="InformationForOutstation";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("whenUserEntersValidInformationForOutstation");
		String expectedResult = testData.get("Expected Result");
		BusHirePage busHirePage = new BusHirePage(driver);
		busHirePage.clickOnBusHireLink();
		Log4jFile1.logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");
		busHirePage.clickOnOutstationMenu();
		Log4jFile1.logger.info("OutStation Menu was selected");
		extentTest.log(LogStatus.INFO, "OutStation Menu was selected");
		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabelsummary']")).getText().toLowerCase();
		Log4jFile1.logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");

		// ----------------------- Test Ends --------------------------------------------------
	}
	
	// test case for LocalMenu
	@Test()
	public void whenUserClickedOnLocalMenu() {
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="whenUserClickedOnLocalMenu";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("whenUserClickedOnLocalMenu");
		String expectedResult = testData.get("Expected Result");

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		busHirePage.clickOnBusHireLink();
		Log4jFile1.logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnLocalMenu();
		
		Log4jFile1.logger.info("Local Menu was selected");
		extentTest.log(LogStatus.INFO, "Local Menu was selected");

		String actualResult = driver.findElement(By.xpath("//*[@class = 'headerlabel']")).getText().toLowerCase();
		Log4jFile1.logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertTrue(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}

	// test case for AirportMenu
	@Test()
	public void whenUserClickedOnAirportMenu() {
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="whenUserClickedOnAirportMenu";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("whenUserClickedOnAirportMenu");
		String expectedResult = testData.get("Expected Result");

		// Test
		BusHirePage busHirePage = new BusHirePage(driver);

		busHirePage.clickOnBusHireLink();;
		Log4jFile1.logger.info("Bus Hire link was clicked");
		extentTest.log(LogStatus.INFO, "Bus Hire link was clicked");

		busHirePage.clickOnAirportMenu();
		Log4jFile1.logger.info("Airport Menu was selected");
		extentTest.log(LogStatus.INFO, "Airport Menu was selected");

		String actualResult = driver.findElement(By.xpath("//*[@id=\"airport_back_btn\"]/div")).getText().toLowerCase();
		Log4jFile1.logger.info("Actual Result : "+actualResult);
		extentTest.log(LogStatus.INFO, "Actual Result : "+actualResult);

		Assert.assertFalse(actualResult.contains(expectedResult.toLowerCase()), "Assertion on actual and expected result of header summary label");
		// ----------------------- Test Ends --------------------------------------------------
	}
}

