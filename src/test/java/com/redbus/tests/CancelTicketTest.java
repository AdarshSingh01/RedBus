package com.redbus.tests;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.CancelTicketPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class CancelTicketTest extends BaseTest {
	
	
	@Test
	public void Invalid_Cancel() throws Exception
	{
		String sheetName=prop.getProperty("CancelTicketSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Invalid_Cancel";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Invalid_Cancel");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		CancelTicketPage CancelTicket=new CancelTicketPage(driver);
		//call the all method from the page class of ManagedBookingPage
		CancelTicket.Manage_Booking();
		Log4jFile1.logger.info("Clicked on manage booking.");
		extentTest.log(LogStatus.INFO, "Clicked on manage booking.");
		CancelTicket.Cancel_Booking(testData.get("TicketNo"),testData.get("Email"));
		Log4jFile1.logger.info("Ticket No and Email entered.");
		extentTest.log(LogStatus.INFO, "Clicked on manage booking.");
		Thread.sleep(500);
		CancelTicket.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
