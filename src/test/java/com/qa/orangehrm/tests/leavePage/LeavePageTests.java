
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
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BaseTestNew;

public class LeavePageTests extends BaseTestNew {

    @BeforeTest
    public void leavePageSetup() {

        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        // leavePage = (LeavePage) homePage.navigateTo("Leave");

        // Assert
        Assert.assertEquals(leavePage.isLeavePageHeaderExist(), true,
                "User is not navigated to Leave, Leave page Dashboard header is not displaying ");

    }

    @Test
    public void doSearchLeaveTest() throws InterruptedException {

        System.out.println("Do Leave List Search");

        System.out.println("Approve & Reject Leave");
    }

}
