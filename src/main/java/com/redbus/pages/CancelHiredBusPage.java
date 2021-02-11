package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CancelHiredBusPage {
	
	//Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public CancelHiredBusPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(how = How.XPATH,using="//*[@id=\"redBus Bus Hire\"]")
    public WebElement BusHire;

 

    @FindBy(how = How.XPATH,using="//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[1]/div/img")
    public WebElement ManageBooking;
    
    @FindBy(how = How.XPATH,using="//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]")
    public WebElement Cancel_Bus;

    @FindBy(how = How.XPATH,using="//*[@id=\"Bookid\"]")
    public WebElement BookingId; 
    
    @FindBy(how = How.ID,using="phoneNum")
    public WebElement PhoneNo; 

    @FindBy(how = How.ID,using="veribtn")
    public WebElement Verify;
    
    @FindBy(how = How.ID,using="DataErr")
    public WebElement asser;
    
    public void bushire()
    {
        //Action can be performed on BusHire element
        BusHire.click();
    }
    public void Managebooking()
    {
        //Action can be performed on ManageBooking element
        ManageBooking.click();
    }
    
    public void cancellation()
    {
        //Action can be performed on Cancel_Trip element
        Cancel_Bus.click();
    }
    
    public void EnterBookingId(String Id)
    {
        //Action can be performed on enterBookingId
    	BookingId.sendKeys(Id);
    }
    
    public void EnterPhoneNo(String Mob)
    {
        //Action can be performed on enter no
    	PhoneNo.sendKeys(Mob);
    }
    
    public void ClickOnVerify()
    {
    	Verify.click();
    }
    
    public void Assertion(String ExpectedResult)
    {
    	String ActualResult = asser.getText().trim();
    	Assert.assertEquals(ActualResult, ExpectedResult);
    
    }
    
}
