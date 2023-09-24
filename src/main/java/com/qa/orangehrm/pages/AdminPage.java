
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.orangehrm.pages.common.NavigatePage;
import com.qa.orangehrm.util.AppConstants;

public class AdminPage extends NavigatePage {

    // private final WebDriver driver;
    // private final ElementUtil eleUtil;

    // Locators
    By adminPageHeaderLocator = By.xpath("//h6[1]");

    By userNameSearchLocator = By.xpath("//form//input[contains(@class, 'oxd-input--active')]");
    By searchBtnLocator = By.xpath("//form//button[@type='submit']");

    By tableRowLocator = By.xpath("//div[contains(@class, 'body')]//div[contains(@class, 'row')]");

    // Constructors
    public AdminPage(WebDriver driver) {
        // super.driver = driver;
        //
        // eleUtil = new ElementUtil(this.driver);
        super(driver);
    }

    // Methods

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
     * listSkills
     *
     * @param columnName
     */
    public void listSkills(String columnName) {

    }

}
