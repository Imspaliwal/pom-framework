
/*
 * @NavigateFactory.java@
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

import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.LeavePage;

public class NavigateFactory {

    public static AbstractPage navigate(String pageName, WebDriver driver) {

        switch (pageName) {
        case "Admin":
            return new AdminPage(driver);
        case "PIM":
            return new AdminPage(driver);
        case "Leave":
            return new LeavePage(driver);
        case "Time":
            return new AdminPage(driver);
        case "Recruitment":
            return new AdminPage(driver);
        case "My Info":
            return new AdminPage(driver);
        case "Performance":
            return new AdminPage(driver);
        case "Dashboard":
            return new AdminPage(driver);
        case "Directory":
            return new AdminPage(driver);
        case "Maintenance":
            return new AdminPage(driver);
        case "Claim":
            return new AdminPage(driver);
        case "Buzz":
            return new AdminPage(driver);
        default:
            throw new IllegalArgumentException("Invalid page name: " + pageName);
        }

    }

}
