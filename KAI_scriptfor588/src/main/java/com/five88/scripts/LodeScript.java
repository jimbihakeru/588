package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.HomePage;
import com.five88.page.LodePage;
import com.five88.utils.AccountUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class LodeScript extends BaseScript {

    @Test(groups = {LODE_GRP})
    public void tc_lode_1() {
        String key = "tc_lode_1";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickLodeTab();

                LodePage lodePage = new LodePage(driver);
                result = lodePage.isDisplayed();
                if (result) {
                    lodePage.clickMienBacTab();
                    lodePage.chooseRandomDai();
                    lodePage.clickLo2();
                    lodePage.clickRandomNumer();
                    lodePage.enterStake();
                    lodePage.clickPlaceBet();
                    if (!lodePage.isDisplayLast10Mins()) {
                        result = lodePage.isConfirmDisplayed();
                        if (result) {
                            lodePage.clickOk();
                            result = lodePage.isBetSuccess();
                        }
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LODE_GRP})
    public void tc_lode_2() {
        String key = "tc_lode_2";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickLodeTab();

                LodePage lodePage = new LodePage(driver);
                result = lodePage.isDisplayed();
                if (result) {
                    lodePage.clickMienBacTab();
                    lodePage.chooseRandomDai();
                    lodePage.clickLo3();
                    lodePage.clickRandomNumer();
                    lodePage.enterStake();
                    lodePage.clickPlaceBet();
                    if (!lodePage.isDisplayLast10Mins()) {
                        result = lodePage.isConfirmDisplayed();
                        if (result) {
                            lodePage.clickOk();
                            result = lodePage.isBetSuccess();
                        }
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LODE_GRP})
    public void tc_lode_3() {
        String key = "tc_lode_3";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickLodeTab();

                LodePage lodePage = new LodePage(driver);
                result = lodePage.isDisplayed();
                if (result) {
                    lodePage.clickMienTrangTab();
                    lodePage.chooseRandomDai();
                    lodePage.clickLo2();
                    lodePage.clickRandomNumer();
                    lodePage.enterStake();
                    lodePage.clickPlaceBet();
                    if (!lodePage.isDisplayLast10Mins()) {
                        result = lodePage.isConfirmDisplayed();
                        if (result) {
                            lodePage.clickOk();
                            result = lodePage.isBetSuccess();
                        }
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LODE_GRP})
    public void tc_lode_4() {
        String key = "tc_lode_4";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickLodeTab();

                LodePage lodePage = new LodePage(driver);
                result = lodePage.isDisplayed();
                if (result) {
                    lodePage.clickMienTrangTab();
                    lodePage.chooseRandomDai();
                    lodePage.clickLo3();
                    lodePage.clickRandomNumer();
                    lodePage.enterStake();
                    lodePage.clickPlaceBet();
                    if (!lodePage.isDisplayLast10Mins()) {
                        result = lodePage.isConfirmDisplayed();
                        if (result) {
                            lodePage.clickOk();
                            result = lodePage.isBetSuccess();
                        }
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LODE_GRP})
    public void tc_lode_5() {
        String key = "tc_lode_5";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickLodeTab();

                LodePage lodePage = new LodePage(driver);
                result = lodePage.isDisplayed();
                if (result) {
                    lodePage.clickMienNamTab();
                    lodePage.chooseRandomDai();
                    lodePage.clickLo2();
                    lodePage.clickRandomNumer();
                    lodePage.enterStake();
                    lodePage.clickPlaceBet();
                    if (!lodePage.isDisplayLast10Mins()) {
                        result = lodePage.isConfirmDisplayed();
                        if (result) {
                            lodePage.clickOk();
                            result = lodePage.isBetSuccess();
                        }
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LODE_GRP})
    public void tc_lode_6() {
        String key = "tc_lode_6";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickLodeTab();

                LodePage lodePage = new LodePage(driver);
                result = lodePage.isDisplayed();
                if (result) {
                    lodePage.clickMienNamTab();
                    lodePage.chooseRandomDai();
                    lodePage.clickLo3();
                    lodePage.clickRandomNumer();
                    lodePage.enterStake();
                    lodePage.clickPlaceBet();
                    if (!lodePage.isDisplayLast10Mins()) {
                        result = lodePage.isConfirmDisplayed();
                        if (result) {
                            lodePage.clickOk();
                            result = lodePage.isBetSuccess();
                        }
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }
}
