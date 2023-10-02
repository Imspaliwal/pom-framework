
/*
 * @LoginPageTests.java@
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
package com.qa.orangehrm.tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;

public class LoginPageTests extends BaseTest {

    @Test
    public void loginPageTitleTest() {

        String actualLoginPageTitle = loginPage.loginPageTitle();

        // Assert
        Assert.assertEquals(actualLoginPageTitle, "OrangeHRM", "Login page Title is incorrect");

    }

    @Test
    public void doLoginTest() {

        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

        // Assert
        Assert.assertEquals(homePage.isDashboardHeaderExist(), true,
                "User is not logged in, Home page Dashboard header is not displaying ");

    }

}
