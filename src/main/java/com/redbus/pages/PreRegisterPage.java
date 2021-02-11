package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PreRegisterPage {
	
	WebDriver driver;
	public PreRegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH,using="//*[@id=\"redBus\"]")
	public WebElement busTicket;
	
	@FindBy(how = How.ID,using="D120_splus")
	public WebElement preRegister;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div[2]/div/div[4]/div[1]/div[2]/div")
	public WebElement source;
	
	@FindBy(how = How.ID,using="suggestInput")
	public WebElement sourcePoint;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"sourceCity\"]/div/div[3]/ul/li[2]")
	public WebElement Srcpnt;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div[2]/div/div[4]/div[3]/div[2]/div")
	public WebElement Destination;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"suggestInput\"]")
	public WebElement Destination1;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"destinationCity\"]/div/div[3]/ul/li[2]")
	public WebElement Destination2;
	
	@FindBy(how = How.NAME,using="emailId")
	public WebElement Email;
	
	@FindBy(how = How.NAME,using="mobileNo")
	public WebElement Phone;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div[2]/div/div[6]/div[2]/div[1]/button")
	public WebElement verify;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div[2]/div/div[8]/button")
	public WebElement register;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div[1]/span/div/span")
	public WebElement asser;

	
	
	public void BusTicket() {
		busTicket.click();
		
	}
	
	public void PreRegister() {
		preRegister.click();
		
	}
	
	public void SourcePoint() {
		source.click();
		
	}
	
	public void EnterSourcePoint(String key) {
		sourcePoint.sendKeys(key);
		
	}
	
	public void ClickSourcePoint() {
		Srcpnt.click();
		
	}
	
	public void DestinationPoint() {
		Destination.click();
		
	}
	
	public void EnterDestination(String key) {
		Destination1.sendKeys(key);
		
	}
	
	public void DestinationPoint1() {
		Destination2.click();
		
	}
	
	public void EnterEmail(String key) {
		Email.sendKeys(key);
		
	}
	
	public void EnterPhone(String key) {
		Phone.sendKeys(key);
		
	}
	
	public void Verify() {
		verify.click();
		
	}
	
	public void Register() {
		register.click();
		
	}
	
	public void Assertion(String ExpectedHeading) {
		String ActualHeading = asser.getText().trim();
		System.out.println(ActualHeading);
		Assert.assertEquals(ActualHeading, ExpectedHeading);
		
	}
	
}
