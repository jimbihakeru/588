package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamePage extends BasePage {

    @FindBy(xpath = "//a[text()='Châu Á']")
    WebElement elAsiaTab;

    @FindBy(xpath = "//a[text()='Châu Âu']")
    WebElement elEuroTab;

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(elAsiaTab) || isDisplayedOfElement(elEuroTab);
    }

    public void clickAsiaTab() {
        Util.clickJS(driver, elAsiaTab);
    }

    public void clickEuroTab() {
        Util.clickJS(driver, elEuroTab);
    }
}
