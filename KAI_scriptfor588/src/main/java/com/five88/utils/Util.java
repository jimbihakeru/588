package com.five88.utils;

import com.google.gson.GsonBuilder;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class Util {

    public static final void log(String text) {
        if (!TextUtils.isEmpty(text))
            System.out.println(text);
    }

    public static String generateRandomeString(int n) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static String randomNumber(int lenght) {
        // chose a Character random from this String
        String AlphaNumericString = "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(lenght);

        for (int i = 0; i < lenght; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void sleep(long milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Object> String convertToString(T t) {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(t);
    }

    public static void printOut(List<String> list) {
        for (String s : list) Util.log(s);
    }

    public static void clickJS(WebDriver driver, WebElement element) {
        // scrollToElement(driver, element);
        forceClick(driver, element);
        Util.sleep(1000);
    }

    public static void click(WebDriver driver, WebElement element) {
        // scrollToElement(driver, element);
        element.click();
        Util.sleep(1000);
    }

    public static void quit(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");

        driver.quit();
    }

    public static void switchToRoot2(WebDriver driver) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        int size = tabs.size();
        for (int i = size - 1; i > 0; i--) {
            driver.switchTo().window(tabs.get(i));
            driver.close();
        }
        switchToRoot(driver);
    }

    public static void switchToRoot(WebDriver driver) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public static void switchToLast(WebDriver driver) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void openNewWindow(WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
    }

    public static void closeAllTabsExcept(WebDriver driver, String tab) {
        String originalHandle = tab;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }

    // private method

    private static void forceClick(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", element);

        } catch (Exception ex) {
            // ex.printStackTrace();
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].scrollIntoView(true);";
        js.executeScript(script, element);
        Util.sleep(1000);
    }

    public static File screenShot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.FILE);
    }

    public static String getCurrentUrl(WebDriver driver) {
        try {
            int retry = 0;
            int max = 10;
            while (++retry <= max) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                String browserUrl = (String) js.executeScript("return window.top.location.href.toString()");
                if (!browserUrl.equalsIgnoreCase("about:blank"))
                    return browserUrl;
                Util.sleep(100);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void closeWindowByJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "window.onbeforeunload = null;" + "window.close();";
        js.executeScript(script);
    }
}
