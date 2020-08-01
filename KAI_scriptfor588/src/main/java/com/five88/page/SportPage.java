package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportPage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Tổng số dư')]")
    WebElement title;

    @FindBy(xpath = "//*[text()='Đẳng cấp Châu Âu']")
    WebElement elEuroStyle;

    @FindBy(xpath = "//*[text()='Phong cách Châu Á']")
    WebElement elAsiaStyle;

    @FindBy(xpath = "//div[@class='group-athethao']//a")
    WebElement elBetAsia;

    @FindBy(xpath = "//div[@class='group-sthethao']//a")
    WebElement elBetEuro;

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/sport.aspx";
        get(url);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(title) && isDisplayedOfElement(elEuroStyle) && isDisplayedOfElement(elAsiaStyle);
    }

    public void clickBetAsia() {
        Util.clickJS(driver, elBetAsia);
    }

    public void clickBetEuro() {
        Util.clickJS(driver, elBetEuro);
    }
}
