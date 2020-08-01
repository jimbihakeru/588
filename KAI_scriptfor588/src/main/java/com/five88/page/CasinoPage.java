package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasinoPage extends BasePage {

    @FindBy(xpath = "//*[text()='Sòng bài Châu Âu' or text()='Sòng bài Châu Á']")
    WebElement title;

    @FindBy(xpath = "//a[text()='Sòng bài Châu Âu']")
    WebElement elEuroCasino;

    @FindBy(xpath = "//a[text()='Sòng bài Châu Á']")
    WebElement elAsiaCasino;

    public CasinoPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/casino.aspx";
        get(url);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(title);
    }

    public void clickEuroCasino() {
        Util.click(driver, elEuroCasino);
    }

    public void clickAisaCasino() {
        Util.click(driver, elAsiaCasino);
    }
}
