
/*
 * @Navigate.java@
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
package com.qa.orangehrm.pages.common;

import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.log.JLog;
import com.qa.orangehrm.util.AppConstants;

//public class NavigatePage extends HomePage implements AbstractPage {
public class NavigatePage extends BasePage implements AbstractPage {

    public NavigatePage(WebDriver driver) {
        super(driver);
    }

    // @Override
    // public void navigateTo(String pageName, WebDriver driver) {
    // // TODO Auto-generated method stub
    //
    // }

    @Override
    public void navigateTo(String pageName, WebDriver driver) {

        JLog.write("Navigating to page: " + pageName);

        // JLog.info("Navigating to page: " + pageName);
        // JLog.write("Navigating to page: " + pageName);
        // JLog.warning("Navigating to page: " + pageName);
        // JLog.fail("Navigating to page: " + pageName);

        eleUtil.waitForTitleIsAndCapture(AppConstants.HOME_PAGE_TITLE, AppConstants.MEDIUM_DEFAULT_WAIT);
        eleUtil.doClick(navigateToPageLocator(pageName));

    }

}
