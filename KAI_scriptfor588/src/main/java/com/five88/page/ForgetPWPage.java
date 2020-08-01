package com.five88.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPWPage extends HeaderPage {

    @FindBy(xpath = "//*[text()='Quên mật khẩu']")
    WebElement title;

    public ForgetPWPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(title);
    }
}
