package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.Util;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(id = "valuekey")
    WebElement elMainWallet;

    @FindBy(id = "valuesport")
    WebElement elAWallet;

    @FindBy(xpath = "//*[@id='main']//*[@id='xac-nhan'][./img[contains(@src,'right-arrow')]]")
    WebElement elConfirm;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/account.aspx";
        get(url, 5000);
    }

    public void enterAmountOnAWallet(int random) {
        try {
            Util.log("enterAmountOnAWallet");
            elAWallet.clear();
            elAWallet.sendKeys(String.valueOf(random));
            Util.sleep(1000);
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
        }
    }

    public void enterAmountOnMaiWallet(int random) {
        try {
            Util.log("enterAmountOnMaiWallet");
            elMainWallet.clear();
            elMainWallet.sendKeys(String.valueOf(random));
            Util.sleep(1000);
        } catch (ElementNotInteractableException ex) {
            ex.printStackTrace();
        }
    }

    public int getMainWalletAmount() {
        Util.log("getMainWalletAmount");
        String value = elMainWallet.getAttribute("value");
        if (!value.isEmpty())
            return Integer.parseInt(value);
        return 0;
    }

    public int getAWalletAmount() {
        Util.log("getAWalletAmount");
        String value = elAWallet.getAttribute("value");
        if (!value.isEmpty())
            return Integer.parseInt(value);
        return 0;
    }

    public void clickConfirm() {
        Util.log("clickConfirm");
        Util.clickJS(driver, elConfirm);
    }

    public boolean isConfirmDisplayed() {
        return isDisplayedOfElement(elConfirm, Constant.TIME_OUT_LONG / 2);
    }

    public boolean verifyAmmountOnWallet(int mainWallet, int aWallet) {
        int wallet1 = Integer.valueOf(elMainWallet.getAttribute("value"));
        int wallet2 = Integer.valueOf(elAWallet.getAttribute("value"));
        return wallet1 == mainWallet && wallet2 == aWallet;
    }
}
