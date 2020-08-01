package com.five88.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FivePayPage extends BasePage {

    @FindBy(xpath = "//*[text()='Thông tin giao dịch:']")
    WebElement title;

    public FivePayPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(title);
    }
}
