package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends HeaderPage {

    protected String[] banks = new String[]{"VCB", "ACB", "DongA", "VietinBank", "BIDV", "Sacombank", "Techcombank"};

    @FindBy(xpath = "//a[.//span[text()='Chuyển khoản']]")
    WebElement elTransfer;

    @FindBy(xpath = "//a[.//span[text()='Fivepay']]")
    WebElement elFivePay;

    @FindBy(xpath = "//a[.//span[text()='Thẻ cào điện thoại']]")
    WebElement elCard;

    @FindBy(xpath = "//a[text()='Lịch sử giao dịch']")
    WebElement elHistory;

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(elTransfer) && isDisplayedOfElement(elFivePay) && isDisplayedOfElement(elCard);
    }

    public void clickTabTransfer() {
        Util.clickJS(driver, elTransfer);
    }

    public void clickTabFivePay() {
        Util.clickJS(driver, elFivePay);
    }

    public void clickTabCard() {
        Util.clickJS(driver, elCard);
    }

    public void clickHistoryTrans() {
        Util.clickJS(driver, elHistory);
    }
}
