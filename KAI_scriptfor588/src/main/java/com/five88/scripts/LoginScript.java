package com.five88.scripts;

import com.five88.models.AccountModel;
import com.five88.models.excel.TestData;
import com.five88.page.ForgetPWPage;
import com.five88.page.HomePage;
import com.five88.page.PaymentPage;
import com.five88.utils.AccountUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@SuppressWarnings("Duplicates")
public class LoginScript extends BaseScript {

    @Test(groups = {LOGIN_GRP})
    public void tc_login_1() {
        String key = "tc_login_1";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();

            AccountModel accountModel = AccountUtil.getInstance().createRandomAccount();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.verifyUserNotFound();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LOGIN_GRP})
    public void tc_login_2() {
        String key = "tc_login_2";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();

            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            accountModel.pass = Util.generateRandomeString(10);
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.verifyUserIncorrectUserPass();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(dependsOnMethods = "tc_login_1",
            groups = {LOGIN_GRP})
    public void tc_login_3() {
        String key = "tc_login_3";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);
        assertEquals(true, driver, testData, null);
    }

    @Test(groups = {LOGIN_GRP})
    public void tc_login_4() {
        String key = "tc_login_4";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();

            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            accountModel.pass = "";
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.verifyRequirePass();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LOGIN_GRP})
    public void tc_login_5() {
        String key = "tc_login_5";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();

            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            accountModel.user = "";
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.verifyRequireUser();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LOGIN_GRP})
    public void tc_login_6() {
        String key = "tc_login_6";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();

            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccount();
            accountModel.pass = Util.generateRandomeString(10);
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.verifyUserIncorrectUserPass();
            if (result) {
                homePage.clickForgetPW();

                ForgetPWPage forgetPWPage = new ForgetPWPage(driver);
                result = forgetPWPage.isDisplayed();
            }
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LOGIN_GRP})
    public void tc_login_7() {
        String key = "tc_login_7";
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
                PaymentPage paymentPage = new PaymentPage(driver);
                result = paymentPage.isDisplayed();
            }

            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

    @Test(groups = {LOGIN_GRP})
    public void tc_login_8() {
        String key = "tc_login_8";
        WebDriver driver = driverManager.getWebDriver();
        TestData testData = hashMap.get(key);

        try {
            HomePage homePage = new HomePage(driver);
            homePage.open();

            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
            homePage.clickLogin();

            boolean result = homePage.isAfterLogin();
            assertEquals(result, driver, testData, null);
        } catch (Exception ex) {
            assertEquals(false, driver, testData, ex);
        }
    }

}
