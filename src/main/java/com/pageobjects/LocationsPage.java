package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationsPage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//div[@id='locationTypeList']//ul//li//a")
	List<WebElement> locationTypes;
	
	
	
	public LocationsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void selectUSPSLocationType(String type) {
		for(WebElement el : locationTypes) {
			if(el.getText().equals(type)) {
				wait.until(ExpectedConditions.visibilityOf(el));
				el.click();
				break;
			}
		}
	}
}
