package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import com.five88.utils.Util;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EuroSportPage extends BasePage {

    @FindBy(id = "iframe")
    WebElement iframe;

    @FindBy(xpath = "//*[text()='Version Châu Âu']")
    WebElement title;

    @FindBy(id = "PlaceBetButton")
    WebElement elPlaceBet;

    @FindBy(xpath = "//div[@data-uat='container-av-events-panel-event-list'][.//span[text()='Sớm']]//div[@data-uat='bet-odds-value']")
    List<WebElement> elOdds;

    @FindBy(xpath = "//div[@data-uat='bet-odds-value']")
    WebElement elOdd;

    @FindBy(xpath = "//div[contains(text(),'Tối thiểu - Tối đa')]")
    WebElement elMinMaxBet;

    @FindBy(xpath = "//*[@id='betslip-body-wrapper']//*[contains(text(),'Mức cược nhỏ nhất là')]")
    WebElement elMinBetWarning;

    @FindBy(id = "ClearBetButton")
    WebElement elClearAllBet;

    @FindBy(xpath = "//*[@id='betting_slip']//*[contains(text(),'Đặt cược được chấp nhận')]")
    WebElement elbetSuccess;

    @FindBy(xpath = "//input[contains(@id,'stake')]")
    WebElement elStake;

    public EuroSportPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/ssport";
        get(url);
    }

    public boolean switchIn() {
        driver = DriverUtil.waitiframeReady(driver, iframe, elOdd, Constant.TIME_OUT_LONG * 2);
        return driver != null ? true : false;
    }

    public boolean isDisplayed() throws Exception {
        if (switchIn()) {
            return isDisplayedOfElement(elOdd, Constant.TIME_OUT_LONG);
        } else {
            Util.log("isDisplayed: false");
            throw new Exception("Can not switch into iframe --> Time out");
        }
    }

    public void clickOddAndEnterMinBet() throws Exception {
        Util.log("clickOddAndEnterMinBet");
        int retry = 0;
        while (++retry <= Constant.TIME_OUT_LONG) {
            clickOnRandomOdd();
            enterMinBet();
            if (!TextUtils.isEmpty(getStake()))
                return;
            else {
                if (isDisplayedOfElement(elClearAllBet))
                    clickClearAllBet();
            }
        }
        throw new Exception(String.format("Can not click on Odd and enter Stake...[%s]", driver.getWindowHandles().size()));
    }

    public void clickOnRandomOdd() {
        Util.log("--clickOnRandomOdd");
        int random = Util.randomNumber(0, elOdds.size() - 1);
        Util.clickJS(driver, elOdds.get(random));
    }

    public void clickPlaceBetAndConfirm() throws Exception {
        Util.log("clickPlaceBetAndConfirm");
        int retry = 0;
        int max = Constant.TIME_OUT_LONG / Constant.TIME_OUT;
        while (++retry <= max) {
            clickPlaceBet();
            boolean result = clickConfirmBet();
            if (result) return;
        }
        throw new Exception(String.format("Alert confirm does not open...[%s]", driver.getWindowHandles().size()));
    }

    public void clickPlaceBet() {
        Util.log("--clickPlaceBet");
        Util.click(driver, elPlaceBet);
    }

    public void enterMinBet() {
        Util.log("--enterMinBet");
        String minBet = getMinBet();
        if (!minBet.isEmpty()) {
            double min = Double.parseDouble(minBet);

            elStake.clear();
            elStake.sendKeys(String.valueOf(min));

            Util.sleep(1000);
        }
    }

    public void clickOddAndEnterBelowMinBet() throws Exception {
        Util.log("clickOddAndEnterBelowMinBet");
        int retry = 0;
        while (++retry <= Constant.TIME_OUT_LONG) {
            clickOnRandomOdd();
            enterBelowMinBet();
            if (!TextUtils.isEmpty(getStake()))
                return;
            else {
                if (isDisplayedOfElement(elClearAllBet)) Util.click(driver, elClearAllBet);
            }
        }
        throw new Exception(String.format("Can not click on Odd and enter Stake...[%s]", driver.getWindowHandles().size()));
    }

    public void enterBelowMinBet() {
        Util.log("--enterBelowMinBet");
        String minBet = getMinBet();
        if (!minBet.isEmpty()) {
            double min = Double.parseDouble(minBet);
            min -= 0.01;
            elStake.clear();
            elStake.sendKeys(String.valueOf(min));

            Util.sleep(1000);
        }
    }

    public String getStake() {
        Util.log("--getStake");
        if (isDisplayedOfElement(elStake))
            return elStake.getAttribute("value").trim();
        return "";
    }

    public boolean clickConfirmBet() {
        Util.log("--clickConfirmBet");
        Alert alert = DriverUtil.alertIsPresent(driver, Constant.TIME_OUT);
        if (alert != null) {
            alert.accept();
            return true;
        }
        return false;
    }

    public String getMinBet() {
        Util.log("--getMinBet");
        if (isDisplayMinMaxbet()) {
            String text = elMinMaxBet.getText();
            text = text.replace("Tối thiểu - Tối đa:", "").trim();
            String[] array = text.split("-");
            return array[0].trim();
        }
        return "";
    }

    public boolean isDisplayMinMaxbet() {
        return isDisplayedOfElement(elMinMaxBet);
    }

    public boolean isShowingMinbetWarning() {
        return isDisplayedOfElement(elMinBetWarning);
    }

    public void clickClearAllBet() {
        Util.click(driver, elClearAllBet);
    }

    public boolean isBetSuccess() {
        return isDisplayedOfElement(elbetSuccess, Constant.TIME_OUT_LONG);
    }
}
