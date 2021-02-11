package com.redbus.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Initialize the driver
	WebDriver driver;
	//Create a Constructor with same name of class
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(how = How.ID,using="i-icon-profile")
	public WebElement ClickSignin;

	@FindBy(how = How.ID,using="signInLink")
	public WebElement Signin;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame;

	@FindBy(how = How.ID, using = "newFbId")
	public WebElement facebook_button;

	@FindBy(how = How.ID, using = "email")
	public WebElement facebook_ValidphoneNo;

	@FindBy(how = How.ID, using = "pass")
	public WebElement facebook_password;

	@FindBy(how = How.ID, using = "loginbutton")
	public WebElement LogIn_button;

	@FindBy(how = How.XPATH, using = "//i[@class= 'icon-close']")
	public WebElement close;

	public void SwitchTabs(String PhoneNo,String pass) throws InterruptedException
	{   
		//Action can be performed on frame element
		driver.switchTo().frame(frame);
		//Handle the current window
		String mainWindow = driver.getWindowHandle();
		//Action can be performed on facebook_button element
		facebook_button.click();
		//A set of window handles which can be used to iterate over all open windows.
		Set<String> handles = driver.getWindowHandles();
		//Use the loop  condition
		for (String childWindow : handles) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				//Action can be performed on facebook_ValidphoneNo element
				facebook_ValidphoneNo.sendKeys(PhoneNo);
				//Action can be performed on facebook_password element
				facebook_password.sendKeys(pass);
				//Action can be performed on LogIn_button element
				LogIn_button.click();
			}
			Thread.sleep(2900);           
		}
		//Switch to main_window
		driver.switchTo().window(mainWindow);
		Thread.sleep(200);
	}
	
	public void FbDetails(String Email, String pass ) {
		facebook_ValidphoneNo.sendKeys(Email);
		//Action can be performed on facebook_password element
		facebook_password.sendKeys(pass);
		//Action can be performed on LogIn_button element
		LogIn_button.click();
		
	}
	public void Click_close()
	{
		//Action can be performed on close element
		close.click();
	}
	public void Clicksignin()
	{
		//Action can be performed on ClickSignin element
		ClickSignin.click();
	}
	public void Signin()
	{
		//Action can be performed on Signin element
		Signin.click();
	}
}
