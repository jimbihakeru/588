package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VivoGamingPage extends BasePage {

    @FindBy(xpath = "//li[@id='menu-nav-baccarat'][@class='selected']")
    WebElement elBaccarat;

    @FindBy(xpath = "//li[@id='menu-nav-roulette'][@class='selected']")
    WebElement elRoulette;

    @FindBy(xpath = "//li[@id='menu-nav-blackjack'][@class='selected']")
    WebElement elBlackJack;// Xi Dach

    public VivoGamingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBaccaratDisplayed() {
        return DriverUtil.wait(driver, elBaccarat, Constant.TIME_OUT_LONG) != null;
    }

    public boolean isRouletteDisplayed() {
        return DriverUtil.wait(driver, elRoulette, Constant.TIME_OUT_LONG) != null;
    }

    public boolean isBlackJackDisplayed() {
        return DriverUtil.wait(driver, elBlackJack, Constant.TIME_OUT_LONG) != null;
    }
}
