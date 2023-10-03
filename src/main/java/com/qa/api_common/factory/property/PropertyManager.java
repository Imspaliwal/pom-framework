
/*
 * @PropertyManager.java@
 * Created on 07-Jul-2023
 *
 * Copyright (c) 2023 Imspaliwal.
 * All Rights Reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF Imspaliwal
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 */
package com.qa.api_common.factory.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private Properties prop;

    public Properties init_prop() {

        // Properties object
        prop = new Properties();

        // Define input stream to get property files
        FileInputStream ip = null;

        // fetch right property file in input stream
        String envName = System.getProperty("env");
        System.out.println("Environment name is: " + envName);

        String userDir = System.getProperty("user.dir");
        System.out.println("User Dir name is: " + userDir);
        String os = System.getProperty("os.name");
        System.out.println("OS name is: " + os);
        String javaVersion = System.getProperty("java.runtime.version");
        System.out.println("Java Runtime Version name is: " + javaVersion);

        try {
            if (envName == null) {
                System.out.println("Env name is not given... Running tests on QA environment");
                ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/config.properties");
            } else {
                System.out.println("Running tests on env: " + envName);

                switch (envName.toLowerCase().trim()) {
                case "qa":
                    ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/qa.config.properties");
                    break;
                case "dev":
                    ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/dev.config.properties");
                    break;
                case "stage":
                    ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/stage.config.properties");
                    break;
                case "uat":
                    ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/uat.config.properties");
                    break;
                case "prod":
                    ip = new FileInputStream("./src/test/resources/com/qa/orangehrm/config/prod.config.properties");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // load property file
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}
