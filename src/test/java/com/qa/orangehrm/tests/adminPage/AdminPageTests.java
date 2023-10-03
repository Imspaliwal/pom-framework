
/*
 * @AdminPageTests.java@
 * Created on 09-Jul-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.orangehrm.tests.adminPage;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.common.NavigateFactory;

public class AdminPageTests extends BaseTest {

	@BeforeTest
	public void adminPageSetup() throws InterruptedException {

		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

		adminPage = (AdminPage) NavigateFactory.navigate("Admin", driver);
		adminPage.navigateTo("Admin", driver);

		// adminPage = homePage.navigateTo("Admin");

		// Assert
		Assert.assertEquals(adminPage.isAdminPageHeaderExist(), true,
				"User is not navigated to Admin, Admin page Dashboard header is not displaying ");

	}

	@Test(description = "Verify user exist by searching all search parameter on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" })
	public void doSearchByUserNameTest() throws InterruptedException {

		int userCount = adminPage.searchSystemUsers("admin");

		// Assert
		Assert.assertEquals(userCount, 1, "User name is not searched correctly");

	}
	
	@Test(description = "Verify user exist by searching all search parameter on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" }, dataProvider = "SearchUserDataProvider")
	public void doSearchByUserNameWithDataProviderTest(String userName) throws InterruptedException {

		int userCount = adminPage.searchSystemUsers(userName);

		// Assert
		Assert.assertEquals(userCount, 1, "User name is not searched correctly");

	}
	
	@DataProvider(name = "SearchUserDataProvider")
	public Object[]	searchUserDataProvider() {
		
		Object[] data = new Object[3];
		
		data[0] = "Admin";
		data[1] = "Hana Nguyen";
		data[2] = "JohnWick";
		
		return data;
	}

	@Test(description = "Verify Admin User added succussfully on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" })
	public void verifyAddAdminUserTest() {
		
		adminPage.userActions("add", "ESS", "Reece MacGyver Klocko", "Enabled", "elonmusk", "Elon123");
		
	}
	
	@Test(description = "Verify Admin User added succussfully on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" }, dataProvider = "AddUserDataProvider")
	public void verifyAddAdminUserWithDataProviderTest(String userRole, String employeeName, String status, String username, String password) {
		
		adminPage.userActions("add", userRole, employeeName, status, username, password);
		
	}
	
	@DataProvider(name = "AddUserDataProvider")
	public Object[]	addUserDataProvider() {
		
		Object[][] data = new Object[3][5];
		
		// First Row
		data[0][0] = "ESS";
		data[0][1] = "Adelbert Bernier";
		data[0][2] = "Enabled";
		data[0][3] = "elonmusk";
		data[0][4] = "Elon123";
		
		// Second Row
		data[1][0] = "Admin";
		data[1][1] = "Test User153";
		data[1][2] = "Enabled";
		data[1][3] = "therock";
		data[1][4] = "therock123";
		
		// Third Row
		data[2][0] = "ESS";
		data[2][1] = "Test User27";
		data[2][2] = "Enabled";
		data[2][3] = "JohnWick";
		data[2][4] = "JohnWick123";
		
		return data;
	}

	@Test(description = "Verify Admin User deleted succussfully on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" })
	public void verifyDeleteAdminUserTest() {

	}

	@Test(description = "Verify Admin User updated succussfully on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" })
	public void verifyUpdateAdminUserTest() {

	}

	// Admin > Qualifications > Skills page Test

	@Test(description = "Verify user able to add Skills on Qualifications page", enabled = false, groups = {
			"Admin Suite", "Qualifications Suite", "Qualifications Skills Suite", "Regression Suite" })
	public void verifyAddSkillsTest() {
	}

	@Test(description = "Verify user able to delete Skills on Qualifications page", enabled = false, groups = {
			"Admin Suite", "Qualifications Suite", "Qualifications Skills Suite", "Regression Suite" })
	public void verifyDeleteSkillsTest() {
	}

	@Test(description = "Verify the list of skills name by it description on Qualifications page", enabled = false, groups = {
			"Admin Suite", "Qualifications Suite", "Qualifications Skills Suite", "Regression Suite" })
	public void verifySkillsByDescriptionTest() {
		adminPage.listSkills("Description");
	}

}
