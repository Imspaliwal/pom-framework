package com.qa.api_common.tests.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.api_common.util.ElementUtil;
import com.qa.orangehrm.base.BaseTest;

public class InputFieldTests extends BaseTest {

	ElementUtil eleUtil;

	@BeforeClass(description = "Setup before starting test")
	public void setup() {

		eleUtil = new ElementUtil(driver);

	}

	@Test(description = "normal clear input tests", enabled = true)
	public void clearFieldTest_00() {
		
		ElementUtil.sleep(10);

		By userIdLocator = By.xpath(".//input[@id='userId']");
		
		WebElement passwordLocator = eleUtil.getElement(By.xpath("//input[@id='pass']"));
		
//		eleUtil.doSendKeys(userIdLocator, "abc@abc.com");
		eleUtil.executeScript(eleUtil.getElement(userIdLocator), "abc@abc.com");
		
		
		eleUtil.doSendKeys(passwordLocator, "Type this");
		
		ElementUtil.sleep(10);
		
		eleUtil.clear(eleUtil.getElement(userIdLocator));
		
		eleUtil.clear(passwordLocator);
		
		ElementUtil.sleep(10);

		
	}
	
	
	@Test(description = "Disable input tests", enabled = true)
	public void clearFieldTest_01() {
		
		ElementUtil.sleep(10);

		By firstNameLocator = By.xpath("//input[@placeholder='First Enter name']");
		
		WebElement lastNameLocator = eleUtil.getElement(By.xpath("//input[@placeholder='Enter Last name']"));
		
		eleUtil.doSendKeys(firstNameLocator, "abcasd");
		
		
		eleUtil.doSendKeys(lastNameLocator, "Type this");
		
		ElementUtil.sleep(10);
		
		eleUtil.clear(eleUtil.getElement(firstNameLocator));
		
		eleUtil.clear(lastNameLocator);
		
		ElementUtil.sleep(10);

		
	}
}
