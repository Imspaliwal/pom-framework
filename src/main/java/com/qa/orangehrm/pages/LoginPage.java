
/*
 * @LoginPage.java@
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

import com.qa.orangehrm.pages.common.NavigatePage;
import com.qa.orangehrm.util.AppConstants;

public class LoginPage extends NavigatePage {

    // private final WebDriver driver;
    // private final ElementUtil eleUtil;

    // Locators
    private final By usernameLocator = By.name("username");

    private final By passwordLocator = By.name("password");

    private final By loginBtnLocator = By.tagName("button");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        // this.driver = driver;
        // eleUtil = new ElementUtil(this.driver);

    }

    // Methods

    public String loginPageTitle() {

        String title = eleUtil.waitForTitleIsAndCapture(AppConstants.LOGIN_PAGE_TITLE,
                AppConstants.MEDIUM_DEFAULT_WAIT);

        System.out.println("Login Page Title is: " + title);

        return title;
    }

    public HomePage doLogin(String username, String password) {

        /*
         * WebDriverWait wait = new WebDriverWait(driver,
         * Duration.ofSeconds(30));
         * wait.until(ExpectedConditions.elementToBeClickable(usernameLocator));
         *
         * driver.findElement(usernameLocator).sendKeys(username);
         * driver.findElement(passwordLocator).sendKeys(password);
         *
         * driver.findElement(loginBtnLocator).submit();
         */

        eleUtil.waitForElementVisible(usernameLocator, AppConstants.MEDIUM_DEFAULT_WAIT);

        eleUtil.doSendKeys(usernameLocator, username);
        eleUtil.doSendKeys(passwordLocator, password);

        eleUtil.doClick(loginBtnLocator);

        return new HomePage(driver);
    }

}
