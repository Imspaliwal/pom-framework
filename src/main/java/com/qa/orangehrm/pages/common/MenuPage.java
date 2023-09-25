
/*
 * @MenuPage.java@
 * Created on 24-Sep-2023
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

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.util.AppConstants;
import com.qa.orangehrm.util.ElementUtil;

public class MenuPage extends ElementUtil {

    protected final ElementUtil eleUtil;

    // Constructor

    public MenuPage(WebDriver driver) {
        super(driver);
        eleUtil = new ElementUtil(driver);

    }

    // Locators

    /**
     * @param menu
     * @return the locator of Root Menu
     */
    private static By rootMenu(String menu) {
        By locator = By.xpath(String.format("//ul//li//span[contains(text(), '%s')]", menu));
        return locator;
    }

    /**
     * @param leafMenu
     * @return the locator of Sub Menu
     */
    private static By leafmenu(String leafMenu) {
        By locator = By.xpath(String.format("//a[contains(text(), '%s')]", leafMenu));
        return locator;
    }

    // Methods

    public void navigateToMenu(String[] names) {

        // JLog.blankLine();
        // JLog.write("Navigation: " + names);

        if (names == null) {
            return;
        }

        // Get Menu locations by Name and perform actions on it
        List<By> locators = getMenuLocators(names);
        By rootMenu = locators.get(0);
        By leafMenu = locators.get(1);

        clickMenuItem(rootMenu, leafMenu);

        // Wait until desired page load
    }

    private static List<By> getMenuLocators(String[] menuNames) {
        List<By> menuLocators = new ArrayList<>();

        for (String menu : menuNames) {
            // String menuXpath;
            if (menuLocators.isEmpty()) {
                // Root Menu
                menuLocators.add(rootMenu(menu));
            } else {
                // Leaf Menu
                menuLocators.add(leafmenu(menu));
            }
        }
        return menuLocators;
    }

    private void clickMenuItem(By rootMenu, By leafMenu) {
        // wait Until rootMenu visiable

        eleUtil.waitForElementVisible(rootMenu, AppConstants.MEDIUM_DEFAULT_WAIT);

        eleUtil.doClick(rootMenu);

        eleUtil.waitForElementVisible(leafMenu, AppConstants.MEDIUM_DEFAULT_WAIT);

        eleUtil.doClick(leafMenu);

    }

}
