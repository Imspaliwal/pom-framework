package com.qa.tests.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.util.ElementUtil;

public class GetElementTests extends BaseTest {
	
	ElementUtil eleUtil;
	
	@BeforeClass(description = "Setup before starting test")
	public void setup() {
		
		eleUtil = new ElementUtil(driver);
		
	}
	
	@Test(description = "", enabled = false)
	public void getElementTest() {
		
		driver.findElement(By.xpath(""));
		
	}

	@Test(description = "Test the get elements methods", enabled = false)
	public void getElementsTest_01() {
		
		ElementUtil.sleep(6);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class, 'product-layout col')]"));
		
		eleUtil.getElementsTextList(elements);
		
	}
	
	@Test(description = "Test the get elements methods", enabled = false)
	public void getElementsTest_02() {
		
		ElementUtil.sleep(6);
		
		By elementLocator = By.xpath("//div[contains(@class, 'product-layout col')]");
		
		eleUtil.getElementsTextList(elementLocator);
		
	}
	
	@Test(description = "Test the get elements methods", enabled = false)
	public void getElementsTest_03() {
		
		ElementUtil.sleep(6);
		
		By elementLocator = By.xpath("//div[contains(@class, 'product-layout col')]");
		
		List<WebElement> elements = eleUtil.getElements(elementLocator);
		
		eleUtil.getElementsTextList(elements);
		
	}
	
	
	@Test(description = "Test the get elements methods", enabled = true)
	public void getElementsTest_04() {
		
		ElementUtil.sleep(6);
		
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.navigateTo("Admin", driver);
		
		ElementUtil.sleep(3);
		
		eleUtil.doClick(By.xpath(String.format("//button[normalize-space()='%s']", "Add")));
		ElementUtil.sleep(2);
		eleUtil.doClick(By.xpath(String.format(
				"//label[contains(@class, 'label') and normalize-space()='%s']/../following-sibling::div//div[contains(@class, 'select-text-input')]",
				"User Role")));
		
		ElementUtil.sleep(6);
		
		By elementLocator = By.xpath("//div[contains(@class, 'select-dropdown')]//div[@role='option']");
		
		
		
		List<WebElement> elements = eleUtil.getElements(elementLocator);
		System.out.println("Elements Locators "+elements);
		eleUtil.getElementsTextList(elements);
		
	}

}
