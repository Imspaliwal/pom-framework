
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

	@Test(description = "Verify Admin User added succussfully on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" })
	public void verifyAddAdminUserTest() {
		
		adminPage.userActions("add", "ESS", "Reece MacGyver Klocko", "Enabled", "elonmusk", "Elon123");
		
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
