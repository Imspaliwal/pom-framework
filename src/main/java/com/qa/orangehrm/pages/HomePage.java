
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

import com.qa.orangehrm.pages.common.NavigatePage;
import com.qa.orangehrm.util.AppConstants;

//public class HomePage extends BasePage implements AbstractPage {
public class HomePage extends NavigatePage {

    // private final WebDriver driver;
    // private final ElementUtil eleUtil;
    public NavigatePage navigateTo;

    // Locators
    By dashboardHeaderLocator = By.tagName("h6");

    By loginUserNameLocator = By.xpath("//p[@class='oxd-userdropdown-name']");

    // Constructor
    // public HomePage(WebDriver driver) {
    // this.driver = driver;
    //
    // eleUtil = new ElementUtil(this.driver);
    // }

    public HomePage(WebDriver driver) {
        super(driver);

    }

    // Methods

    public boolean isDashboardHeaderExist() {

        /* return driver.findElement(dashboardHeaderLocator).isDisplayed(); */

        WebElement dashboard = eleUtil.waitForElementVisible(dashboardHeaderLocator, AppConstants.MEDIUM_DEFAULT_WAIT);

        return dashboard.isDisplayed();
    }

    public String homePageTitle() {

        String title = eleUtil.waitForTitleIsAndCapture(AppConstants.HOME_PAGE_TITLE, AppConstants.MEDIUM_DEFAULT_WAIT);

        System.out.println("Home Page Title is: " + title);

        return title;
    }

    public String loginUserName() {

        WebElement loginUserName = eleUtil.getElement(loginUserNameLocator);

        return loginUserName.getText().trim();

    }

    // @Override
    // public void navigateTo(String pageName, WebDriver driver) {
    //
    // System.out.println("Navigating to page: " + pageName);
    //
    // // JLog.info("Navigating to page: " + pageName);
    // // JLog.write("Navigating to page: " + pageName);
    // // JLog.warning("Navigating to page: " + pageName);
    // // JLog.fail("Navigating to page: " + pageName);
    //
    // eleUtil.waitForTitleIsAndCapture(AppConstants.HOME_PAGE_TITLE,
    // AppConstants.MEDIUM_DEFAULT_WAIT);
    // eleUtil.doClick(navigateToPageLocator(pageName));
    //
    // }

}
