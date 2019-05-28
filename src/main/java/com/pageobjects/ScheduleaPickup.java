package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ScheduleaPickup {
	
	
	public WebDriver driver;
	final static String TITLE = "Schedule a Pickup | USPS";
	final static String HEADING = "Schedule a Pickup";
	
	@FindBy(xpath = "//h1")
	WebElement pageHeader;
	
	@FindBy(css = "[id='firstName']")
	WebElement firstNameField;
	
	@FindBy(css = "[id='lastName']")
	WebElement lastNameField;
	
	@FindBy(css = "[id='[id='addressLineOne']']")
	WebElement addressLine1Field;
	
	@FindBy(css = "[id='city']")
	WebElement cityField;
	
	@FindBy(css = "[id='state']")
	WebElement stateDropDown;
	
	@FindBy(css = "[id='[id='zipCode']']")
	WebElement zipcodeField;
	
	@FindBy(css = "[id='phoneNumber']")
	WebElement phonenumbField;
	
	@FindBy(css = "[id='emailAddress']")
	WebElement emailAddField;
	
	@FindBy(css = "[id='webToolsAddressCheck']")
	WebElement checkAvailabilityBtn;
	
	@FindBy(xpath = "//p[contains(text(),'Service Available')]")
	WebElement pickupAddressValidation;
	
	@FindBy(css = "[name='isDogHere']")
	List<WebElement> isDogHere;
	
	@FindBy(css = "[id='packageLocation']")
	WebElement packageLocation;
	
	@FindBy (css = " [id='step-two-desc-item-textarea']")
	WebElement textInstructionBox;
	
	
	public ScheduleaPickup verifySchedulePickupPageTitle() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, TITLE, "Actual title " + actualTitle + " shall be smae as expected " + TITLE );
		return this;
	}
	
	
	public ScheduleaPickup verifySchedulePickupPageHeader() {
		String actualHeader = pageHeader.getText();
		Assert.assertEquals(actualHeader, HEADING, "Actual heading '" + actualHeader + "' shall be same as expected '" + HEADING + "'.");
		return this;
	}

}
