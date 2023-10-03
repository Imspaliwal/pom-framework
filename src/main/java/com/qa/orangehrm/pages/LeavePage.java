
/*
 * @LeavePage.java@
 * Created on 08-Sep-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.util.AppConstants;

public class LeavePage extends HomePage {

    public LeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
//    By leavePageHeaderLocator = By.xpath("//h6[1]");
    
    @FindBy(how = How.XPATH, using = "//h6[1]")
    WebElement leavePageHeaderLocator;
    
    @FindBy(how = How.XPATH, using = "//form//input[contains(@class, 'oxd-input--active')]")
    WebElement userNameSearchLocator;
    
    @FindBy(how = How.XPATH, using = "//form//button[@type='submit']")
    WebElement searchBtnLocator;
    
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Reset']")
    WebElement resetBtnLocator;
    
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'body')]//div[contains(@class, 'row')]")
    List<WebElement> tableRowLocator;
    
	By inputFieldLocator(String labelName) {
		return By.xpath(String.format(
				"//label[contains(@class, 'label') and normalize-space()='%s']/../following-sibling::div//input[contains(@class, 'input')]",
				labelName));
	}
    
  
    

    // Methods

    public boolean isLeavePageHeaderExist() {

        WebElement leavePageHeader = eleUtil.waitForElementVisible(leavePageHeaderLocator,
                AppConstants.MEDIUM_DEFAULT_WAIT);

        return leavePageHeader.isDisplayed();
    }
    
    

	public int searchSystemUsers(String userName) throws InterruptedException {

		eleUtil.waitForElementVisible(userNameSearchLocator, AppConstants.MEDIUM_DEFAULT_WAIT);
//		eleUtil.clear(userNameSearchLocator);
		eleUtil.doSendKeys(inputFieldLocator("Username"), userName);
		eleUtil.doClick(searchBtnLocator);

		Thread.sleep(3000);

		int count = eleUtil.getElementsCount(tableRowLocator);
		
		eleUtil.doClick(resetBtnLocator);

		return count;

	}

}
