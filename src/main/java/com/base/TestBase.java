package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;




public class TestBase {
	
	static Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver = null;
	public static WebDriverWait wait;
	public static TestEnvironment environment;
	public static String DRIVERS_PATH = "/drivers/";
	
	
	@BeforeClass
	public static void setupProxy() throws Exception {
		environment = TestEnvironmentLoader.INSTANCE.loadConfiguration("qa");

			String loginString = environment.getTestUser()+":"+environment.getTestPassword();
			System.out.println(loginString);
		
		
	}
	
	
	@BeforeMethod (alwaysRun = true)
	public void setUpEnvironment() throws Exception {
		log.info("# Setup.");
		driver = setupBrowser();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		login();
		
	}
	

	public WebDriver setupBrowser() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(environment.getProxyEnabled().equals("true")) {
			Proxy proxy = new Proxy();
			proxy.setHttpProxy(environment.getUrl());
			capabilities.setCapability(CapabilityType.PROXY, proxy);
		}
		
		String browser = environment.getBrowser();
		if(browser.equalsIgnoreCase("chrome")) {
			String fullPath = System.getProperty("user.dir");
			String driverPath = fullPath + DRIVERS_PATH;
			String os = System.getProperty("os.name");
			if(os.startsWith("Windows")) {
				driverPath = driverPath + "chromedriver.exe";
				
			} else if(os.startsWith("Mac")) {
				driverPath = driverPath + "chromedriver-mac";
				
			} else {
				driverPath = driverPath + "chromedriver-linux";
				
			}
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options = new ChromeOptions();
			options.merge(capabilities);
			return new ChromeDriver(options);
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			String fullPath = System.getProperty("user.dir");
			String driverPath = fullPath + DRIVERS_PATH;
			String os = System.getProperty("os.name");
			if(os.startsWith("Windows")) {
				driverPath = driverPath + "geckodriver.exe";
				
			} else if(os.startsWith("Mac")) {
				driverPath = driverPath + "geckodriver-mac";
				
			} else {
				driverPath = driverPath + "geckodriver-linux";
				
			}
			System.setProperty("webdriver.geckodriver.driver", driverPath);
			FirefoxOptions options = new FirefoxOptions();
			options.merge(capabilities);
			return new FirefoxDriver(options);
			
		} else if (browser.equalsIgnoreCase("ie")) {
			String os = System.getProperty("os.name");
			Assert.assertFalse(os.startsWith("Windows"), "IE can only be tested on Windows");
			String fullpath = System.getProperty("user.dir");
			String driverPath = fullpath + DRIVERS_PATH;
			String arch = System.getProperty("os.arch");
			if(arch.equalsIgnoreCase("x32")) {
				driverPath = driverPath + "IEDriverServer-x32.exe";
				
			} else {
				driverPath = driverPath + "IEDriverServer-x64.exe";
				
			}
			System.setProperty("webdriver.ie.driver", driverPath);
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.merge(capabilities);
			return new InternetExplorerDriver(options);
			
		} else if(browser.equalsIgnoreCase("http")) {
			return new HtmlUnitDriver();
			
		} else {
			throw new Exception("Unsupported browser: " + browser + ". Valid values are: firefox, chrome, ie, html");
		}
	}
	
	public void login() {
		driver.get(environment.getUrl());
		driver.findElement(By.cssSelector("[id='login-register-header']")).click();
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(environment.getTestUser());
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(environment.getTestPassword());
		driver.findElement(By.cssSelector("[id='btn-submit']")).click();
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("# Teardown.");
		if(driver != null)
			driver.quit();
	}
	
}
