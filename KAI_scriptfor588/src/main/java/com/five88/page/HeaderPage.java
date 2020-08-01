package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//*[@id='header-body']//a[text()='Nạp tiền']")
    WebElement deposit;

    @FindBy(xpath = "//a[text()='THOÁT']")
    WebElement elLogout;

    @FindBy(xpath = "//a[contains(@href,'register.aspx')]")
    WebElement register;

    @FindBy(id = "login-username")
    WebElement elUser;

    @FindBy(id = "login-password")
    WebElement elPass;

    @FindBy(xpath = "//button[text()='ĐĂNG NHẬP']")
    WebElement elLogin;

    // @FindBy(xpath = "//a[text()='Nạp tiền']")
    // WebElement elDeposit;

    @FindBy(xpath = "//a[@title='Thể thao']")
    WebElement elSportTab;

    @FindBy(xpath = "//a[@title='Lô đề']")
    WebElement elLodeTab;

    @FindBy(xpath = "//a[@title='Sòng bài']")
    WebElement elCasinoTab;

    @FindBy(xpath = "//a[text()='Number game']")
    WebElement elNumberGame;

    @FindBy(xpath = "//a[text()='Keno']")
    WebElement elKeno;

    @FindBy(xpath = "//a[text()='Trò chơi']")
    WebElement elGame;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(elSportTab)
                && isDisplayedOfElement(elLodeTab)
                && isDisplayedOfElement(elCasinoTab)
                && isDisplayedOfElement(elNumberGame)
                && isDisplayedOfElement(elKeno)
                && isDisplayedOfElement(elGame);
    }

    public boolean isBeforeLogin() {
        return isDisplayedOfElement(elUser) && isDisplayedOfElement(elPass);
    }

    public boolean isAfterLogin() {
        int retry = 0;
        boolean result;
        do {
            result = isDisplayedOfElement(deposit);
            if (!result) refresh();
        } while (!result && ++retry <= 10);

        // if (result) clickClosePopUpIfExit();
        if (result) clickCancelIfNeed();
        return result;
    }

    public void clickLogout() {
        Util.clickJS(driver, elLogout);
    }

    public void clickRegister() {
        Util.clickJS(driver, register);
    }

    public void enterLoginInfo(String user, String pass) {
        elUser.clear();
        elUser.sendKeys(user);
        elPass.clear();
        elPass.sendKeys(pass);
        Util.sleep(1000);
    }

    public void clickLogin() {
        Util.clickJS(driver, elLogin);
        Util.sleep(1000);
    }

    public void clickDeposit() {
        Util.clickJS(driver, deposit);
    }

    public void clickSportTab() {
        Util.clickJS(driver, elSportTab);
    }

    public void clickLodeTab() {
        Util.clickJS(driver, elLodeTab);
        Util.sleep(2000);
    }

    public void clickCasinoTab() {
        Util.clickJS(driver, elCasinoTab);
        Util.sleep(2000);
    }

    public void clickNumberGameTab() {
        Util.clickJS(driver, elNumberGame);
        Util.sleep(5000);
    }

    public void clickKenoTab() {
        Util.clickJS(driver, elKeno);
        Util.sleep(2000);
    }

    public void clickGameTab() {
        Util.clickJS(driver, elGame);
        Util.sleep(2000);
    }
}
