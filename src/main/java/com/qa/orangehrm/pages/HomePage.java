
/*
 * @HomePage.java@
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
package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.util.AppConstants;
import com.qa.orangehrm.util.ElementUtil;

public class HomePage {

    private final WebDriver driver;
    private final ElementUtil eleUtil;

    // Locators
    By dashboardHeaderLocator = By.tagName("h6");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;

        eleUtil = new ElementUtil(driver);
    }

    // Methods

    public boolean isDashboardHeaderExist() {

        /* return driver.findElement(dashboardHeaderLocator).isDisplayed(); */

        WebElement dashboard = eleUtil.waitForElementVisible(dashboardHeaderLocator, AppConstants.MEDIUM_DEFAULT_WAIT);

        return dashboard.isDisplayed();
    }

}
