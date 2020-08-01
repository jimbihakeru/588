package com.five88.scripts;

import com.five88.driver.DriverManager;
import com.five88.driver.DriverManagerFactory;
import com.five88.models.excel.TestData;
import com.five88.utils.CacheUtil;
import com.five88.utils.Constant;
import com.five88.utils.TelegramUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Map;

public class BaseScript {

    protected DriverManager driverManager;
    protected Map<String, TestData> hashMap;

    protected static final String OTHER_GRP = "OTHER_GRP";
    protected static final String REG_GRP = "REG_GRP";
    protected static final String LOGIN_GRP = "LOGIN_GRP";
    protected static final String DEPOSIT_GRP = "DEPOSIT_GRP";
    protected static final String SPORT_GRP = "SPORT_GRP";
    protected static final String LODE_GRP = "LODE_GRP";
    protected static final String CASINO_GRP = "CASINO_GRP";
    protected static final String KENO_GRP = "KENO_GRP";
    protected static final String DEBUG_GRP = "DEBUG_GRP";

    @Parameters({"suite-name"})
    @AfterSuite(alwaysRun = true)
    public void terminal(String suiteName) {
        System.exit(0);
    }

    @AfterTest(alwaysRun = true)
    public void termial() {
        driverManager.quitWebDriver();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        hashMap = CacheUtil.getInstance().getHashMap();
        driverManager = DriverManagerFactory.getDriverManager(Constant.BROSER_TYPE);
    }

    protected void assertEquals(boolean result, WebDriver driver, TestData testData, Exception ex) {
        if (!result) {
            String msg = String.format("[%s] %s --> Failed", Constant.BROSER_TYPE.toString(), testData.testName);
            if (ex != null)
                msg += String.format(" (Message: %s)", ex.getMessage());

            TelegramUtil.getInstance().sendPhoto(Util.screenShot(driver), msg);
            Util.log(msg);
        } else {
            Util.log(String.format("[%s] %s --> Passed", Constant.BROSER_TYPE.toString(), testData.testName));
        }
        Assert.assertTrue(result);
    }
}
