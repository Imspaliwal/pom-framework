
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
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.orangehrm.log.JLog;

public class ElementUtil {

	private final WebDriver driver;

	// Constructor
	public ElementUtil(WebDriver driver) {

		this.driver = driver;

	}

	// *********************** Input Utils *********************** //

	public void doSendKeys(By locator, String value) {

		WebElement ele = getElement(locator);

		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) {
		waitForElementVisible(locator, AppConstants.MEDIUM_DEFAULT_WAIT);
		getElement(locator).click();

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
			JLog.write("Element is found using this locator... " + locator);
		} catch (NoSuchElementException e) {
			JLog.fail("Element is not found using this locator... " + locator);
			element = waitForElementVisible(locator, AppConstants.MEDIUM_DEFAULT_WAIT);
		}

		// highlight Element in browser if value is true in property --
		// implement later on

		return element;

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

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
		executeJavaScript("arguments[0].scrollIntoView(true);", element);
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

	// Keep all object of wait util in constructor

	public WebElement waitForElementVisible(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

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
