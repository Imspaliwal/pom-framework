
/*
 * @OptionsFactory.java@
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

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

    private final Properties prop;

    private ChromeOptions chromeOpts;
    private FirefoxOptions firefoxOpts;
    private EdgeOptions edgeOpts;

    public OptionsManager(Properties prop) {
        this.prop = prop;
    }

    public ChromeOptions getChromeOptions() {

        chromeOpts = new ChromeOptions();

        // Set Chrome Verison
        chromeOpts.setBrowserVersion(prop.getProperty("chromebrowserversion"));

        if (Boolean.parseBoolean(prop.getProperty("remote"))) {

            chromeOpts.setCapability("browserName", "chrome");
            // chromeOpts.setBrowserVersion(prop.getProperty("chromebrowserversion"));

        }

        return chromeOpts;

    }

    public FirefoxOptions getFirefoxOptions() {

        firefoxOpts = new FirefoxOptions();

        // Set Firefox Version --- not working for now
        // firefoxOpts.setBrowserVersion(prop.getProperty("firefoxbrowserversion"));

        if (Boolean.parseBoolean(prop.getProperty("remote"))) {

            firefoxOpts.setCapability("browserName", "firefox");

        }

        return firefoxOpts;

    }

    public EdgeOptions getEdgeOptions() {

        edgeOpts = new EdgeOptions();

        // set Edge Version
        edgeOpts.setBrowserVersion(prop.getProperty("edgebrowserversion"));

        if (Boolean.parseBoolean(prop.getProperty("remote"))) {

            edgeOpts.setCapability("browserName", "MicrosoftEdge");

        }
        return edgeOpts;
    }

}
