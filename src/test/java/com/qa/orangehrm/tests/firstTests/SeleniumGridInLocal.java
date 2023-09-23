
/*
 * @SeleniumGridInLocal.java@
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
package com.qa.orangehrm.tests.firstTests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.pages.LoginPage;

public class SeleniumGridInLocal extends BaseTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Override
    @BeforeTest
    public void setup() throws MalformedURLException {

        ChromeOptions ops = new ChromeOptions();

        ops.setCapability("browserName", "chrome");

        // Run grid server before execution

        driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444"), ops);

        loginPage = new LoginPage(driver);

    }

    @Override
    @AfterTest
    public void tearDown() {

        driver.quit();

    }

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
