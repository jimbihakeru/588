package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LodePage extends BasePage {

    @FindBy(tagName = "iframe")
    WebElement iframe;

    @FindBy(xpath = "//*[text()='kết quả xổ số']")
    WebElement title;

    @FindBy(xpath = "//a[text()='miền bắc']")
    WebElement elMienBacTab;

    @FindBy(xpath = "//a[text()='miền trung']")
    WebElement elMienTrungTab;

    @FindBy(xpath = "//a[text()='miền nam']")
    WebElement elMienNamTab;

    @FindBy(xpath = "//div[@class='danhde-content--right']//select")
    WebElement elDai;

    @FindBy(xpath = "//*[@class='phieudat-form']//div[./label[text()='Tiền đánh trên 1 con (K)']]/input")
    WebElement elStake;

    @FindBy(xpath = "//a[text()='Lô 2 số']")
    WebElement elLo2;

    @FindBy(xpath = "//a[text()='Lô 3 số']")
    WebElement elLo3;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> elNumbers;

    @FindBy(xpath = "//a[./*[text()='Đặt cược']]")
    WebElement elPlaceBet;

    @FindBy(xpath = "//*[text()='Xác nhận đánh?']")
    WebElement elConfirmBet;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement elOK;

    @FindBy(xpath = "//*[text()='Đánh đề thành công']")
    WebElement elBetSuccess;

    @FindBy(xpath = "//*[text()='Không nhận đề trước giờ xổ 10 phút']")
    WebElement elLast10Mins;

    @FindBy(xpath = "//a[text()='miền trung'][contains(@class,'active')]")
    WebElement elMienTrungTabActive;

    @FindBy(xpath = "//a[text()='miền nam'][contains(@class,'active')]")
    WebElement elMienNamTabActive;

    public LodePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/lode.aspx";
        get(url);
    }

    public boolean isDisplayed() {
        driver = DriverUtil.waitiframeReady(driver, iframe, title, Constant.TIME_OUT_LONG);
        if (driver != null) {
            return isDisplayedOfElement(title);
        }
        return false;
    }

    public void clickMienBacTab() {
        Util.clickJS(driver, elMienBacTab);
    }

    public void clickMienTrangTab() {
        do {
            boolean result = isDisplayedOfElement(elMienTrungTabActive);
            if (!result)
                Util.clickJS(driver, elMienTrungTab);
            else {
                break;
            }
        } while (true);
    }

    public void clickMienNamTab() {
        do {
            boolean result = isDisplayedOfElement(elMienNamTabActive);
            if (!result)
                Util.clickJS(driver, elMienNamTab);
            else {
                break;
            }
        } while (true);
    }

    public void chooseRandomDai() {
        Select select = new Select(elDai);
        int min = 1;
        int max = select.getOptions().size() - 1;
        int random = Util.randomNumber(min, max);
        select.selectByIndex(random);
        // Util.sleep(1000);
    }

    public void enterStake() {
        elStake.clear();
        elStake.sendKeys("1");
    }

    public void clickLo2() {
        Util.click(driver, elLo2);
    }

    public void clickLo3() {
        Util.click(driver, elLo3);
    }

    public void clickRandomNumer() {
        int min = 0;
        int max = elNumbers.size() - 1;
        int random = Util.randomNumber(min, max);
        Util.clickJS(driver, elNumbers.get(random));
    }

    public void clickPlaceBet() {
        Util.clickJS(driver, elPlaceBet);
    }

    public boolean isDisplayLast10Mins() {
        return isDisplayedOfElement(elLast10Mins);
    }

    public boolean isConfirmDisplayed() {
        return isDisplayedOfElement(elConfirmBet);
    }

    public void clickOk() {
        Util.clickJS(driver, elOK);
        Util.sleep(2000);
    }

    public boolean isBetSuccess() {
        return isDisplayedOfElement(elBetSuccess);
    }
}
