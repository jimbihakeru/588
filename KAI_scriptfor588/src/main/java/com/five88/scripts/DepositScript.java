package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.*;
import com.five88.utils.AccountUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class DepositScript extends BaseScript {

    @Test(groups = {DEPOSIT_GRP})
    public void tc_fivepay_1() {
        String key = "tc_fivepay_1";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabFivePay();

                FivePayTabPage fivePayPartPage = new FivePayTabPage(driver);
                fivePayPartPage.chooseRandomBank();
                fivePayPartPage.enterValidAmout();
                fivePayPartPage.choosePackageIfExist();
                fivePayPartPage.clickDeposit();

                FivePayPage fivePayPage = new FivePayPage(driver);
                result = fivePayPage.isDisplayed();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_fivepay_2() {
        String key = "tc_fivepay_2";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabFivePay();

                FivePayTabPage fivePayPartPage = new FivePayTabPage(driver);
                fivePayPartPage.chooseRandomBank();
                fivePayPartPage.enterInvalidAmout();
                fivePayPartPage.choosePackageIfExist();
                fivePayPartPage.clickDeposit();

                result = depositPage.verifyMinDepositAmount();
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_banking_1() {
        String key = "tc_banking_1";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabTransfer();

                TransferTabPage transferTabPage = new TransferTabPage(driver);
                transferTabPage.clickInternetBanking();
                transferTabPage.chooseRandomBank();
                transferTabPage.enterValidAmount();
                transferTabPage.enterSenderNameIfExist();
                transferTabPage.enterTransCodeIfExist();
                transferTabPage.choosePackingIfExist();
                transferTabPage.clickDeposit();

                result = transferTabPage.isCreateTicketSuccess();
                if (result) {
                    HistoryTransactionPage page = new HistoryTransactionPage(driver);
                    result = page.isDisplayed();
                    if (result)
                        result = page.isLastestTransWaiting();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_banking_2() {
        String key = "tc_banking_2";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabTransfer();

                TransferTabPage transferTabPage = new TransferTabPage(driver);
                transferTabPage.clickInternetBanking();
                transferTabPage.chooseRandomBank();
                transferTabPage.enterInvalidAmount();
                transferTabPage.enterSenderNameIfExist();
                transferTabPage.enterTransCodeIfExist();
                transferTabPage.choosePackingIfExist();
                transferTabPage.clickDeposit();

                result = transferTabPage.verifyMinDepositAmount();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_atm_1() {
        String key = "tc_atm_1";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabTransfer();

                TransferTabPage transferTabPage = new TransferTabPage(driver);
                transferTabPage.clickATM();
                transferTabPage.chooseRandomBank();
                transferTabPage.enterValidAmount();
                transferTabPage.enterSenderNameIfExist();
                transferTabPage.enterTransCodeIfExist();
                transferTabPage.choosePackingIfExist();
                transferTabPage.clickDeposit();

                result = transferTabPage.isCreateTicketSuccess();
                if (result) {
                    HistoryTransactionPage page = new HistoryTransactionPage(driver);
                    result = page.isDisplayed();
                    if (result)
                        result = page.isLastestTransWaiting();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_atm_2() {
        String key = "tc_atm_2";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabTransfer();

                TransferTabPage transferTabPage = new TransferTabPage(driver);
                transferTabPage.clickATM();
                transferTabPage.chooseRandomBank();
                transferTabPage.enterInvalidAmount();
                transferTabPage.enterSenderNameIfExist();
                transferTabPage.enterTransCodeIfExist();
                transferTabPage.choosePackingIfExist();
                transferTabPage.clickDeposit();

                result = transferTabPage.verifyMinDepositAmount();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_quaygd_1() {
        String key = "tc_quaygd_1";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabTransfer();

                TransferTabPage transferTabPage = new TransferTabPage(driver);
                transferTabPage.clickTransCounter();
                transferTabPage.chooseRandomBank();
                transferTabPage.enterValidAmount();
                transferTabPage.enterSenderNameIfExist();
                transferTabPage.enterTransCodeIfExist();
                transferTabPage.choosePackingIfExist();
                transferTabPage.clickDeposit();

                result = transferTabPage.isCreateTicketSuccess();
                if (result) {
                    HistoryTransactionPage page = new HistoryTransactionPage(driver);
                    result = page.isDisplayed();
                    if (result)
                        result = page.isLastestTransWaiting();
                }
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_quaygd_2() {
        String key = "tc_quaygd_2";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabTransfer();

                TransferTabPage transferTabPage = new TransferTabPage(driver);
                transferTabPage.clickTransCounter();
                transferTabPage.chooseRandomBank();
                transferTabPage.enterInvalidAmount();
                transferTabPage.enterSenderNameIfExist();
                transferTabPage.enterTransCodeIfExist();
                transferTabPage.choosePackingIfExist();
                transferTabPage.clickDeposit();

                result = transferTabPage.verifyMinDepositAmount();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_card_1() {
        String key = "tc_quaygd_1";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabCard();

                CardTabPage cardTabPage = new CardTabPage(driver);
                cardTabPage.chooseRandomProvider();
                cardTabPage.chooseRandomCard();
                cardTabPage.enterRandomSerial();
                cardTabPage.enterRandomPin();
                cardTabPage.clickDeposit();

                result = cardTabPage.verifyConfirmCard();
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {DEPOSIT_GRP})
    public void tc_card_2() {
        String key = "tc_quaygd_2";
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
                homePage.clickDeposit();

                DepositPage depositPage = new DepositPage(driver);
                depositPage.clickTabCard();

                CardTabPage cardTabPage = new CardTabPage(driver);
                cardTabPage.chooseRandomProvider();
                cardTabPage.chooseRandomCard();
                cardTabPage.enterRandomSerial();
                cardTabPage.enterRandomPin();
                cardTabPage.clickDeposit();

                result = cardTabPage.verifyConfirmCard();
                if (result) {
                    cardTabPage.clickOKPopUP();
                    result = cardTabPage.verifySystemProcessCheckHistory();
                    if (result) {
                        cardTabPage.clickHistoryTrans();
                        HistoryTransactionPage page = new HistoryTransactionPage(driver);
                        result = page.isLastestTransWaiting();
                    } else {
                        result = cardTabPage.verify4timesWrong();
                    }
                }
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }
}
