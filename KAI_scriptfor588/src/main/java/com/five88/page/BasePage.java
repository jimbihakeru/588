package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import com.five88.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    @FindBy(id = "swal2-content")
    WebElement elError;

    @FindBy(xpath = "//div[@class='swal2-content']//*[contains(text(),'Tạo phiếu nạp thành công')]")
    WebElement elSuccessMsg;

    @FindBy(xpath = "//button[text()='OK']")
    WebElement elOK;

    @FindBy(xpath = "//button[@class='close']")
    WebElement elClosePopUp;

    @FindBy(id = "onesignal-popover-cancel-button")
    WebElement elCancel;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedOfElement(WebElement element) {
        return DriverUtil.wait(driver, element, Constant.TIME_OUT) != null;
    }

    public boolean isDisplayedOfElement(WebElement element, int secode) {
        return DriverUtil.wait(driver, element, secode) != null;
    }

    public boolean isDisplayedOfElement(By by) {
        return DriverUtil.wait(driver, by, Constant.TIME_OUT) != null;
    }

    public boolean verifyUserNotFound() {
        String error = elError.getText().trim();
        return error.contains("Tên đăng nhập hoặc mật khẩu không đúng") && error.contains("Quên mật khẩu");
    }

    public boolean verifyUserIncorrectUserPass() {
        String error = elError.getText().trim();
        return error.contains("Tên đăng nhập hoặc mật khẩu không đúng") && error.contains("Quên mật khẩu");
    }

    public boolean verifyRequirePass() {
        String error = elError.getText().trim();
        return error.contains("Yêu cầu nhập mật khẩu đăng nhập");
    }

    public boolean verifyRequireUser() {
        String error = elError.getText().trim();
        return error.contains("Yêu cầu nhập tên đăng nhập");
    }

    public boolean verifyMinDepositAmount() {
        String error = elError.getText().trim();
        return error.contains("Số tiền tối thiểu là 50 KDV (50.000 VNĐ)");
    }

    public boolean verify4timesWrong() {
        String error = elError.getText().trim();
        return error.contains("Bạn đã nạp sai 4 lần");
    }

    public boolean verifySystemProcessCheckHistory() {
        String error = elError.getText().trim();
        return error.contains("Hệ thống đang xử lý vui lòng kiểm tra Lịch sử giao dịch");
    }

    public boolean verifyConfirmCard() {
        String error = elError.getText().trim();
        return error.contains("Vui lòng kiểm tra kỹ thông tin thẻ, nếu sai thông tin Five88 không chịu trách nhiệm");
    }

    public boolean verifyConfirmAmountNotEnough() {
        String error = elError.getText().trim();
        return error.contains("Số tiền không đủ.");
    }

    public void sendKeyJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "';", element);
    }

    public boolean isCreateTicketSuccess() {
        return isDisplayedOfElement(elSuccessMsg);
    }

    public void clickOKPopUP() {
        Util.click(driver, elOK);
    }

    public void refresh() {
        Util.log("refresh");
        driver.navigate().refresh();
        Util.sleep(1000);
    }

    public void clickClosePopUpIfExit() {
        if (isDisplayedOfElement(elClosePopUp))
            Util.click(driver, elClosePopUp);
    }

    public void get(String url) {
        driver.get(url);
        Util.sleep(1000);
    }

    public void get(String url, int mil) {
        driver.get(url);
        Util.sleep(mil);
    }

    public void clickCancelIfNeed() {
        if (isDisplayedOfElement(elCancel, Constant.TIME_OUT))
            Util.click(driver, elCancel);
    }
}
