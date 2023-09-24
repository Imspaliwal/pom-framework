
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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            System.out.println("Element is found using this locator... " + locator);
        } catch (NoSuchElementException e) {
            System.out.println("Element is not found using this locator... " + locator);
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

}
