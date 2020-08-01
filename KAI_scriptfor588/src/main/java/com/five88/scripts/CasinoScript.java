package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.*;
import com.five88.utils.AccountUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class CasinoScript extends BaseScript {

    @Test(groups = {CASINO_GRP})
    public void tc_casino_1() {
        String key = "tc_casino_1";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickEuroCasino();

                    EuroCasinoPage euroCasinoPage = new EuroCasinoPage(driver);
                    euroCasinoPage.clickBaccarat();
                    Util.switchToLast(driver);

                    VivoGamingPage vivoGamingPage = new VivoGamingPage(driver);
                    result = vivoGamingPage.isBaccaratDisplayed();

                    driver.close();
                    Util.switchToRoot(driver);
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_2() {
        String key = "tc_casino_2";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickEuroCasino();

                    EuroCasinoPage euroCasinoPage = new EuroCasinoPage(driver);
                    euroCasinoPage.clickRoulette();
                    Util.switchToLast(driver);

                    VivoGamingPage vivoGamingPage = new VivoGamingPage(driver);
                    result = vivoGamingPage.isRouletteDisplayed();

                    driver.close();
                    Util.switchToRoot(driver);
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_3() {
        String key = "tc_casino_3";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickEuroCasino();

                    EuroCasinoPage euroCasinoPage = new EuroCasinoPage(driver);
                    euroCasinoPage.clickBlackJack();
                    Util.switchToLast(driver);

                    VivoGamingPage vivoGamingPage = new VivoGamingPage(driver);
                    result = vivoGamingPage.isBlackJackDisplayed();

                    driver.close();
                    Util.switchToRoot(driver);
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_4() {
        String key = "tc_casino_4";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickAisaCasino();

                    AsiaCasinoPage asiaCasinoPage = new AsiaCasinoPage(driver);
                    asiaCasinoPage.clickBaccarat();

                    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    result = tabs.size() == 2;
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_5() {
        String key = "tc_casino_5";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickAisaCasino();

                    AsiaCasinoPage asiaCasinoPage = new AsiaCasinoPage(driver);
                    asiaCasinoPage.clickRoulette();

                    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    result = tabs.size() == 2;
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_6() {
        String key = "tc_casino_6";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickAisaCasino();

                    AsiaCasinoPage asiaCasinoPage = new AsiaCasinoPage(driver);
                    asiaCasinoPage.clickBlackJack();

                    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    result = tabs.size() == 2;
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_7() {
        String key = "tc_casino_7";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickAisaCasino();

                    AsiaCasinoPage asiaCasinoPage = new AsiaCasinoPage(driver);
                    asiaCasinoPage.clickOverUnder();

                    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    result = tabs.size() == 2;
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_8() {
        String key = "tc_casino_8";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickAisaCasino();

                    AsiaCasinoPage asiaCasinoPage = new AsiaCasinoPage(driver);
                    asiaCasinoPage.clickDragonTiger();

                    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    result = tabs.size() == 2;
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            driver.quit();
        }
    }

    @Test(groups = {CASINO_GRP})
    public void tc_casino_9() {
        String key = "tc_casino_9";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            if (result) {
                homePage.clickCasinoTab();

                CasinoPage casinoPage = new CasinoPage(driver);
                result = casinoPage.isDisplayed();
                if (result) {
                    casinoPage.clickAisaCasino();

                    AsiaCasinoPage asiaCasinoPage = new AsiaCasinoPage(driver);
                    asiaCasinoPage.clickBaccaratNoComm();

                    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
                    result = tabs.size() == 2;
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            driver.quit();
        }
    }

}
