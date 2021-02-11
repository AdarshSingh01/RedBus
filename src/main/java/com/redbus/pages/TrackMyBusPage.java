package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TrackMyBusPage {
	
	public WebDriver driver;

	public TrackMyBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.LINK_TEXT, using="Know more")
	public WebElement KnowMore;
	

	@FindBy(how = How.NAME, using="tin")
	public WebElement TicketNo;
	
	@FindBy(how = How.NAME, using="EmailId")
	public WebElement Email;
	
	@FindBy(how = How.CLASS_NAME, using="search_btn")
	public WebElement Search;
	
	public void knowMore() {
		KnowMore.click();
	}

	public void enterTicketNo(String key) {
		TicketNo.sendKeys(key);
	}
	
	public void enterEmail(String key) {
		Email.sendKeys(key);
	}
	
	public void Search() {
		Search.click();
	}
	
	public void assertion() {
	
		
	}
}