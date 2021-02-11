package com.redbus.tests;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.redbus.logging.Log4jFile1;
import com.redbus.pages.EmailSmsPage;
import com.redbus.utils.ExcelFileIO;
import com.redbus.utils.RequiredExecution;
import com.relevantcodes.extentreports.LogStatus;

public class EmailSmsTest extends BaseTest {

	/*-------------------------Create a Invalid_Email_SMS()-------------------------*/   
	@Test
	public void Invalid_Email_SMS() throws Exception
	{
		String sheetName=prop.getProperty("EmailSmsSheetName");
	    ExcelFileIO reader=new  ExcelFileIO(prop.getProperty("XlSheetPath"));
		String testName="Invalid_Email_SMS";
		HashMap<String,String>testData=new HashMap<String,String>();
		testData=reader.getRowTestData(sheetName,testName);
		RequiredExecution.tocheckExecutionRequired(testData.get("ExecutionRequired"),testName);
		extentTest = extent.startTest("Invalid_Email_SMS");
		Log4jFile1.logger.info("Test Execution Started.");
		extentTest.log(LogStatus.INFO, "Test Execution Started.");
		EmailSmsPage EmailSms=new EmailSmsPage(driver);
		//call the all method from the page class of ManagedBookingPage
		EmailSms.Manage_Booking();
		Log4jFile1.logger.info("Clicked on manage booking.");
		extentTest.log(LogStatus.INFO, "Clicked on manage booking.");
		EmailSms.Click_Email();
		Log4jFile1.logger.info("email entered.");
		extentTest.log(LogStatus.INFO, "email entered.");
		EmailSms.sendEmailSms(testData.get("TicketNo"),testData.get("Email"));
		Log4jFile1.logger.info("Ticket No, Email entered and click on submit.");
		extentTest.log(LogStatus.INFO, "Ticket No, Email and click on submit.");
		EmailSms.Assertion(testData.get("ExpectedResult"));
		Log4jFile1.logger.info("Test Passed.");
		extentTest.log(LogStatus.INFO, "Test Passed.");
		Log4jFile1.logger.info("Test end.");
		extentTest.log(LogStatus.INFO, "Test end.");
	}
}

