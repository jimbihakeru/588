package com.five88.driver;

import com.five88.utils.Constant;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    protected Map<String, WebDriver> hashMap = new HashMap<>();

    protected abstract WebDriver createWebDriver();
    protected abstract WebDriver createWebDriverWithCustomHeader();

    public void quitWebDriver() {
        for (Map.Entry<String, WebDriver> entry : hashMap.entrySet()) {
            WebDriver driver = entry.getValue();
            driver.quit();
        }
    }

    public WebDriver getWebDriver() {
        return createWebDriver();
    }

    public WebDriver getWebDriverWithCustomHeader() {
        return createWebDriverWithCustomHeader();
    }

    protected String getKey() {
        return String.valueOf(Thread.currentThread().getId());
    }

    protected String getKeyCustom() {
        return "thread-" + Thread.currentThread().getId();
    }

    protected void setTimeoutWindowSize(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Constant.TIME_OUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Constant.TIME_OUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Constant.TIME_OUT, TimeUnit.SECONDS);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int Width = (int) toolkit.getScreenSize().getWidth();
        int Height = (int) toolkit.getScreenSize().getHeight();
        driver.manage().window().setSize(new Dimension(Width, Height));
    }
}
