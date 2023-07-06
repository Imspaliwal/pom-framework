
/*
 * @BaseTest.java@
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
package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

public class BaseTest {

    private WebDriver driver;

    protected Properties prop;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeTest
    public void setup() throws IOException {

        // Initialize Properties

        prop = new Properties();

        FileInputStream ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/config.properties");

        prop.load(ip);

        // Initialize Browser

        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        System.out.println("Running Test on Env: " + prop.getProperty("url"));

        driver.get(prop.getProperty("url"));

        loginPage = new LoginPage(driver);

    }

    @AfterTest
    public void tearDown() {

        driver.quit();

    }

}
