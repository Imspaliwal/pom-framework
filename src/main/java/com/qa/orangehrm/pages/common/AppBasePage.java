
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

import com.qa.api_common.pages.common.BasePage;

public class AppBasePage extends BasePage {

    protected MenuPage menuPage;

    // Constructor
    public AppBasePage(WebDriver driver) {

        super(driver);
        menuPage = new MenuPage(driver);

    }

    // Locators
    protected By navigateToPageLocator(String pageName) {
        By locator = By.xpath("//span[text()='" + pageName + "']");
        return locator;
    }

    // Methods

    // Initializing Properties handled in Base Test

    // Initializing Browser handled in Base Test

}
