package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CancelTicketPage {
	
	 //Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public CancelTicketPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    
    @FindBy(how = How.XPATH,using="//*[@id=\"manageHeaderdd\"]/div[2]")
    public WebElement ManageBooking;
    

    @FindBy(how = How.XPATH,using="//*[@id=\"hmb\"]/div[2]/ul/li[2]")
    public WebElement CancelBooking;

 

    @FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div/div[2]/div[1]/div[1]/div/input")
    public WebElement EnterTicketNo;

 

    @FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/input")
    public WebElement EnterEmailId;

 

    @FindBy(how=How.XPATH,using="//*[@id=\"root\"]/div/div[2]/div[2]/div")
    public WebElement SelectPassenger;
    
    
    @FindBy(how=How.CLASS_NAME,using="error-message")
    public WebElement Message;
    
    
    public void Manage_Booking()
    {
        //Action can be performed on ManageBooking element
        ManageBooking.click() ;
    }
    
    
    public void Cancel_Booking(String TicketNumber,String EmailId)
    {
        //Action can be performed on CancelBooking element
        CancelBooking.click();
        //Action can be performed on EnterTicketNo element
        EnterTicketNo.sendKeys(TicketNumber);
        //Action can be performed on EnterEmailId element
        EnterEmailId.sendKeys(EmailId);
        //Action can be performed on SelectPassenger element
        SelectPassenger.click();
    }
    
    public void Assertion(String ExpectedMessage) {
    	
    	String ActualMessage = Message.getText().trim();
    	Assert.assertEquals(ActualMessage, ExpectedMessage);
    }
}
