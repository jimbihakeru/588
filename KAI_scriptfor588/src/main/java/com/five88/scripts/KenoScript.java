package com.five88.scripts;

import com.five88.dataprovider.DataProviderClass;
import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.HomePage;
import com.five88.page.KenoPage;
import com.five88.utils.AccountUtil;
import com.five88.utils.AppEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class KenoScript extends BaseScript {

    @Test(dataProvider = "data-provider-keno-type", dataProviderClass = DataProviderClass.class,
            groups = {KENO_GRP})
    public void tc_keno_1(AppEnum.KenoType type) {
        String key = getKeyByTypeBet(type);
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);
        testData.testName = key.toUpperCase();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickKenoTab();

                KenoPage kenoPage = new KenoPage(driver);
                result = kenoPage.isDisplayed();
                if (result) {
                    kenoPage.scrollToType(type);
                    kenoPage.waitReadyToBet(type);
                    result = kenoPage.clickRandomOdd(type);
                    // result = kenoPage.isDisplayPopUpBet();
                    if (result) {
                        kenoPage.clickminBetAndPlaceBet(type);
                        // kenoPage.clickMinBet(type);
                        // kenoPage.clickPlaceBet();
                        result = kenoPage.isBetSuccess();
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(dataProvider = "data-provider-keno-type", dataProviderClass = DataProviderClass.class,
            groups = {KENO_GRP})
    public void tc_keno_2(AppEnum.KenoType type) {
        String key = getKeyByTypeNotBet(type);
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);
        testData.testName = key.toUpperCase();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickKenoTab();

                KenoPage kenoPage = new KenoPage(driver);
                result = kenoPage.isDisplayed();
                if (result) {
                    kenoPage.scrollToType(type);
                    kenoPage.waitToStopStatus(type);
                    result = kenoPage.isStopBetting(type);
                }
            }

            assertEquals(result, driver, testData, null);

        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    private String getKeyByTypeBet(AppEnum.KenoType type) {
        String key = "";
        switch (type) {
            case QUICK_KENO_1:
                key = "TC_KENO_1";
                break;

            case QUICK_KENO_2:
                key = "TC_KENO_3";
                break;

            case MAX_KENO_1:
                key = "TC_KENO_5";
                break;

            case MAX_KENO_2:
                key = "TC_KENO_7";
                break;

            case XUAN:
                key = "TC_KENO_9";
                break;

            case HA:
                key = "TC_KENO_11";
                break;

            case THU:
                key = "TC_KENO_13";
                break;

            case DONG:
                key = "TC_KENO_15";
                break;
        }
        return key.toLowerCase();
    }

    private String getKeyByTypeNotBet(AppEnum.KenoType type) {
        String key = "";
        switch (type) {
            case QUICK_KENO_1:
                key = "TC_KENO_2";
                break;

            case QUICK_KENO_2:
                key = "TC_KENO_4";
                break;

            case MAX_KENO_1:
                key = "TC_KENO_6";
                break;

            case MAX_KENO_2:
                key = "TC_KENO_8";
                break;

            case XUAN:
                key = "TC_KENO_10";
                break;

            case HA:
                key = "TC_KENO_12";
                break;

            case THU:
                key = "TC_KENO_14";
                break;

            case DONG:
                key = "TC_KENO_16";
                break;
        }
        return key.toLowerCase();
    }
}
