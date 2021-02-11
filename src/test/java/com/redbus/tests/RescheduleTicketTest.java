package com.redbus.tests;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.RescheduleTicketPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class RescheduleTicketTest extends BaseTest {
	
	
	@Test
	public void Invalid_ReSchedule() throws Exception
	{
		String sheetName=prop.getProperty("RescheduleTicketTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Invalid_ReSchedule";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Invalid_ReSchedule");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		RescheduleTicketPage RescheduleTicket=new RescheduleTicketPage(driver);
		//call the all method from the page class of ManagedBookingPage
		RescheduleTicket.Manage_Booking();
		Log4jFile1.logger.info("Click on manage booking.");
		extentTest.log(LogStatus.INFO, "Click on manage booking.");
		RescheduleTicket.Reschedule(testData.get("TicketNo"),testData.get("Email"));
		Log4jFile1.logger.info("Ticket no and email id entered.");
		extentTest.log(LogStatus.INFO, "Ticket no and email id entered.");
		Thread.sleep(500);
		RescheduleTicket.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
