package com.redbus.tests;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.ShowMyTicketPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class ShowMyTicketTest extends BaseTest {
	
	@Test
	public void valid_Show_MyTicket() throws Exception
	{
		String sheetName=prop.getProperty("ShowMyTicketTestSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="valid_Show_MyTicket";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("valid_Show_MyTicket");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		ShowMyTicketPage ShowTicket=new ShowMyTicketPage(driver);
		//call the all method from the page class of ManagedBookingPage
		ShowTicket.Manage_Booking();
		Log4jFile1.logger.info("Click on manage booking.");
		extentTest.log(LogStatus.INFO, "Click on manage booking.");
		ShowTicket.Show_Ticket();
		Log4jFile1.logger.info("Clicked on show ticket.");
		extentTest.log(LogStatus.INFO, "Clicked on show ticket.");
		ShowTicket.Show_My_Ticket(testData.get("TicketNo"),testData.get("Email"));
		Log4jFile1.logger.info("Ticket no and email entered.");
		extentTest.log(LogStatus.INFO, "Ticket no and email entered.");
		ShowTicket.assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}

}
