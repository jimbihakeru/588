package com.five88.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HistoryTransactionPage extends BasePage {

    @FindBy(xpath = "//h2[text()='Lịch sử giao dịch']")
    WebElement title;

    @FindBy(xpath = "//tr[2]//*[contains(text(),'Chờ xử lý') or contains(text(),'Đang xử lý')]")
    WebElement elLastestTransWaiting;

    public HistoryTransactionPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/history/lsgd.aspx";
        get(url);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(title);
    }

    public boolean isLastestTransWaiting() {
        return elLastestTransWaiting.isDisplayed();
    }

}
