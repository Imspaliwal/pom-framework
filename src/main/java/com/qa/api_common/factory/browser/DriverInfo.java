
/*
 * @DriverInfo.java@
 * Created on 06-Sep-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.api_common.factory.browser;

public class DriverInfo {

    private String driverName;
    private String fullDriverPath;
    private String browserVersion;

    // need to check what is the use of checksum
    private long checksum;

    /**
     * @return the driverName
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName
     *            the driverName to set
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return the fullDriverPath
     */
    public String getFullDriverPath() {
        return fullDriverPath;
    }

    /**
     * @param fullDriverPath
     *            the fullDriverPath to set
     */
    public void setFullDriverPath(String fullDriverPath) {
        this.fullDriverPath = fullDriverPath;
    }

    /**
     * @return the browserVersion
     */
    public String getBrowserVersion() {
        return browserVersion;
    }

    /**
     * @param browserVersion
     *            the browserVersion to set
     */
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    /**
     * @return the checksum
     */
    public long getChecksum() {
        return checksum;
    }

    /**
     * @param checksum
     *            the checksum to set
     */
    public void setChecksum(long checksum) {
        this.checksum = checksum;
    }

    @Override
    public String toString() {
        return "DriverInfo [driverName=" + driverName + ", fullDriverPath=" + fullDriverPath + ", browserVersion="
                + browserVersion + ", checksum=" + checksum + "]";
    }

}
