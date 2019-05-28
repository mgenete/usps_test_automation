package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseActions;

public class HomePage {
	
	
	public WebDriver driver;
	
	@FindBy (css = "[id='anchor-login']")
	WebElement profileName;
	
	@FindBy(xpath = "//a[@id='navquicktools']/following-sibling::a")
	WebElement quickToolsLink;
	
	@FindBy(xpath = "//a[@id='navquicktools']/following-sibling::div/ul//li//img")
	List<WebElement> pages;
	
	@FindBy(css = "[id='link-locator']")
	WebElement locationLink;
	
	@FindBy(xpath = "//ul[@class='nav-list']//a[@class='menuitem']")
	List<WebElement> navigationLinks;
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public MyProfilePage navigateToMyProfilePage() {
		profileName.click();
		return new MyProfilePage();
	}
	
	
	public void clickOnQuickTools(String linkText) {
		boolean mouseOver = BaseActions.ACTIONS.mouseOver(driver, quickToolsLink);
		if(mouseOver) {
			for(WebElement el : pages) {
				String pageLink = el.getAttribute("alt");
				if(linkText.contains(pageLink)) {
					el.click();
				} else {
					Assert.fail("Couldn't find page: " + linkText);
				}
			}
		} else {
			Assert.fail("Failed to mouseover page");
		}
		
	}
	
	
	public LocationsPage clickOnLocationLink() {
		locationLink.click();
		LocationsPage locationsPage = PageFactory.initElements(driver, LocationsPage.class);
		return locationsPage;
	}
	
	
	public void validateNavigationLinksText() {
		String[] navLinks = {"Mail & Ship","Track & Manage","Postal Store","Business","International","Help"};
		
		for(String str : navLinks) {
			WebElement element = null;
			element = driver.findElement(By.xpath("//a[@class='menuitem' and contains(text(),'"+str+"')]"));
			Assert.assertNotNull(element, "Faild to find link " + str);
		}
	}
	
	
	public void validateImageAttribute(String attribute, String text) {
		try {
			List<WebElement> elements = driver.findElements(By.xpath("//div[@class='result-products-holder']//img"));
			WebElement targetElement = null;
			for(WebElement el : elements) {
				if(el.getAttribute(attribute).equals(text)) {
					targetElement=el;
					break;
				}
			}
			Assert.assertNotNull(targetElement, text+" "+attribute+" not found");
		} catch (Exception e) {
			Assert.fail("Failed to find image attribute "+ attribute, e);
		}
	}
	
	
}
