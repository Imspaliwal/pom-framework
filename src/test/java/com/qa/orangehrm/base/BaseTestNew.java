
/*
 * @BaseTestNew.java@
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
package com.qa.orangehrm.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.qa.orangehrm.factory.PropertyManager;
import com.qa.orangehrm.factory.browser.DriverFactory;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LeavePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.common.BasePage;
import com.qa.orangehrm.pages.common.NavigatePage;

public class BaseTestNew {

    public WebDriver driver;

    protected DriverFactory driverFactory;
    protected PropertyManager propManager;
    protected Properties prop;

    protected BasePage basePage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected AdminPage adminPage;
    protected LeavePage leavePage;
    protected NavigatePage navigatePage;

    @Parameters({ "browser" })
    @BeforeTest
    public void setup(@Optional String browserName) {

        System.out.println("Base Test - Before Test Run");

        // Initialize properties
        propManager = new PropertyManager();
        prop = propManager.init_prop();

        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }

        // Initialize browser
        driverFactory = new DriverFactory(prop);
        driver = driverFactory.init_driver(prop);

        // pass driver to Login
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {

        System.out.println("Base Test - After Test Run");

        // close & quite browser
        // driver.quit();
        driver.close();

    }

}
