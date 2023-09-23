
/*
 * @AdminPageTests.java@
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
package com.qa.orangehrm.tests.adminPage;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTestNew;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.common.NavigateFactory;

public class AdminPageTests extends BaseTestNew {

    @BeforeTest
    public void adminPageSetup() throws InterruptedException {

        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

        AdminPage abstractPage = (AdminPage) NavigateFactory.navigate("Admin", driver);
        System.out.println("Is Admin Page? " + abstractPage);
        abstractPage.navigateTo("Admin", driver);

        // adminPage = homePage.navigateTo("Admin");

        // Assert
        abstractPage.searchSystemUsers("admin");

        // Assert
        Assert.assertEquals(adminPage.isAdminPageHeaderExist(), true,
                "User is not navigated to Admin, Admin page Dashboard header is not displaying ");

    }

    @Test
    public void doSearchByUserNameTest() throws InterruptedException {

        int userCount = adminPage.searchSystemUsers("admin");

        // Assert
        Assert.assertEquals(userCount, 1, "User name is not searched correctly");

    }

}
