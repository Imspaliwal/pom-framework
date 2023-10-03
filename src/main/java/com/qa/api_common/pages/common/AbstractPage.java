
/*
 * @AbstractPage.java@
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
package com.qa.api_common.pages.common;

import org.openqa.selenium.WebDriver;

public interface AbstractPage {

    // public AbstractPage(WebDriver driver) {
    // super(driver);
    // }

    public void navigateTo(String pageName, WebDriver driver);

    // Can add other basic method which particular app basic nature

}
