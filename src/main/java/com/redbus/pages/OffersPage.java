package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OffersPage {
	
	//Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public OffersPage(WebDriver driver)
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

    @FindBy(how = How.XPATH,using="//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[2]/div/img[2]")
    public WebElement MngBooking;
    
    @FindBy(how = How.XPATH,using="//*[@id=\"reactContentMount\"]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div[2]/div[2]")
    public WebElement offers;
    
    @FindBy(how = How.CLASS_NAME,using="heading")
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
    
    public void Booking()
    {
        //Action can be performed on Cancel_Trip element
        MngBooking.click();
    }
    
    public void offers() {
    	offers.click();
    }
    
    public void Assertion(String ExpectedResult) {
    	String ActualResult = asser.getText().trim();
    	Assert.assertEquals(ActualResult, ExpectedResult);
    	
    }
}
