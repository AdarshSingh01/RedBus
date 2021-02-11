package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RPoolPage {
	
	public WebDriver driver;

	public  RPoolPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using="//*[@id=\"cars\"]")
	public WebElement rPool;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"howItWorks\"]/div/div/div[1]/span[2]")
	public WebElement Active;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[2]")
	public WebElement OfferAride;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[3]/div[2]/span")
	public WebElement ChooseARide;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"howItWorks\"]/div/div/div[2]/div[1]/div[4]/div[2]/span")
	public WebElement GetPoint;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"howItWorks\"]/div/div/h2")
	public WebElement asser;
	
	
	public void Rpool() {
		rPool.click();
		
	}
	
	public void active() {
		Active.click();
		
	}
	
	public void OfferRide() {
		OfferAride.click();
		
	}
	
	public void ChooseRide() {
		ChooseARide.click();
		
	}
	
	public void GetPoint() {
		GetPoint.click();
		
	}
	
	public void Assertion(String ExpectedResult) {
		String ActualResult = asser.getText().trim();
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}

}
