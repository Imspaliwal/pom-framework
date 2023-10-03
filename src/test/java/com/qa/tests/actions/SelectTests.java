package com.qa.tests.actions;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.util.AppConstants;
import com.qa.orangehrm.util.ElementUtil;

/**
 * @author spaliwal
 *
 */
public class SelectTests extends BaseTest {

	ElementUtil eleUtil;

	@BeforeClass(description = "Setup before starting test")
	public void setup() {

		eleUtil = new ElementUtil(driver);

	}

	@Test(description = "normal select options tests", enabled = false)
	public void staticDropDownTest_00() {

		By selectLocator = By.xpath("//select[@id='cars']");
		
		eleUtil.scrollToElement(selectLocator);
		
		eleUtil.select(selectLocator, "audi", "value");
		eleUtil.select(selectLocator, "opel", "value");
		
		eleUtil.select(selectLocator, "0", "index");
		
		eleUtil.select(selectLocator, "Saab", "visibletext");
		
		eleUtil.getFirstSelectedOption(selectLocator);
		
		eleUtil.getOptions(selectLocator);
		
	}

	@Test(description = "dynamic drop down tests having html tag ul, li", enabled = true)
	public void dynamicDropDownTest_01() {
		
		// Actual test step

		By dropDownLocator = By.xpath("//label[contains(@class, 'label') and normalize-space()='User Role']/../following-sibling::div//div[contains(@class, 'select-text-input')]");
		By dropDownItemLocator = By.xpath(".//div[contains(@class, 'select-dropdown')]//div[@role='option']");

		// dynamic method to select the option from dropdown
		eleUtil.select("User Role", dropDownLocator, dropDownItemLocator, "ESS");
		
	}

	@Test(description = "dynamic drop down tests having html tag div", enabled = true)
	public void dynamicDropDownTest_02() {

		ElementUtil.sleep(6);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.navigateTo("Admin", driver);
		ElementUtil.sleep(3);

		eleUtil.doClick(By.xpath(String.format("//button[normalize-space()='%s']", "Add")));
		
		By headerLocator = By.xpath("//h6[normalize-space()='Add User']");
		
		eleUtil.waitForElementVisible(headerLocator, AppConstants.MEDIUM_DEFAULT_WAIT);
		
		// Actual test step

		By dropDownLocator = By.xpath("//label[contains(@class, 'label') and normalize-space()='User Role']/../following-sibling::div//div[contains(@class, 'select-text-input')]");
		By dropDownItemLocator = By.xpath(".//div[contains(@class, 'select-dropdown')]//div[@role='option']");

		// dynamic method to select the option from dropdown
		eleUtil.select("User Role", dropDownLocator, dropDownItemLocator, "ESS");

	}

	@Test(description = "dynamic drop down tests having auto-suggestions", enabled = true)
	public void dynamicDropDownTest_03() {
		
		// Actual test step
		
		ElementUtil.sleep(6);
		
		By search = By.xpath("//input[contains(@title, 'Search for Products, Brands and More')]");
		By options = By.xpath(".//form[@action='/search']//li");
		
		String valueToSearch = "iphone 15";
		String valueToSelect ="iphone 15";
		
		eleUtil.select("Search", search, options, valueToSearch, valueToSelect);
		

	}

}
