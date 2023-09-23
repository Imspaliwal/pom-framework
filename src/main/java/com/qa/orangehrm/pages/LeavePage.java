
/*
 * @LeavePage.java@
 * Created on 08-Sep-2023
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

public class LeavePage extends HomePage {

    public LeavePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    By leavePageHeaderLocator = By.xpath("//h6[1]");

    // Methods

    public boolean isLeavePageHeaderExist() {

        WebElement leavePageHeader = eleUtil.waitForElementVisible(leavePageHeaderLocator,
                AppConstants.MEDIUM_DEFAULT_WAIT);

        return leavePageHeader.isDisplayed();
    }

}
