package com.redbus.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*----------------------------------------ManagedBookingPage-------------------------------*/
public class EmailSmsPage {

    //Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public EmailSmsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    /*------------------------------Get the Element that need for test case---------------*/
    @FindBy(how = How.XPATH,using="//*[@id=\"manageHeaderdd\"]/div[2]")
    public WebElement ManageBooking;

    @FindBy(how=How.XPATH,using="//*[@id=\"hmb\"]/div[2]/ul/li[5]")
    public WebElement ClickEmail;
    
    @FindBy(how=How.ID,using="searchTicketTIN")
    public WebElement TicketNo;
    
    @FindBy(how=How.ID,using="searchTicketEmail")
    public WebElement Email;
    
    @FindBy(how=How.ID,using="ticketSearch")
    public WebElement Submit;
    
    @FindBy(how=How.XPATH,using="//*[@id=\"mBWrapper\"]/div[1]/div/div/div[2]/div")
    public WebElement asser;
    
  
    public void Manage_Booking()
    {
        //Action can be performed on ManageBooking element
        ManageBooking.click() ;
    }
    

    public void Click_Email()
    {
        //Action can be performed on ClickEmail element
        ClickEmail.click();
    }
    
    public void sendEmailSms(String ticketNo, String email) {
    	
    	TicketNo.sendKeys(ticketNo);
    	Email.sendKeys(email);
    	Submit.click();
    }
    
    public void Assertion(String ExpectedResult) {
    	
    	String ActualResult = asser.getText().trim();
    	Assert.assertEquals(ActualResult, ExpectedResult);
    }
}

