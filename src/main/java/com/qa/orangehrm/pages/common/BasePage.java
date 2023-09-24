
/*
 * @BasePage.java@
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
package com.qa.orangehrm.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.util.ElementUtil;

public class BasePage {

    protected WebDriver driver;
    protected final ElementUtil eleUtil;
    AbstractPage abstractPage;

    // Locators
    protected By navigateToPageLocator(String pageName) {
        By locator = By.xpath("//span[text()='" + pageName + "']");
        return locator;
    }

    /**
     * navigateToTab
     *
     * navigate to different sub pages of application
     *
     * @param name
     * @return
     */
    By navigateToTab(String[] name) {
        By locator = By.xpath("//span[text()='" + name + "']");
        return locator;
    }

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;

        eleUtil = new ElementUtil(driver);
        // abstractPage = NavigateFactory.navigate("Admin", driver);
    }

    // Methods

    // Initializing Properties handled in Base Test

    // Initializing Browser handled in Base Test

    public void navigateToTab(String names) {

        String[] name = names.split(",");

        eleUtil.doClick(null);

    }

}