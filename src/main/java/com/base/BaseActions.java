package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public enum BaseActions {
	
	
	ACTIONS;
	
	private BaseActions() {
		
	}
	
	public boolean mouseOver(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean contextClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean doubleClick(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean dragdrop(WebDriver driver, WebElement source, WebElement targer) {
		try {
			Actions action = new Actions(driver);
			action.clickAndHold(source).moveToElement(targer).release().build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	

}
