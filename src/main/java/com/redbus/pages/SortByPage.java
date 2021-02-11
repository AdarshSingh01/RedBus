package com.redbus.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class SortByPage 
{
	WebDriver driver;
	public SortByPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(how = How.XPATH,using="//input[@id='src']")
	public WebElement FromLocation;

	@FindBy(how = How.XPATH,using=".//*[@id='search']/div/div[1]/div/ul/li[1]")
	public WebElement From;



	@FindBy(how = How.ID,using="dest")
	public WebElement ToLocation;



	@FindBy(how = How.XPATH,using=".//*[@id='search']/div/div[2]/div/ul/li[1]")
	public WebElement dest;

	@FindBy(how = How.ID, using="onward_cal")
	public WebElement date ;

	@FindBy(how=How.ID,using="search_btn")
	public WebElement SearchButton;

	@FindBy(how=How.XPATH,using="//*[@id=\"filter-block\"]/div/div[2]/ul[1]/li[1]/i[2]")
	public WebElement SortBus;

	@FindBy(how=How.XPATH,using="//*[@id=\"fixer\"]/div/div/div[2]")
	public WebElement Modify_Details;

	@FindBy(how=How.XPATH,using="//*[@id=\"src\"]")
	public WebElement ModifyFromLocation;

	@FindBy(how=How.ID,using="src")
	public WebElement ModifyFrom;

	@FindBy(how=How.XPATH,using="//*[@id=\"dest\"]")
	public WebElement Modify_ToLocation;

	@FindBy(how=How.ID,using="dest")
	public WebElement Modify_dest;

	@FindBy(how=How.ID,using="rb-month")
	public WebElement ModifyDay;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"fixer\"]/section/div/div[4]/button")
	public WebElement search;
	
	public void SelectDate(String monthyear, String Selectday) throws InterruptedException 
	{
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
		for (int i = 0; i < elements.size(); i++) 
		{
			// Selecting the month
			if (elements.get(i).getText().equals(monthyear)) 
			{
				// Selecting the date
				List<WebElement> days = driver
						.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
				for (WebElement d : days) 
				{
					//System.out.println(d.getText());
					if (d.getText().equals(Selectday)) 
					{
						d.click();
						Thread.sleep(1000);
						return;
					}
				}
			}
		}
	}
	public void Trip_Details(String Location,String location)
	{
		FromLocation.sendKeys(Location);
		From.click();
		ToLocation.sendKeys(location);
		dest.click();

	}
	
	public void Date() {
		date.click();

	}
	public void Modify_Trip_Detail(String ModifyLocation,String ToModifyLocation ) throws InterruptedException
	{
		Modify_Details.click();
		ModifyFromLocation.clear();
		ModifyFromLocation.sendKeys(ModifyLocation);
		Thread.sleep(500);
		ModifyFrom.click();
		Modify_ToLocation.clear();
		Thread.sleep(500);
		Modify_ToLocation.sendKeys(ToModifyLocation);
		Thread.sleep(500);
		Modify_dest.click();
		Thread.sleep(500);
	}
	public void Search()
	{
		SearchButton.click();
	}
	public void Sortbus()
	{
		SortBus.click();
	}

	public void SearcH()
	{
		search.click();
	}

}

