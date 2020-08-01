package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsiaSportPage extends BasePage {

    @FindBy(id = "iframe")
    WebElement eliframe;

    @FindBy(id = "sportsFrame")
    WebElement elsportsFrame;

    @FindBy(xpath = "//*[@title='Số tiền khả dụng']")
    WebElement title;

    @FindBy(id = "athenaMainContainer")
    WebElement elAthenaMainContainer;

    @FindBy(xpath = "//div[@class='oddsBet']")
    WebElement elOdd;

    @FindBy(xpath = "//div[@class='leagueGroup'][.//div[@class='binding']]//div[@class='oddsBet']")
    WebElement elOddToday;

    @FindBy(xpath = "//div" +
            "[contains(@class,'sportsMenu')]" +
            "[./div[@title='Mọi môn thể thao']]" +
            "[.//div[contains(@class,'active icon-sportsMenu-today')]]" +
            "//li[contains(@class,'active')]//span[text()='Kèo Chấp & Tài Xỉu']")
    WebElement elHanOU;

    @FindBy(xpath = "//*[text()='BỎ QUA']")
    WebElement elSkip;

    @FindBy(id = "betSlipStake")
    WebElement elStake;

    @FindBy(xpath = "//button[text()='Đặt Cược']")
    WebElement elPlaceBet;

    @FindBy(xpath = "//*[text()='Xác nhận đặt cược?']")
    WebElement elConfirm;

    @FindBy(xpath = "//*[text()='Có']")
    WebElement elYes;

    @FindBy(xpath = "//*[text()='Thông Báo' or text()='Sự chú ý']")
    WebElement elNote;

    @FindBy(xpath = "//*[text()='OK']")
    WebElement elOK;

    @FindBy(xpath = "//*[text()='Đang Chạy']")
    WebElement elRunningTab;

    @FindBy(xpath = "//*[text()='Đang Chờ']")
    WebElement elWaitingTab;

    @FindBy(xpath = "//*[text()='Không có cược chưa xử lý']")
    WebElement elNoWaitingTitle;

    @FindBy(xpath = "//*[@id='mainSection'][contains(@class,'running')]//div[@id][1]//div[text()='Đang Diễn Ra']")
    WebElement elLastestBetRunning;

    @FindBy(xpath = "//*[text()='Tiền cược của bạn thấp hơn tiền cược tối thiểu.']")
    WebElement elMinBetWarning;

    public AsiaSportPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/fsport/live-sports";
        get(url);
    }

    private boolean switchIn() throws Exception {
        driver = DriverUtil.wait2iframeReady(driver, eliframe, elAthenaMainContainer, elsportsFrame, elOdd, Constant.TIME_OUT_LONG * 2);
        if (driver != null) {
            return true;
        } else {
            Util.log("isDisplayed: false");
            throw new Exception("Can not switch into iframe --> Time out");
        }
    }

    private void switchOut() {
        driver.switchTo().defaultContent();
    }

    public boolean isDisplayed() throws Exception {
        // Util.sleep(Constant.TIME_OUT_LONG * 1000);
        boolean result = false;
        if (switchIn()) {
            result = isDisplayedOfElement(elOdd, Constant.TIME_OUT_LONG);
            if (result) clickSkipIfExit();
        }
        return result;
    }

    public boolean isHanOUDisplayed() {
        return isDisplayedOfElement(elHanOU);
    }

    public void clickSkipIfExit() {
        if (isDisplayedOfElement(elSkip))
            Util.clickJS(driver, elSkip);
    }

    public void clickRandomOdd() {
        Util.clickJS(driver, elOdd);
    }

    public void clickRandomOddToday() {
        Util.clickJS(driver, elOddToday);
    }

    public void enterRandomStake() {
        int random = Util.randomNumber(50, 60);
        elStake.clear();
        elStake.sendKeys(String.valueOf(random));
    }

    public void enterBelowStake() {
        elStake.clear();
        elStake.sendKeys(String.valueOf(10));
    }

    public void clickPlaceBet() {
        Util.clickJS(driver, elPlaceBet);
    }

    public void clickYes() {
        Util.clickJS(driver, elYes);
        if (isDisplayedOfElement(elNote))
            clickOk();
    }

    public void clickOk() {
        Util.clickJS(driver, elOK);
    }

    public boolean isLastestBetRunning() {
        return isDisplayedOfElement(elLastestBetRunning);
    }

    public void clickWaitingTab() {
        Util.clickJS(driver, elWaitingTab);
    }

    public void clickRunningTab() {
        Util.clickJS(driver, elRunningTab);
    }

    public boolean isProcessDone() {
        return isDisplayedOfElement(elNoWaitingTitle, Constant.TIME_OUT_LONG);
    }

    public boolean isShowMinBetWarning() {
        return isDisplayedOfElement(elMinBetWarning);
    }

}
