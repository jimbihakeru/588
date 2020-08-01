package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.*;
import com.five88.utils.AccountUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class Five88Script extends BaseScript {

    @Test(groups = {OTHER_GRP})
    public void tc_home_1() {
        String key = "tc_home_1";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            homePage.clickRegister();

            RegisterPage registerPage = new RegisterPage(driver);
            boolean result = registerPage.isDisplayed();

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            // driver.quit();
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_logout_1() {
        String key = "tc_logout_1";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();
            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = false;
            PaymentPage paymentPage = new PaymentPage(driver);
            if (paymentPage.isDisplayed()) {
                paymentPage.clickLogout();
                result = homePage.isDisplayed();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            // driver.quit();
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_account_1() {
        String key = "tc_account_1";
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
                AccountPage accountPage = new AccountPage(driver);
                accountPage.open();

                int amountMainWalletBefore = accountPage.getMainWalletAmount();
                int amountAWalletBefore = accountPage.getAWalletAmount();

                int random = (amountMainWalletBefore + amountAWalletBefore) / Util.randomNumber(2, 4);
                accountPage.enterAmountOnAWallet(random);
                int am = accountPage.getAWalletAmount();

                int retry = 0;
                while (am == 0 && ++retry <= 3) {
                    // accountPage.clickClosePopUpIfExit();
                    accountPage.enterAmountOnAWallet(random);
                    am = accountPage.getAWalletAmount();
                }

                result = am != 0;
                if (result) {
                    accountPage.clickConfirm();

                    result = accountPage.isConfirmDisplayed();
                    if (result) {
                        accountPage.refresh();

                        int amountMainWalletAfter = accountPage.getMainWalletAmount();
                        int amountAWalletAfter = accountPage.getAWalletAmount();

                        boolean r1 = amountMainWalletAfter + amountAWalletAfter == amountMainWalletBefore + amountAWalletBefore;
                        boolean r2 = random == amountAWalletAfter;
                        result = r1 && r2;
                    }
                }
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            // driver.quit();
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_account_2() {
        String key = "tc_account_2";
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
                AccountPage accountPage = new AccountPage(driver);
                accountPage.open();

                int amountMainWalletBefore = accountPage.getMainWalletAmount();
                int amountAWalletBefore = accountPage.getAWalletAmount();

                int random = (amountMainWalletBefore + amountAWalletBefore) / Util.randomNumber(2, 4);
                accountPage.enterAmountOnMaiWallet(random);
                int am = accountPage.getMainWalletAmount();

                int retry = 0;
                while (am == 0 && ++retry <= 3) {
                    // accountPage.clickClosePopUpIfExit();
                    accountPage.enterAmountOnMaiWallet(random);
                    am = accountPage.getMainWalletAmount();
                }

                result = am != 0;
                if (result) {
                    accountPage.clickConfirm();

                    result = accountPage.isConfirmDisplayed();
                    if (result) {
                        accountPage.refresh();

                        int amountMainWalletAfter = accountPage.getMainWalletAmount();
                        int amountAWalletAfter = accountPage.getAWalletAmount();

                        boolean r1 = amountMainWalletAfter + amountAWalletAfter == amountMainWalletBefore + amountAWalletBefore;
                        boolean r2 = random == amountMainWalletAfter;
                        result = r1 && r2;
                    }
                }
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            // driver.quit();
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_account_3() {
        String key = "tc_account_3";
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
                AccountPage accountPage = new AccountPage(driver);
                accountPage.open();

                int amountMainWalletBefore = accountPage.getMainWalletAmount();
                int amountAWalletBefore = accountPage.getAWalletAmount();

                int random = amountMainWalletBefore + amountAWalletBefore * 100;
                accountPage.enterAmountOnAWallet(random);
                int am = accountPage.getAWalletAmount();

                int retry = 0;
                while (am == 0 && ++retry <= 3) {
                    // accountPage.clickClosePopUpIfExit();
                    accountPage.enterAmountOnAWallet(random);
                    am = accountPage.getAWalletAmount();
                }

                result = am != 0;
                if (result) {
                    accountPage.clickConfirm();
                    result = accountPage.verifyConfirmAmountNotEnough();
                }
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            // driver.quit();
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_account_4() {
        String key = "tc_account_4";
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
                AccountPage accountPage = new AccountPage(driver);
                accountPage.open();

                int amountMainWalletBefore = accountPage.getMainWalletAmount();
                int amountAWalletBefore = accountPage.getAWalletAmount();

                int random = amountMainWalletBefore + amountAWalletBefore * 100;
                accountPage.enterAmountOnMaiWallet(random);
                int am = accountPage.getMainWalletAmount();

                int retry = 0;
                while (am == 0 && ++retry <= 3) {
                    // accountPage.clickClosePopUpIfExit();
                    accountPage.enterAmountOnMaiWallet(random);
                    am = accountPage.getMainWalletAmount();
                }

                result = am != 0;
                if (result) {
                    accountPage.clickConfirm();
                    result = accountPage.verifyConfirmAmountNotEnough();
                }
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        } finally {
            // driver.quit();
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_ng_1() {
        String key = "tc_ng_1";
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
                homePage.clickNumberGameTab();

                NGTurboPage turboPage = new NGTurboPage(driver);
                result = turboPage.isDisplayed();
                if (result) {
                    turboPage.waitAndClickOdd();
                    turboPage.clickPlaceBet();
                    result = turboPage.isBetSuccess();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_ng_2() {
        String key = "tc_ng_2";
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
                homePage.clickNumberGameTab();

                NGTurboPage turboPage = new NGTurboPage(driver);
                result = turboPage.isDisplayed();
                if (result) {
                    turboPage.waitReadyToBet();
                    turboPage.waitNoMoreBet();
                    turboPage.clickRandomBall();
                    result = turboPage.isCannotBet();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_ng_3() {
        String key = "tc_ng_3";
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
                homePage.clickNumberGameTab();

                NGNormalPage normalPage = new NGNormalPage(driver);
                result = normalPage.isDisplayed();
                if (result) {
                    normalPage.waitAndClickOdd();
                    normalPage.clickPlaceBet();
                    result = normalPage.isBetSuccess();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {OTHER_GRP})
    public void tc_ng_4() {
        String key = "tc_ng_4";
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
                homePage.clickNumberGameTab();

                NGNormalPage normalPage = new NGNormalPage(driver);
                result = normalPage.isDisplayed();
                if (result) {
                    normalPage.waitReadyToBet();
                    normalPage.waitNoMoreBet();
                    normalPage.clickRandomBall();
                    result = normalPage.isCannotBet();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

}
