
/*
 * @FirstTest.java@
 * Created on 05-Jul-2023
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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstParallelTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fisrtTest_01() {

        driver.get("https://www.github.com/");

        System.out.println("This is my first test 01: " + driver.getTitle());

        driver.close();

    }

    @Test
    public void fisrtTest_02() {

        driver.get("https://www.twitter.com/");

        System.out.println("This is my first test 02: " + driver.getTitle());

        driver.close();

    }

    @Test
    public void fisrtTest_03() {

        driver.get("https://www.facebook.com/");

        System.out.println("This is my first test 03: " + driver.getTitle());

        driver.close();

    }

}
