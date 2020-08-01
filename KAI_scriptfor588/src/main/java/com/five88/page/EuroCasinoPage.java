package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EuroCasinoPage extends CasinoPage {

    @FindBy(xpath = "//div[@id='tab_vivo']//li[@class='item'][.//a[text()='Baccarat']]//a[text()='Chơi ngay']")
    WebElement elBaccarat;

    @FindBy(xpath = "//div[@id='tab_vivo']//li[@class='item'][.//a[text()='Roulette']]//a[text()='Chơi ngay']")
    WebElement elRoulette;

    @FindBy(xpath = "//div[@id='tab_vivo']//li[@class='item'][.//a[text()='Xì Dách']]//a[text()='Chơi ngay']")
    WebElement elBlackJack;

    public EuroCasinoPage(WebDriver driver) {
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

}
