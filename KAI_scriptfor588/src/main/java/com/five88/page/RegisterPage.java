package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.Util;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends HeaderPage {

    @FindBy(xpath = "//div[@id='main']//*[text()='Đăng ký thành viên']")
    WebElement title;

    @FindBy(xpath = "//form[@id='frmRegister']//input[@name='username']")
    WebElement elUser;

    @FindBy(xpath = "//input[@id='password']")
    WebElement elPass;

    @FindBy(xpath = "//form[@id='frmRegister']//input[@name='phone']")
    WebElement elPhone;

    @FindBy(xpath = "//button[text()='Đăng ký']")
    WebElement elRegister;

    @FindBy(id = "username-error")
    WebElement errUser;

    @FindBy(id = "password-error")
    WebElement errPass;

    @FindBy(id = "phone-error")
    WebElement errPhone;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayedOfElement(title);
    }

    public void open() {
        String url = "https://five88.net/register.aspx";
        get(url);
    }

    public void enterRegInfo(String user, String pass, String phone) {
        elUser.clear();
        elUser.sendKeys(user);
        elPass.clear();
        elPass.sendKeys(pass);
        elPhone.clear();
        elPhone.sendKeys(phone);
    }

    public void clickRegister() {
        Util.clickJS(driver, elRegister);
        Util.sleep(1000);
    }

    public boolean isRegisterSuccess() {
        try {
            int retry = 0;
            boolean result;
            do {
                result = elUser.isDisplayed();
            } while (result && ++retry <= Constant.TIME_OUT);

            return !result;
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean verifyAllEmpty() {
        if (errUser.getText().equalsIgnoreCase("Tên đăng nhập chưa nhập.")
                && errPass.getText().equalsIgnoreCase("Bạn chưa khai báo mật khẩu.")
                && errPhone.getText().equalsIgnoreCase("Số điện thoại bạn chưa nhập"))
            return true;

        return false;
    }

    public boolean verifyUserExits() {
        return errUser.getText().equalsIgnoreCase("Tên đăng nhập đã được sử dụng");
    }

    public boolean verifyUserAccented() {
        return errUser.getText().equalsIgnoreCase("Tên đăng nhập không hợp lệ. Chỉ được chứa chữ cái, số hoặc dấu gạch ngang");
    }

    public boolean verifyUserTooShort() {
        return errUser.getText().equalsIgnoreCase("Tên đăng nhập không hợp lệ, phải có ít nhất 6 ký tự và không quá 20 ký tự.");
    }

    public boolean verifyUserTooLong() {
        return errUser.getText().equalsIgnoreCase("Tên đăng nhập không được nhiều hơn 30 ký tự");
    }

    public boolean verifyPassTooShort() {
        return errPass.getText().equalsIgnoreCase("Mật khẩu quá ngắn, phải ít nhất 6 ký tự.");
    }

    public boolean verifyPhoneTooShort() {
        return errPhone.getText().equalsIgnoreCase("Số điện thoại không được ít hơn 10 ký tự");
    }

    public boolean verifyPhoneTooLong() {
        return errPhone.getText().equalsIgnoreCase("Số điện thoại không được nhiều hơn 14 ký tự");
    }
}
