package com.redbus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReadGuidelinesPage {
	//Initialize the driver
    WebDriver driver;
    //Create a Constructor with same name of class
    public ReadGuidelinesPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(how = How.XPATH,using="//*[@id=\"redBus Bus Hire\"]")
    public WebElement BusHire;
    
    @FindBy(how = How.XPATH,using="//*[@id=\"reactContentMount\"]/div/div[5]/div[1]/div[6]/div/div/div/div[3]/div/div/div[3]")
    public WebElement KnowMore;
    
    @FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div/div[2]/div[3]/div/button")
    public WebElement Delhi;
    
    @FindBy(how = How.XPATH,using="//*[@id=\"root\"]/div/div[2]/div[3]/div/div/div/div[1]")
    public WebElement asser;
    
    public void bushire()
    {
        //Action can be performed on BusHire element
        BusHire.click();
    }
    public void knowMore()
    {
        //Action can be performed on BusHire element
    	KnowMore.click();
    }
    
    public void readguidelines() {
    	Delhi.click();
    }
    
    public void Assertion(String ExpectedResult) {
    	String ActualResult = asser.getText().trim();
    	Assert.assertEquals(ActualResult, ExpectedResult);
    }
}
