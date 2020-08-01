package com.five88.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {

    public static WebElement wait(WebDriver driver, By by, int secode) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, secode);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return null;
    }

    public static WebElement wait(WebDriver driver, WebElement element, int secode) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, secode);
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return null;
    }

    public static Alert alertIsPresent(WebDriver driver, int secode) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, secode);
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return null;
    }

    public static WebDriver waitiframe(WebDriver driver, WebElement iframe, int secode) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, secode);
            return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return null;
    }

    public static WebDriver waitiframeReady(WebDriver driver, WebElement iframe, WebElement element, int second) {
        Util.sleep(5000);
        int retry = 0;
        int max = second / Constant.TIME_OUT;
        while (++retry <= max) {
            try {
                driver = driver.switchTo().frame(iframe);
                boolean isDisplay = DriverUtil.wait(driver, element, Constant.TIME_OUT) != null;
                if (isDisplay) {
                    return driver;
                }
            } catch (Exception ex) {
                driver = driver.switchTo().parentFrame();
            }
        }
        return null;
    }

    public static WebDriver wait2iframeReady(WebDriver driver, WebElement iframe, WebElement element, WebElement iframe2, WebElement element2, int second) {
        Util.sleep(5000);
        int retry = 0;
        int max = second / Constant.TIME_OUT;
        while (++retry <= max) {
            try {
                driver = driver.switchTo().frame(iframe);
                boolean isDisplay = DriverUtil.wait(driver, element, Constant.TIME_OUT) != null;
                if (isDisplay) {
                    driver = driver.switchTo().frame(iframe2);
                    isDisplay = DriverUtil.wait(driver, element2, Constant.TIME_OUT) != null;
                    if (isDisplay) {
                        return driver;
                    }
                }
            } catch (Exception ex) {
                driver = driver.switchTo().defaultContent();
            }
        }
        return null;
    }

    public static boolean waitPageCompleted(WebDriver driver, int secode) {
        try {
            new WebDriverWait(driver, secode).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            return true;
        } catch (Exception ex) {
            // ex.printStackTrace();
        }
        return false;
    }
}
