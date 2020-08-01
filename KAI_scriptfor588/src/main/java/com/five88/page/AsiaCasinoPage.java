package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsiaCasinoPage extends CasinoPage {

    @FindBy(xpath = "//div[@id='tab_ho']//li[@class='item'][.//a[text()='Baccarat']]//a[text()='Chơi ngay']")
    WebElement elBaccarat;

    @FindBy(xpath = "//div[@id='tab_ho']//li[@class='item'][.//a[text()='Roulette']]//a[text()='Chơi ngay']")
    WebElement elRoulette;

    @FindBy(xpath = "//div[@id='tab_ho']//li[@class='item'][.//a[text()='Xì Dách']]//a[text()='Chơi ngay']")
    WebElement elBlackJack;

    @FindBy(xpath = "//div[@id='tab_ho']//li[@class='item'][.//a[text()='Tài xỉu']]//a[text()='Chơi ngay']")
    WebElement elOverUnder;

    @FindBy(xpath = "//div[@id='tab_ho']//li[@class='item'][.//a[text()='Rồng Hổ']]//a[text()='Chơi ngay']")
    WebElement elDragonTiger;

    @FindBy(xpath = "//div[@id='tab_ho']//li[@class='item'][.//a[text()='Baccarat không hoa hồng']]//a[text()='Chơi ngay']")
    WebElement elBaccaratNoComm;

    public AsiaCasinoPage(WebDriver driver) {
        super(driver);
    }

    public void clickBaccarat() {
        Util.clickJS(driver, elBaccarat);
    }

    public void clickRoulette() {
        Util.clickJS(driver, elRoulette);
    }

    public void clickBlackJack() {
        Util.clickJS(driver, elBlackJack);
    }

    public void clickOverUnder() {
        Util.clickJS(driver, elOverUnder);
    }

    public void clickDragonTiger() {
        Util.clickJS(driver, elDragonTiger);
    }

    public void clickBaccaratNoComm() {
        Util.clickJS(driver, elBaccaratNoComm);
    }

}
