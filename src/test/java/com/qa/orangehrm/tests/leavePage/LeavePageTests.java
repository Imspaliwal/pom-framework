
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
package com.qa.orangehrm.tests.leavePage;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTest;
import com.qa.orangehrm.pages.AdminPage;
import com.qa.orangehrm.pages.LeavePage;
import com.qa.orangehrm.pages.common.NavigateFactory;

public class LeavePageTests extends BaseTest {

    @BeforeTest
    public void leavePageSetup() {

        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        
//		leavePage = (LeavePage) NavigateFactory.navigate("Leave", driver);
//		leavePage.navigateTo("Leave", driver);
//
//        // Assert
//        Assert.assertEquals(leavePage.isLeavePageHeaderExist(), true,
//                "User is not navigated to Leave, Leave page Dashboard header is not displaying ");
        
        leavePage = (LeavePage) NavigateFactory.navigate("Leave", driver);
        leavePage.navigateTo("Admin", driver);

		// adminPage = homePage.navigateTo("Admin");

		// Assert
//		Assert.assertEquals(leavePage.isAdminPageHeaderExist(), true,
//				"User is not navigated to Admin, Admin page Dashboard header is not displaying ");

    }

    @Test
    public void doSearchLeaveTest() throws InterruptedException {

        System.out.println("Do Leave List Search");

        System.out.println("Approve & Reject Leave");
    }
    
	@Test(description = "Verify user exist by searching all search parameter on User Management page", enabled = true, groups = {
			"Admin Suite", "User Management Suite", "Regression Suite" }, dataProvider = "SearchUserDataProvider")
	public void doSearchByUserNameWithDataProviderTest(String userName) throws InterruptedException {

		int userCount = leavePage.searchSystemUsers(userName);

		// Assert
		Assert.assertEquals(userCount, 1, "User name is not searched correctly");

	}
	
	@DataProvider(name = "SearchUserDataProvider")
	public Object[]	searchUserDataProvider() {
		
		// Exception if parameter do not match in calling method
		// org.testng.internal.reflect.MethodMatcherException
		
		Object[] data = new Object[3];
		
		data[0] = "Admin";
		data[1] = "Hana Nguyen";
		data[2] = "JohnWick";
		
		return data;
	}

}
