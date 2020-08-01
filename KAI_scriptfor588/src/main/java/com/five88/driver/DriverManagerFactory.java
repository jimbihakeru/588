package com.five88.driver;

import com.five88.utils.AppEnum;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(AppEnum.DriverType type) {
        DriverManager driverManager = null;
        switch (type) {

            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;

            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }

}
