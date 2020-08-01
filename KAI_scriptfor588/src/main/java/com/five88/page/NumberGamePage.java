package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NumberGamePage extends BasePage {

    @FindBy(xpath = "//*[@id='main']//iframe")
    WebElement iframe;

    @FindBy(xpath = "//*[text()='Tổng số tiền đã cược Turbo Numbergame']")
    WebElement title;

    @FindBy(xpath = "//div[contains(@class,'numberBall')]")
    WebElement elBall;

    @FindBy(xpath = "//*[@id='betProcessContainer']//button[text()='Đặt cược']")
    WebElement elPlaceBet;

    @FindBy(xpath = "//*[text()='Đã được chấp nhận']")
    WebElement elBetSuccess;

    @FindBy(xpath = "//*[text()='Không thể đặt cược.']")
    WebElement elCannotBet;

    public NumberGamePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/numbergame.aspx";
        get(url);
    }

    public boolean isDisplayed() throws Exception {
        driver = DriverUtil.waitiframeReady(driver, iframe, elBall, Constant.TIME_OUT_LONG * 2);
        if (driver != null) {
            return isDisplayedOfElement(elBall);
        } else {
            Util.log("isDisplayed: false");
            throw new Exception("Can not switch into iframe --> Time out");
        }
    }

    public void clickPlaceBet() {
        Util.clickJS(driver, elPlaceBet);
    }

    public boolean isPlaceBetDisplayed() {
        return isDisplayedOfElement(elPlaceBet);
    }

    public boolean isBetSuccess() {
        return isDisplayedOfElement(elBetSuccess);
    }

    public boolean isCannotBet() {
        return isDisplayedOfElement(elCannotBet);
    }
}
