package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HeaderPage {

    @FindBy(xpath = "//a[text()='Quên mật khẩu']")
    WebElement elForgetPW;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        String url = "https://five88.net/";
        get(url);
    }

    public boolean isDisplayed() {
        return isBeforeLogin();
    }

    public void clickForgetPW() {
        Util.clickJS(driver, elForgetPW);
    }
}
