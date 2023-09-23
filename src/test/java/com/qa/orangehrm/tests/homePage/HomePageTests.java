
/*
 * @HomePageTests.java@
 * Created on 07-Jul-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.orangehrm.tests.homePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTestNew;

public class HomePageTests extends BaseTestNew {

    @BeforeClass
    public void homePageSetup() {

        System.out.println("Home Page Test - Before Class Run");

        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

        // Assert
        Assert.assertEquals(homePage.isDashboardHeaderExist(), true,
                "User is not logged in, Home page Dashboard header is not displaying ");

    }

    @Test
    public void homePageTitleTest() {

        String actualHomePageTitle = homePage.homePageTitle();

        // Assert
        Assert.assertEquals(actualHomePageTitle, "OrangeHRM", "Login page Title is incorrect");
    }

    @Test
    public void loginUserNameTest() {

        String actualLoginUserName = homePage.loginUserName();

        // Assert
        Assert.assertEquals(actualLoginUserName, "Paul Collings",
                "Login User Name is not matched with Expected User Name");

    }
}
