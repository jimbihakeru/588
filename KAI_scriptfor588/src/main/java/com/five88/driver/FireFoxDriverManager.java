package com.five88.driver;

import com.five88.utils.Constant;
import com.five88.utils.Util;
import org.apache.http.HeaderElement;
import org.apache.http.message.BasicHeaderElement;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class FireFoxDriverManager extends DriverManager {

    private final String FF_MOD_HEADER_EXTENSION_PATH = "modify_headers-0.7.1.1-fx.xpi";

    private void init() {
        String path = Constant.DEBUG ? "/Users/mrkai/Documents/F8/geckodriver" : System.getProperty("user.dir") + "\\" + "geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        Util.log(String.format("Path to driver: %s", path));
    }

    @Override
    protected WebDriver createWebDriver() {
        String key = getKey();
        WebDriver driver;

        if (hashMap.containsKey(key)) {
            driver = hashMap.get(key);
            boolean hasQuit = driver.toString().contains("(null)");
            if (hasQuit) {
                driver = create();
                hashMap.put(key, driver);
            }
        } else {
            driver = create();
            hashMap.put(key, driver);
        }

        driver.manage().deleteAllCookies();
        return driver;
    }

    @Override
    protected WebDriver createWebDriverWithCustomHeader() {
        String key = getKeyCustom();
        WebDriver driver;

        if (hashMap.containsKey(key)) {
            driver = hashMap.get(key);
            boolean hasQuit = driver.toString().contains("(null)");
            if (hasQuit) {
                driver = createWithCustomHeader();
                hashMap.put(key, driver);
            }
        } else {
            driver = createWithCustomHeader();
            hashMap.put(key, driver);
        }

        driver.manage().deleteAllCookies();
        return driver;
    }

    private WebDriver create() {
        init();

//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        // firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
//        DesiredCapabilities capability = DesiredCapabilities.firefox();
//        capability.setCapability("firefox_profile", firefoxProfile);
//
//        FirefoxOptions options = new FirefoxOptions(capability);
//        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setCapability("firefox_profile", firefoxProfile);
        capability.setBrowserName("firefox");
        capability.setCapability("marionette", false);
        capability.setPlatform(org.openqa.selenium.Platform.ANY);

        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.setProfile(firefoxProfile);

        WebDriver driver = new FirefoxDriver(options);
        setTimeoutWindowSize(driver);

        return driver;
    }

    private WebDriver createWithCustomHeader() {
        init();

        String expectedResult = "103.99.87.60";
        List<HeaderElement> headerElements = new ArrayList<>();
        headerElements.add(new BasicHeaderElement("X-Forwarded-For", expectedResult));

        String path;
        if (Constant.DEBUG) {
            path = "/Users/mrkai/Documents/F8/project/Five88AutoTest/Five88/src/main/resources/" + FF_MOD_HEADER_EXTENSION_PATH;
        } else {
            path = System.getProperty("user.dir") + "\\" + FF_MOD_HEADER_EXTENSION_PATH;
        }

        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.addExtension(new File(path));
        firefoxProfile.setPreference("extensions.modify_headers.currentVersion", "0.7.1.1-signed");
        firefoxProfile.setPreference("modifyheaders.headers.count", headerElements.size());
        for (int i = 0; i < headerElements.size(); i++) {
            firefoxProfile.setPreference("modifyheaders.headers.action0", "Add");
            firefoxProfile.setPreference("modifyheaders.headers.name" + i, headerElements.get(i).getName());
            firefoxProfile.setPreference("modifyheaders.headers.value" + i, headerElements.get(i).getValue());
            firefoxProfile.setPreference("modifyheaders.headers.enabled" + i, true);
        }
        firefoxProfile.setPreference("modifyheaders.config.active", true);
        firefoxProfile.setPreference("modifyheaders.config.alwaysOn", true);
        firefoxProfile.setPreference("modifyheaders.config.start", true);

        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setCapability("firefox_profile", firefoxProfile);
        capability.setBrowserName("firefox");
        capability.setCapability("marionette", false);
        capability.setPlatform(org.openqa.selenium.Platform.ANY);

        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.setProfile(firefoxProfile);

        WebDriver driver = new FirefoxDriver(options);
        setTimeoutWindowSize(driver);
        return driver;
    }
}
