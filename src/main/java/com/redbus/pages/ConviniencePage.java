package com.redbus.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConviniencePage {
	
	WebDriver driver;

	public  ConviniencePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.ID, using="smsTXTBOX")
	public WebElement TextBox;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"sendLinkButton\"]")
	public WebElement SendLink;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"failure\"]")
	public WebElement ErrorMessage;
	
	public void enterNo(String No) {
		TextBox.sendKeys(No);
		
	}
	
	public void SendMeLink() {
		SendLink.click();
		
	}
	
	public void Assertion(String ExpectedMessage) {
		String ActualMessage = ErrorMessage.getText().trim();
		assertEquals(ActualMessage, ExpectedMessage);
		
	}

}
