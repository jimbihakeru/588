package com.five88.driver;

import com.five88.utils.Constant;
import com.five88.utils.FileUtils;
import com.five88.utils.Util;
import com.five88.utils.ZipUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.http.HeaderElement;
import org.apache.http.message.BasicHeaderElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("Duplicates")
public class ChromeDriverManager extends DriverManager {

    private final String CHROME_HEADER_EXTENSION_PATH = "chrome_extension";
    private final String HEADER_JSON_NAME = "header.json";

    private void init() {
        String path = Constant.DEBUG ? "/Users/mrkai/Documents/F8/chromedriver" : System.getProperty("user.dir")+ "/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
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
       // init();

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        // options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        setTimeoutWindowSize(driver);
        
        return driver;
    }

    private WebDriver createWithCustomHeader() {
        init();

        String expectedResult = "103.99.87.60";
        List<HeaderElement> headerElements = new ArrayList<>();
        headerElements.add(new BasicHeaderElement("X-Forwarded-For", expectedResult));

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        // options.addArguments("--incognito");
        // options.addArguments("--headless");

        String unpackedExtensionPath;
        String path;
        if (Constant.DEBUG) {
            unpackedExtensionPath = "/Users/mrkai/Documents/F8/project/Five88AutoTest/Five88/src/main/resources/" + CHROME_HEADER_EXTENSION_PATH;
            path = unpackedExtensionPath + "/" + HEADER_JSON_NAME;
        } else {
            unpackedExtensionPath = System.getProperty("user.dir") + "\\" + CHROME_HEADER_EXTENSION_PATH;
            path = unpackedExtensionPath + "\\" + HEADER_JSON_NAME;
        }
        Util.log(String.format("Path to header.json: %s", path));

        FileUtils.writeToJson(path, headerElements);
        String crxExtensionPath = ZipUtils.packZipWithNameOfFolder(unpackedExtensionPath, "crx");
        options.addExtensions(new File(crxExtensionPath));

        WebDriver driver = new ChromeDriver(options);
        setTimeoutWindowSize(driver);

        return driver;
    }
}
