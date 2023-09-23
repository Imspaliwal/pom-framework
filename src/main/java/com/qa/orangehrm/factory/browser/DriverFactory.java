
/*
 * @DriverFactory.java@
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
package com.qa.orangehrm.factory.browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    OptionsManager optionsManager;
    public Properties prop;
    DriverInfo driverInfo;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public synchronized static WebDriver getDriver() {
        return tlDriver.get();
    }

    public DriverFactory(Properties prop) {
        this.optionsManager = new OptionsManager(prop);

        // save driver info
        this.driverInfo = new DriverInfo();
    }

    public WebDriver init_driver(Properties prop) {

        String browerName = null;

        // If browser name is not given in XML & also not given in config
        // property file
        if (prop.getProperty("browser").toLowerCase().trim().equals("")) {
            browerName = System.getProperty("browser");
        } else {
            browerName = prop.getProperty("browser").toLowerCase().trim();
        }

        // Get driver info in more details
        driverInfo.setDriverName(browerName);

        System.out.println("Browser Detail: " + driverInfo);

        System.out.println("Browser Name is: " + browerName);

        switch (browerName) {

        case "chrome":
            if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                // Run on Grid remote WebDriver
                init_remoteDriver(prop, "chrome");
            } else {
                // Run on local Driver
                System.out.println("Running Tests on Local browser...");
                tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
            }

            break;

        case "firefox":
            if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                // Run on Grid remote WebDriver
                init_remoteDriver(prop, "firefox");
            } else {
                // Run on local Driver
                System.out.println("Running Tests on Local browser...");
                tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
            }

            break;

        case "edge":
            if (Boolean.parseBoolean(prop.getProperty("remote"))) {
                // Run on Grid remote WebDriver
                init_remoteDriver(prop, "edge");
            } else {
                // Run on local Driver
                System.out.println("Running Tests on Local browser...");
                tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
            }

            break;

        default:
            System.out.println("Please Pass the right browser...");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));

        return getDriver();

    }

    public void init_remoteDriver(Properties prop, String browserName) {

        // optionsManager = new OptionsManager(prop);

        System.out.println("Running tests on grid with browser: " + browserName);

        try {
            switch (browserName.toLowerCase()) {
            case "chrome":
                tlDriver.set(
                        new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
                break;

            case "firefox":
                tlDriver.set(
                        new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
                break;

            case "edge":
                tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getEdgeOptions()));
                break;

            default:
                break;
            }
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
