package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.AsiaSportPage;
import com.five88.page.EuroSportPage;
import com.five88.page.HomePage;
import com.five88.page.SportPage;
import com.five88.utils.AccountUtil;
import com.five88.utils.AppEnum;
import com.five88.utils.Constant;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class SportScript extends BaseScript {

    @Test(groups = {SPORT_GRP})
    public void tc_sport_1() {
        String key = "tc_sport_1";
        if (Constant.BROSER_TYPE == AppEnum.DriverType.FIREFOX) {
            Util.log(String.format("[%s]%s --> Skip", Constant.BROSER_TYPE.toString(), key.toUpperCase()));
            return;
        }
        WebDriver driver = driverManager.getWebDriverWithCustomHeader();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                result = sportPage.isDisplayed();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {SPORT_GRP})
    public void tc_sport_2() {
        String key = "tc_sport_2";
        if (Constant.BROSER_TYPE == AppEnum.DriverType.FIREFOX) {
            Util.log(String.format("[%s]%s --> Skip", Constant.BROSER_TYPE.toString(), key.toUpperCase()));
            return;
        }
        WebDriver driver = driverManager.getWebDriverWithCustomHeader();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                sportPage.clickBetAsia();
                Util.switchToLast(driver);

                AsiaSportPage asiaSportPage = new AsiaSportPage(driver);
                result = asiaSportPage.isDisplayed();
                if (result) result = asiaSportPage.isHanOUDisplayed();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }

        driver.close();
        Util.switchToRoot(driver);
    }

    @Test(groups = {SPORT_GRP})
    public void tc_sport_3() {
        String key = "tc_sport_3";
        if (Constant.BROSER_TYPE == AppEnum.DriverType.FIREFOX) {
            Util.log(String.format("[%s]%s --> Skip", Constant.BROSER_TYPE.toString(), key.toUpperCase()));
            return;
        }
        WebDriver driver = driverManager.getWebDriverWithCustomHeader();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                sportPage.clickBetAsia();
                Util.switchToLast(driver);

                AsiaSportPage asiaSportPage = new AsiaSportPage(driver);
                result = asiaSportPage.isDisplayed();
                if (result) {
                    asiaSportPage.clickRandomOddToday();
                    asiaSportPage.enterRandomStake();
                    asiaSportPage.clickPlaceBet();
                    asiaSportPage.clickYes();
                    asiaSportPage.clickWaitingTab();
                    result = asiaSportPage.isProcessDone();
                    if (result) {
                        asiaSportPage.clickRunningTab();
                        result = asiaSportPage.isLastestBetRunning();
                    }
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }

        driver.close();
        Util.switchToRoot(driver);
    }

    @Test(groups = {SPORT_GRP})
    public void tc_sport_4() {
        String key = "tc_sport_4";
        if (Constant.BROSER_TYPE == AppEnum.DriverType.FIREFOX) {
            Util.log(String.format("[%s]%s --> Skip", Constant.BROSER_TYPE.toString(), key.toUpperCase()));
            return;
        }
        WebDriver driver = driverManager.getWebDriverWithCustomHeader();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                sportPage.clickBetAsia();
                Util.switchToLast(driver);

                AsiaSportPage asiaSportPage = new AsiaSportPage(driver);
                result = asiaSportPage.isDisplayed();
                if (result) {
                    asiaSportPage.clickRandomOddToday();
                    asiaSportPage.enterBelowStake();
                    asiaSportPage.clickPlaceBet();
                    result = asiaSportPage.isShowMinBetWarning();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }

        driver.close();
        Util.switchToRoot(driver);
    }

    @Test(groups = {SPORT_GRP})
    public void tc_sport_5() {
        String key = "tc_sport_5";
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
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                sportPage.clickBetEuro();
                Util.switchToLast(driver);

                EuroSportPage euroSportPage = new EuroSportPage(driver);
                result = euroSportPage.isDisplayed();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }

        driver.close();
        Util.switchToRoot(driver);
    }

    @Test(enabled = false, groups = {SPORT_GRP})
    public void tc_sport_6() {
        String key = "tc_sport_6";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);
        String tab = driver.getWindowHandle();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                sportPage.clickBetEuro();
                Util.switchToLast(driver);

                EuroSportPage euroSportPage = new EuroSportPage(driver);
                result = euroSportPage.isDisplayed();
                if (result) {
                    euroSportPage.clickOddAndEnterMinBet();
                    euroSportPage.clickPlaceBetAndConfirm();
                    result = euroSportPage.isBetSuccess();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            Util.closeAllTabsExcept(driver, tab);
        }

    }

    @Test(enabled = false, groups = {SPORT_GRP})
    public void tc_sport_7() {
        String key = "tc_sport_7";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);
        String tab = driver.getWindowHandle();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickSportTab();

                SportPage sportPage = new SportPage(driver);
                sportPage.clickBetEuro();
                Util.switchToLast(driver);

                EuroSportPage euroSportPage = new EuroSportPage(driver);
                result = euroSportPage.isDisplayed();
                if (result) {
                    euroSportPage.clickOddAndEnterBelowMinBet();
                    euroSportPage.clickPlaceBetAndConfirm();
                    result = euroSportPage.isShowingMinbetWarning();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            Util.closeAllTabsExcept(driver, tab);
        }
    }
}
