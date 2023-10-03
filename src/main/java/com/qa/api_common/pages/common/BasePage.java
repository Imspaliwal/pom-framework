
/*
 * @BasePage.java@
 * Created on 04-Oct-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.api_common.pages.common;

import org.openqa.selenium.WebDriver;

import com.qa.api_common.util.ElementUtil;

public class BasePage {

    protected WebDriver driver;
    protected final ElementUtil eleUtil;
    protected AbstractPage abstractPage;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;

        eleUtil = new ElementUtil(driver);

        // abstractPage = NavigateFactory.navigate("Admin", driver);
    }

    // Locators
    // protected By navigateToPageLocator(String pageName) {
    // By locator = By.xpath("//span[text()='" + pageName + "']");
    // return locator;
    // }

    // Common login page for any website
    // private final By usernameLocator = By.name("username");
    // private final By passwordLocator = By.name("password");
    // private final By loginBtnLocator = By.tagName("button");

    // Methods

    // Correct this override issue in Login Class

    // public void doLogin(String username, String password) {
    // eleUtil.waitForElementVisible(usernameLocator,
    // AppConstants.MEDIUM_DEFAULT_WAIT);
    //
    // eleUtil.doSendKeys(usernameLocator, username);
    // eleUtil.doSendKeys(passwordLocator, password);
    //
    // eleUtil.doClick(loginBtnLocator);
    // }

    // Initializing Properties handled in Base Test

    // Initializing Browser handled in Base Test

}
