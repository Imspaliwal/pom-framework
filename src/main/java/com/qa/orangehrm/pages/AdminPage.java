
/*
 * @AdminPage.java@
 * Created on 09-Jul-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.log.JLog;
import com.qa.orangehrm.util.AppConstants;
import com.qa.orangehrm.util.ElementUtil;

//public class AdminPage extends NavigatePage {
public class AdminPage extends HomePage {

	// private final WebDriver driver;
	// private final ElementUtil eleUtil;

	// ###################### Constructors ########################

	public AdminPage(WebDriver driver) {
		// super.driver = driver;
		//
		// eleUtil = new ElementUtil(this.driver);
		super(driver);
	}

	// ###################### Locators ########################

	// Users Page locators

	By adminPageHeaderLocator = By.xpath("//h6[1]");

	By userNameSearchLocator = By.xpath("//form//input[contains(@class, 'oxd-input--active')]");

	By searchBtnLocator = By.xpath("//form//button[@type='submit']");

	By tableRowLocator = By.xpath("//div[contains(@class, 'body')]//div[contains(@class, 'row')]");
	
	// Add Users Locators

	public WebElement labelLocator(String fieldLabelName) {
		return eleUtil.getElement(By
				.xpath(String.format("//label[contains(@class, 'label') and normalize-space()='%s']", fieldLabelName)));
	}

	By dropDownLocator(String labelName) {
		return By.xpath(String.format(
				"//label[contains(@class, 'label') and normalize-space()='%s']/../following-sibling::div//div[contains(@class, 'select-text-input')]",
				labelName));
	}

	By dropDownItemLocator = By.xpath(".//div[contains(@class, 'select-dropdown')]//div[@role='option']");
	
	By headerLocator(String headerText) {
		return By.xpath(String.format("//h6[normalize-space()='%s']", headerText));
	}

	By buttonLocator(String btnText) {
		return By.xpath(String.format("//button[normalize-space()='%s']", btnText));
	}

	By inputFiledLocator(String fieldLabelName) {
		return By.xpath(
				String.format("//div[contains(@class, 'input') and normalize-space()='%s']//input", fieldLabelName));
	}

	By autocompleteDropDownLocator(String input) {
		return By.xpath(
				String.format("//div[contains(@class, 'autocomplete-dropdown')]//span[contains(text(), '%s')]", input));
	}

	By iconDeleteLocator() {
		return By.xpath(String.format(""));
	}

	By iconEditLocator() {
		return By.xpath(String.format(""));
	}

	// ###################### Methods ########################

	public boolean isAdminPageHeaderExist() {

		WebElement adminPageHeader = eleUtil.waitForElementVisible(adminPageHeaderLocator,
				AppConstants.MEDIUM_DEFAULT_WAIT);

		return adminPageHeader.isDisplayed();
	}

	public int searchSystemUsers(String userName) throws InterruptedException {

		eleUtil.waitForElementVisible(userNameSearchLocator, AppConstants.MEDIUM_DEFAULT_WAIT);
		eleUtil.doSendKeys(userNameSearchLocator, userName);
		eleUtil.doClick(searchBtnLocator);

		Thread.sleep(3000);

		int count = eleUtil.getElementsCount(tableRowLocator);

		return count;

	}

	/**
	 * @param action
	 * @param userRoleValue
	 * @param EmployeeName
	 * @param Status
	 * @param userName
	 * @param password
	 */
	public void userActions(String action, String userRoleValue, String employeeName, String status, String userName,
			String password) {

		JLog.blankLine();
		JLog.info("Interacting with Admin > User Management > Users Page");

		if (action.equalsIgnoreCase("add")) {

			JLog.info("Adding User on User Management > User Page");

			// Click on Add Button
			JLog.info("Click on Add Button");
			eleUtil.doClick(buttonLocator("Add"));
			eleUtil.waitForElementVisible(headerLocator("Add User"), AppConstants.MEDIUM_DEFAULT_WAIT);

			JLog.info("Select User Role");			
			eleUtil.select("User Role", dropDownLocator("User Role"), dropDownItemLocator, userRoleValue);
			
			JLog.info("Select Employee Name");
			eleUtil.doSendKeys(inputFiledLocator("Employee Name"), employeeName);
			eleUtil.doClick(autocompleteDropDownLocator(employeeName));
//			eleUtil.doSendKeys(inputFiledLocator("Employee Name"), Keys.ESCAPE);

			JLog.info("Select Status");
			eleUtil.select("Status", dropDownLocator("Status"), dropDownItemLocator, status);
			JLog.info("Enter User Name");
			eleUtil.doSendKeys(inputFiledLocator("Username"), userName);
			JLog.info("Enter Password");
			eleUtil.doSendKeys(inputFiledLocator("Password"), password);
			JLog.info("Enter Confirm Password");
			eleUtil.doSendKeys(inputFiledLocator("Confirm Password"), password);

			JLog.info("Click on Save Button");
			eleUtil.doClick(buttonLocator("Save"));
			ElementUtil.sleep(20);
//			eleUtil.waitForElementVisible(headerLocator("Add User"), AppConstants.MEDIUM_DEFAULT_WAIT);

		} else if (action.equalsIgnoreCase("update")) {

		} else if (action.equalsIgnoreCase("delete")) {

		}

	}

	/**
	 * listSkills
	 *
	 * @param columnName
	 */
	public void listSkills(String columnName) {
		menuPage.navigateToMenu(new String[] { "Qualifications", "Skills" });

	}

}
