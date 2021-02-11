package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShowMyTicketPage {
	
	 //Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public ShowMyTicketPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }
    /*------------------------------Get the Element that need for test case---------------*/
    @FindBy(how = How.XPATH,using="//*[@id=\"manageHeaderdd\"]/div[2]")
    public WebElement ManageBooking;
    

    @FindBy(how=How.XPATH,using="//*[@id=\"hmb\"]/div[2]/ul/li[4]")
    public WebElement ShowMyTicket;

    
    @FindBy(how=How.XPATH,using="//*[@id=\"searchTicketTIN\"]")
    public WebElement EnterMyTicket;

    @FindBy(how=How.XPATH,using="//*[@id=\"searchTicketEmail\"]")
    public WebElement EnterMyTicketEmail;

    @FindBy(how=How.XPATH,using="//*[@id=\"ticketSearch\"]")
    public WebElement ClickSubmit;
    
    @FindBy(how=How.XPATH,using="//*[@id=\"mBWrapper\"]/table/tbody/tr/td/table[1]/tbody/tr[2]/td[2]")
    public WebElement heading;
    
    public void Manage_Booking()
    {
        //Action can be performed on ManageBooking element
        ManageBooking.click() ;
    }
    
    
    public void Show_Ticket() 
    {
        //Action can be performed on ShowMyTicket element
        ShowMyTicket.click();
    }
    
    public void Show_My_Ticket(String TicketNo,String Email)
    {
        //Action can be performed on EnterMyTicket element
        EnterMyTicket.sendKeys(TicketNo);
        //Action can be performed on EnterMyTicketEmail element
        EnterMyTicketEmail.sendKeys(Email);
        //Action can be performed on ClickSubmit element
        ClickSubmit.click();
    }

    public void assertion(String ExpectedHeading) {
    	
    	String ActualHeading = heading.getText().trim();
    	Assert.assertEquals(ActualHeading, ExpectedHeading);
    }
}
