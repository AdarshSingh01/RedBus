package com.redbus.tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.redbus.utils.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {


	public static WebDriver driver;
	public static RemoteWebDriver remotedriver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	static File file = new File(
			"./Utility/configuration.properties");
	static FileInputStream fis = null;
	public static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		try {
			prop.load(fis);
		} catch (IOException el) {
			el.printStackTrace();

		}
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	@Parameters({"browser"})
	public void driverInitialize(String browser) throws Throwable 
	{
		//CHROME BROWSER------------------------------
		
		
		String browserType = prop.getProperty("mode");
		if (browser.toLowerCase().equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriverPath"));
			
			if (browserType.toLowerCase().equals("headless")) 
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1920,1080");
				options.addArguments("headless");
				options.addArguments("user-agent=Chrome/88.0.4324.150");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
			}
			else 
			{
//				DesiredCapabilities dc = DesiredCapabilities.chrome();
//				URL url = new URL("http://localhost:4444/wd/hub");
//				RemoteWebDriver remotedriver = new RemoteWebDriver(url,dc);
//				driver = remotedriver;
//				driver.manage().window().maximize();
//				driver.get("https://www.redbus.in/");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
			}
		}
		//INTERNET EXPLORER BROWSER-----------------------------------------------



		else if (browser.toLowerCase().equals("ie") ) 
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEDriverPath"));
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver=new InternetExplorerDriver(caps);
			
			
			driver.manage().window().maximize();
			driver.navigate().to(prop.getProperty("url"));
		}
		else if (browser.toLowerCase().equals("firefox") ) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxDriverPath"));
			if (browserType.toLowerCase().equals("headless"))
			{                
//				DesiredCapabilities dc = DesiredCapabilities.firefox();
//				URL url = new URL("http://localhost:4444/wd/hub");
//				RemoteWebDriver driver = new RemoteWebDriver(url,dc);
//				driver.manage().window().maximize();
//				driver.get("https://www.redbus.in/");
				//--------------------------------------------------------        
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
			} 
			else 
			{
//				DesiredCapabilities dc = DesiredCapabilities.firefox();
//				URL url = new URL("http://localhost:4444/wd/hub");
//				//dc.setCapability("marionette",true);
//				RemoteWebDriver driver = new RemoteWebDriver(url,dc);
//				driver = remotedriver;
//				driver.manage().window().maximize();
//				driver.navigate().to("https://www.redbus.in/");

				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("url"));
			}
		} 
		else 
		{
			System.out.println("Incompatible Browser Selection");
		}
		int i=Integer.parseInt(prop.getProperty("IMPLICITWAIT"));
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

	@BeforeTest
	public void setExtent() {
		extent = new ExtentReports(System.getProperty("user.dir") + (prop.getProperty("reportpath"))+ s + (prop.getProperty("reportExtnsn")), true);
		extent.addSystemInfo("Host Name", "Adarsh Singh");
		extent.addSystemInfo("User Name", "Adarsh");
		extent.addSystemInfo("Environment", "Automation Testing");
	}
	@AfterTest
	public void endReport() 
	{
		extent.flush();
		extent.close();
	}
	public static int i =1;
	public static String s = String.valueOf(i);
	@AfterMethod
	public static void closeBrowser(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			// to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); 
			// to add error/exception in
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());    
			// extent report
			String screenshotPath = ScreenShot.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
			// to add screenshot in extent                                                                                        // report
			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
			// //to add screen_cast/video in extent report
		} 
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) 
		{
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());



		}
		// ending test and ends the current test and prepare to create html report
		extent.endTest(extentTest); 
		driver.quit();
		s = String.valueOf(i+1);
	}
	
}
