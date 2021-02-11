package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RescheduleTicketPage {
	
	//Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public RescheduleTicketPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    
    /*------------------------------Get the Element that need for test case---------------*/
    @FindBy(how = How.XPATH,using="//*[@id=\"manageHeaderdd\"]/div[2]")
    public WebElement ManageBooking;
    
    @FindBy(how=How.XPATH,using="//*[@id=\"hmb\"]/div[2]/ul/li[3]")
    public WebElement ReSchedule;

    @FindBy(how=How.XPATH,using="//*[@id=\"searchTicket\"]")
    public WebElement ReScheduleTicketNo;

    @FindBy(how=How.XPATH,using="//*[@id=\"searchEmail\"]")
    public WebElement ReScheduleEmailId;

    @FindBy(how=How.XPATH,using="//*[@id=\"ticketSearch\"]")
    public WebElement Search;
    
    @FindBy(how=How.ID,using="nf_error")
    public WebElement Error;
       
    public void Manage_Booking()
    {
        //Action can be performed on ManageBooking element
        ManageBooking.click() ;
    }
    
    public void Reschedule(String TicketNo,String Email)
    {
        //Action can be performed on ReSchedule element
        ReSchedule.click();
        //Action can be performed on ReScheduleTicketNo element
        ReScheduleTicketNo.sendKeys(TicketNo);
        //Action can be performed on ReScheduleEmailId element
        ReScheduleEmailId.sendKeys(Email);
        //Action can be performed on Search element
        Search.click();
    }

    public void Assertion(String ExpectedResult) {
    	
    	String ActualResult = Error.getText().trim();
    	Assert.assertEquals(ActualResult, ExpectedResult);
    	
    }
}
