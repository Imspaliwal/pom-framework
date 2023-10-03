
/*
 * @ElementUtil.java@
 * Created on 06-Jul-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.orangehrm.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.log.JLog;

public class ElementUtil {

	private final WebDriver driver;

	// Constructor
	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	// *********************** Input Utils *********************** //

	/**
	 * default sendKeys(CharSequence... keysToSend)
	 * 
	 * @param locator
	 * @param keysToSend
	 * 
	 * @author spaliwal
	 */
	public void doSendKeys(By locator, CharSequence... keysToSend) {

		WebElement ele = getElement(locator);
		ele.sendKeys(keysToSend);
	}

	/**
	 * doSendKey to enter values in given locators
	 * 
	 * @param locator
	 * @param value
	 * 
	 * @author spaliwal
	 */
	public void doSendKeys(By locator, String value) {

		WebElement ele = getElement(locator);

		ele.clear();
		JLog.write("Cleared the WebElement: " + locator);
		ele.sendKeys(value);
		JLog.write("Enter value in WebElement: " + locator);
	}

	/**
	 * Click on given locator
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		waitForElementVisible(locator, AppConstants.MEDIUM_DEFAULT_WAIT);
		getElement(locator).click();
		JLog.write("Click on WebElement: " + locator);
	}

	// *********************** Get Elements Utils *********************** //

	/**
	 * getElement
	 *
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
			JLog.write("Element is found using this locator: " + locator);
		} catch (NoSuchElementException e) {
			JLog.fail("Element is not found using this locator: " + locator);
			element = waitForElementVisible(locator, AppConstants.MEDIUM_DEFAULT_WAIT);
		}

		// highlight Element in browser if value is true in property --
		// implement later on

		return element;

	}

	/**
	 * Get Elements
	 * 
	 * @param locator
	 * @return
	 * 
	 * @author spaliwal
	 */
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	/**
	 * Get Element Count
	 * 
	 * @param locator
	 * @return
	 * 
	 * @author spaliwal
	 */
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	// *********************** Java Script Utils *********************** //

	/**
	 * Execute java script.
	 *
	 * @param javaScript the java script
	 * @return the object
	 * 
	 * @author spaliwal
	 */
	public Object executeJavaScript(String javaScript) {
		Object[] objects = null;
		return executeJavaScript(javaScript, objects);
	}

	/**
	 * Execute java script.
	 *
	 * @param javaScript the java script
	 * @param objects    the objects
	 * @return the object
	 * 
	 * @author spaliwal
	 */
	public Object executeJavaScript(String javaScript, Object... objects) {
		Object object = null;
		JavascriptExecutor js;
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
			try {
				if (objects != null) {
					object = js.executeScript(javaScript, objects);
				} else {
					object = js.executeScript(javaScript);
				}
			} catch (WebDriverException e) {
				object = null;
			}

		} else {
			JLog.error("Current browser is not instance of JavascriptExecutor!");
		}
		return object;
	}

	// *********************** Scroll Elements Utils *********************** //

	/**
	 * Scroll to element.
	 *
	 * @param element the element
	 * 
	 * @author spaliwal
	 */
	public void scrollToElement(WebElement element) {
		// String[] frames = getSwitchToFrames();
		executeJavaScript("arguments[0].scrollIntoView(true);", element);
		JLog.write("Scroll to the Element: " + element);
		// switchToFrame(frames);
	}

	/**
	 * Scroll to element.
	 *
	 * @param element the element
	 * 
	 * @author spaliwal
	 */
	public void scrollToElement(By element) {
		// String[] frames = getSwitchToFrames();
		executeJavaScript("arguments[0].scrollIntoView(true);", getElement(element));
		JLog.write("Scroll to the Element: " + element);
		// switchToFrame(frames);
	}

	/**
	 * Scroll to element.
	 *
	 * @param element the element
	 * @return the element is returned
	 * 
	 * @author spaliwal
	 */
	public WebElement scrollToElementReturn(WebElement element) {
		executeJavaScript("arguments[0].scrollIntoView(true);", element);
		JLog.write("Scroll to the Element: " + element);
		return element;
	}

	/**
	 * Scroll to element.
	 *
	 * @param element the element
	 * @return the element is returned
	 * 
	 * @author spaliwal
	 */
	public By scrollToElementReturn(By element) {
		executeJavaScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}

	// *********************** Wait Utils *********************** //

	/**
	 * Sleeps for a given amount of seconds. Actually calls wait which is a bit
	 * friendlier in multi-threaded contexts as it will release any held locks
	 * before sleeping allowing any other threads that are blocked to proceed.
	 *
	 * @param seconds The seconds to sleep for.
	 */
	public static void sleep(double seconds) {
		if (seconds <= 0) {
			return;
		}

		synchronized (ElementUtil.class) {
			try {
				ElementUtil.class.wait((int) (seconds * 1000));
			} catch (InterruptedException e) {
				// ignore
			}
		}
	}

	// Keep all object of wait util in constructor

	public WebElement waitForElementVisible(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		// highlight Element in browser if value is true in property --
		// implement later on

		return element;

	}

	public WebElement waitForElementVisible(WebElement locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));

		// highlight Element in browser if value is true in property --
		// implement later on

		return element;

	}

	public List<WebElement> waitForElementsVisible(List<WebElement> locators, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		List<WebElement> element = wait.until(ExpectedConditions.visibilityOfAllElements(locators));

		// highlight Element in browser if value is true in property --
		// implement later on

		return element;

	}

	public String waitForTitleIsAndCapture(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			String title = driver.getTitle();
			return title;
		}
		System.out.println("title is not present within the given timeout : " + timeOut);
		return null;
	}

	// *********************** Select Utils *********************** //

	/**
	 * Select option when html attribute is usual select tag Give method name
	 * parameter to select by either value, index and visibletext
	 * 
	 * @param selectLocator
	 * @param option
	 * @param method
	 */
	public void select(By selectLocator, String option, String method) {

		if (option == null) {
			JLog.warning("Please pass the right value it can not be null");
			return;
		}

		Select select = new Select(getElement(selectLocator));

		switch (method.toLowerCase().replace(" ", "").trim()) {
		case "value":
			select.selectByValue(option);
			JLog.write("Option selected: " + option);
			break;

		case "index":
			int opt = Integer.parseInt(option);
			select.selectByIndex(opt);
			JLog.write("Option selected: " + opt);
			break;

		case "visibletext":
			select.selectByVisibleText(option);
			JLog.write("Option selected: " + option);
			break;

		default:
			JLog.fail("Provide method to select the drop down");
			break;
		}

	}

	/**
	 * Get all options text from Drop Down (Select)
	 * 
	 * @param selectLocator
	 * @return
	 * 
	 * @author spaliwal
	 */
	public ArrayList<String> getOptions(By selectLocator) {

		Select select = new Select(getElement(selectLocator));
		List<WebElement> options = select.getOptions();
		ArrayList<String> optionsTextList = new ArrayList<>();
		
		JLog.info("List All Options");
		for (WebElement option : options) {
			String text = option.getText();
			if (text == null)
				text = option.getAttribute("value");
			JLog.info("Options : " + StringUtil.convertWebElementToString(option) + " has text: " + text);

			optionsTextList.add(text.trim());
		}

		return optionsTextList;

	}

	/**
	 * 
	 * Get all the selected option form Drop Down (Select)
	 * 
	 * @param selectLocator
	 * @return
	 * 
	 * @author spaliwal
	 */
	public ArrayList<String> getAllSelectedOptions(By selectLocator) {

		Select select = new Select(getElement(selectLocator));
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		ArrayList<String> optionsTextList = new ArrayList<>();
		
		JLog.info("List All Selected Options");
		for (WebElement option : selectedOptions) {
			String text = option.getText();
			if (text == null)
				text = option.getAttribute("value");
			JLog.info("Selected Options :" + StringUtil.convertWebElementToString(option) + " has text: " + text);

			optionsTextList.add(text.trim());
		}

		return optionsTextList;

	}

	/**
	 * Get Drop Down first selected option text
	 * 
	 * @param selectLocator
	 * @return
	 * 
	 * @author spaliwal
	 */
	public String getFirstSelectedOption(By selectLocator) {

		Select select = new Select(getElement(selectLocator));
		WebElement firstSelectedOptions = select.getFirstSelectedOption();
		
		JLog.info("List First Selected Options");
		String text = firstSelectedOptions.getText();
		if (text == null)
			text = firstSelectedOptions.getAttribute("value");
		JLog.info("First Selected Option : " + StringUtil.convertWebElementToString(firstSelectedOptions) + " has text: "
				+ text);

		return text;

	}

	/**
	 * Select all value in Drop Down if multiple tag is available
	 * 
	 * @param selectLocator
	 * 
	 * @author spaliwal
	 */
	public void selectAllValue(By selectLocator) {

		Select select = new Select(getElement(selectLocator));
		List<WebElement> options;

		if (select.isMultiple()) {

			options = select.getOptions();

			for (WebElement option : options) {
				String text = option.getText();
				if (text != null)
					select.selectByValue(text);

				text = option.getAttribute("value");
				select.selectByValue(text);
				JLog.info("Option selected: with text: " + text);
			}

		}

	}

	// *********************** Select Utils Advance or Custom
	// *********************** //

	/**
	 * Select Drop Down value with locator (without Select HTML tag web element)
	 * 
	 * @param dropDownLocator
	 * @param valueToSelect
	 */
	public void selectDropDownByLocator(By dropDownLocator, String valueToSelect) {

		List<WebElement> optionList = getElements(dropDownLocator);

		if (!(optionList.isEmpty() || optionList == null)) {
			for (WebElement option : optionList) {
				String text = option.getText();
				if (text == null)
					text = option.getAttribute("value");
				if (text.equals(valueToSelect)) {
					option.click();
					break;
				}
				JLog.info("Option selected: with text: " + text);
			}
		} else {
			JLog.fail("Option is either empty or null");
		}

	}

	/**
	 * Select the option from Drop Down and also list out all options
	 * 
	 * @param fieldLabel
	 * @param dropDown
	 * @param options
	 * @param valueToSelect
	 * @return
	 * @throws NoSuchElementException
	 * 
	 * @author spaliwal
	 */
	public boolean select(String fieldLabel, By dropDown, By options, String valueToSelect)
			throws NoSuchElementException {

		boolean success = false;

		JLog.info(String.format("Select Drown Down %s item: %s", fieldLabel, valueToSelect));

		// Remove already Selected or Clear if required

		// click on Drop Down (Arrow)
		getElement(dropDown).click();
		// ElementUtil.sleep(5);
		waitForElementsVisible(getElements(options), AppConstants.MEDIUM_DEFAULT_WAIT);

		// List Items
		List<WebElement> elements = getElements(options);
		getElementsTextList(elements);

		// Select Item
		select(options, valueToSelect);
		ElementUtil.sleep(2);

		return success;
	}
	
	public boolean select(String fieldLabel, By dropDown, By options, String valueToSearch, String valueToSelect)
			throws NoSuchElementException {

		boolean success = false;

		JLog.info(String.format("Search " +valueToSearch+ " and Select Drown Down %s item: %s", fieldLabel, valueToSelect));

		// Remove already Selected or Clear if required

		// Write in Drop Down search field
		getElement(dropDown).sendKeys(valueToSearch);
		ElementUtil.sleep(5);
		waitForElementsVisible(getElements(options), AppConstants.MEDIUM_DEFAULT_WAIT);

		// List Items
		List<WebElement> elements = getElements(options);
		getElementsTextList(elements);

		// Select Item
		select(options, valueToSelect);
		ElementUtil.sleep(2);

		return success;
	}

	/**
	 * 
	 * 
	 * @param fieldLabel
	 * @param dropDown
	 * @param options
	 * @param valueToSelect
	 * @return
	 * @throws NoSuchElementException
	 * 
	 * @author spaliwal
	 */
	public boolean select(String fieldLabel, WebElement dropDown, WebElement options, String valueToSelect)
			throws NoSuchElementException {

		boolean success = false;

		JLog.info(String.format("Select Drown Down %s item: %s", fieldLabel, valueToSelect));

		// Remove already Selected or Clear if required

		// click on Drop Down (Arrow)
		dropDown.click();

		ElementUtil.sleep(5);

		waitForElementVisible(options, AppConstants.MEDIUM_DEFAULT_WAIT);

		// List Items
		// Convert WebELement to By to do this
//		List<WebElement> elements = getElements(options);
//		getElementsTextList(options);

		// Select Item
//		select(options, valueToSelect);

//		driver.findElement(By.xpath(String
//				.format("//div[@role='option'][normalize-space()='%s']", valueToSelect)))
//				.click();

		ElementUtil.sleep(2);

		return success;
	}

	/**
	 * Select the Drop Down but do not list options
	 * 
	 * @param fieldLabel
	 * @param locator
	 * @param valueToSelect
	 * @return
	 * @throws NoSuchElementException
	 */
	public boolean select(String fieldLabel, By locator, String valueToSelect) throws NoSuchElementException {

		boolean success = false;

		JLog.info(String.format("Select Drown Down %s item: %s", fieldLabel, valueToSelect));

		// Remove already Selected or Clear if required

		// click on Drop Down (Arrow)
		getElement(locator).click();

		ElementUtil.sleep(2);

		// Select Item
		select(locator, valueToSelect);

		ElementUtil.sleep(2);

		return success;
	}

	/**
	 * Get the list of string of By type
	 * 
	 * @param locator
	 * @return
	 * 
	 * @author spaliwal
	 */
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	/**
	 * Get the list of string of findElements type
	 * 
	 * @param options
	 * @return
	 * 
	 * @author spaliwal
	 */
	public List<String> getElementsTextList(List<WebElement> options) {

		ArrayList<String> items = new ArrayList<String>();
		for (WebElement opts : options) {
			String text = opts.getText();
			if (text == null)
				text = opts.getAttribute("value");
			JLog.info("Option: " + text);
			items.add(text);
		}

		return items;

	}

	/**
	 * Select the element actual value In this method concat the xpath to actual
	 * path to find the option
	 * 
	 * @param options
	 * @param valueToSelect
	 * @return
	 * 
	 * @author spaliwal
	 */
	public boolean select(By options, String valueToSelect) {

		boolean success = false;

		String option = StringUtil.convertByToString(options);

		// Append the xpath to get actual Item
		By finalOptionText = By.xpath(option + String.format("[normalize-space()='%s']", valueToSelect));

		// Get WebElement and click on it
		doClick(finalOptionText);

		return success;
	}

	/**
	 * Not yet implement .....
	 * 
	 * @param options
	 * @param valueToSelect
	 * @return
	 */
	public boolean select(List<WebElement> options, String valueToSelect) {

		boolean success = false;

		// Append the xpath to get actual Item
		WebElement itemToSelect = options.get(0);
		String option = StringUtil.convertWebElementToString(itemToSelect);

		By fineOptionText = By.xpath(String.format(option + "[normalize-space()='%s']", valueToSelect));

		WebElement item = getElement(fineOptionText);
		item.click();

		return success;
	}

	public boolean selectDropDownByLocator(String fieldLabel, WebElement locator, String valueToSelect,
			String ValueTOSearch) {

		return true;
	}

	public boolean selectDropDownByLocator(String fieldLabel, WebElement locator, String valueToSelect,
			String firstSelected, String ValueTOSearch) {

		return true;
	}

	// *********************** Table Utils *********************** //

	public void getTableData(By table) {

	}

	public void getTableHeader(By tableHeaderEle) {

	}

	public void getTableRow(By tableRowEle) {

	}

	public void getTableCol(By tableColEle) {

	}

}
