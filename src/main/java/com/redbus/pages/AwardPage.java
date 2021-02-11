package com.redbus.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AwardPage {

	public WebDriver driver;

	public AwardPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"awards_div\"]/section/div/div[2]/div[2]/a/div/div[1]")
	public WebElement Click_Award;

	@FindBy(how=How.ID,using="menu-item-831")
	public WebElement Home;

	@FindBy(how=How.ID,using="site-title")
	public WebElement Asseration;

	public void Business_Data() throws InterruptedException
	{
		Click_Award.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Home.click();       
	}
	public void Assertion(String ExpectedResult)
	{
		String ActualResult = Asseration.getText().trim();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}   

}
