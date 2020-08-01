//package com.five88.scripts;
//
//import com.five88.models.AccountModel;
//import com.five88.models.excel.TestData;
//import com.five88.page.AsiaGamePage;
//import com.five88.page.GamePage;
//import com.five88.page.HomePage;
//import com.five88.utils.AccountUtil;
//import com.five88.utils.AppEnum;
//import com.five88.utils.Util;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GameScript extends BaseScript {
//
//    @Test(groups = {GAME_GRP})
//    public void tc_game_1() {
//        AppEnum.GameType type = AppEnum.GameType.FEATURE_GAME;
//        String key = "tc_game_1";
//        WebDriver driver = driverManager.getWebDriver();
//        TestData testData = hashMap.get(key);
//
//        try {
//            HomePage homePage = new HomePage(driver);
//            homePage.open();
//            AccountModel accountModel = AccountUtil.getInstance().getAvailableAccountWithMoney();
//            homePage.enterLoginInfo(accountModel.user, accountModel.pass);
//            homePage.clickLogin();
//
//            boolean result = homePage.isAfterLogin();
//            if (result) {
//                homePage.clickGameTab();
//
//                GamePage game = new GamePage(driver);
//                result = game.isDisplayed();
//                if (result) {
//                    game.clickAsiaTab();
//
//                    AsiaGamePage asiaGamePage = new AsiaGamePage(driver);
//                    asiaGamePage.clickOnRandomGame(type);
//                    Util.switchToLast(driver);
//
//
//
//                    driver.close();
//                    Util.switchToRoot(driver);
//                }
//            }
//
//            assertEquals(result, driver, testData, null);
//        } catch (Exception ex) {
//            assertEquals(false, driver, testData, ex);
//        }
//    }
//}
