package com.redbus.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BusSearchPage {

	WebDriver driver;

	public  BusSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using="src")
	public WebElement from;

	@FindBy(how = How.ID, using="dest")
	public WebElement to;	

	@FindBy(how = How.ID, using="onward_cal")
	public WebElement date ;
	
	@FindBy(how = How.ID, using="search_btn")
	public WebElement searchBtn;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"mBWrapper\"]/section/div/ul/li[4]/h1")
	public WebElement asser;
    
	@FindBy(how = How.XPATH, using = ".//*[@id='search']/div/div[1]/div/ul/li[1]")
	public WebElement srcSend;
	
	@FindBy(how = How.ID, using = "dest")
	public WebElement destElement;

	
	public void SelectDate(String monthyear, String Selectday) throws InterruptedException {
			List<WebElement> elements = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
			for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(monthyear)) {
			List<WebElement> days = driver.findElements(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[3]"));
			for (WebElement d : days) {
			if (d.getText().equals(Selectday)) {
			d.click();
			Thread.sleep(100);
			return;
			}
			}
			}
			}
			driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();
			}

	public void Source(String SorcePlace) {
		from.sendKeys(SorcePlace);
		srcSend.click();

	}

	public void Destination(String DestinationPlace) {
		to.sendKeys(DestinationPlace);
		destElement.click();

	}

	public void Date() {
		date.click();

	}
	
	public void Search() {
		searchBtn.click();
	}

	public void Assertion(String ExpectedResult) {	
		String ActualResult = asser.getText().trim();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
}
