package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.DepositPage;
import com.five88.page.RegisterPage;
import com.five88.utils.AccountUtil;
import com.five88.utils.Util;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class RegisterScript extends BaseScript {

    @Test(groups = {REG_GRP})
    public void tc_register_1() {
        String key = "tc_register_1";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createRandomAccount();
            Util.log("Register: "+ new Gson().toJson(accountModel));
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.isRegisterSuccess();
            if (result) {
                result = registerPage.isAfterLogin();
                if (result) {
                    DepositPage depositPage = new DepositPage(driver);
                    result = depositPage.isDisplayed();
                }
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_2() {
        String key = "tc_register_2";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();
            registerPage.clickRegister();

            boolean result = registerPage.verifyAllEmpty();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_3() {
        String key = "tc_register_3";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyUserExits();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_4() {
        String key = "tc_register_4";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createAccWithAccented();
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyUserAccented();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_5() {
        String key = "tc_register_5";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createAccWithUserLen(5);
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyUserTooShort();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_6() {
        String key = "tc_register_6";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createAccWithUserLen(40);
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyUserTooLong();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_7() {
        String key = "tc_register_7";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createAccWithPassLen(5);
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyPassTooShort();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_8() {
        String key = "tc_register_8";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createAccWithPhoneLen(9);
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyPhoneTooShort();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {REG_GRP})
    public void tc_register_9() {
        String key = "tc_register_9";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.open();

            AccountModel accountModel = AccountUtil.getInstance().createAccWithPhoneLen(30);
            registerPage.enterRegInfo(accountModel.user, accountModel.pass, accountModel.phone);
            registerPage.clickRegister();

            boolean result = registerPage.verifyPhoneTooLong();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

}
