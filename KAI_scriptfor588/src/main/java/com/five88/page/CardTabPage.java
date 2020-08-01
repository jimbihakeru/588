package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CardTabPage extends DepositPage {

    @FindBy(id = "to_telcom_code")
    WebElement elProvider;

    @FindBy(id = "card_amount")
    WebElement elCard;

    @FindBy(xpath = "//input[@name='card_serial']")
    WebElement elSerial;

    @FindBy(xpath = "//input[@name='card_code']")
    WebElement elPin;

    @FindBy(xpath = "//*[@id='frmDepositcard']//button[text()='Nạp tiền']")
    WebElement elDeposit;

    public CardTabPage(WebDriver driver) {
        super(driver);
    }

    public void chooseRandomProvider() {
        Select select = new Select(elProvider);
        int min = 1;
        int max = select.getOptions().size();
        select.selectByIndex(Util.randomNumber(min, max - 1));
        Util.sleep(1000);
    }

    public void chooseRandomCard() {
        Select select = new Select(elCard);
        int min = 1;
        int max = select.getOptions().size();
        select.selectByIndex(Util.randomNumber(min, max - 1));
    }

    public void enterRandomSerial() {
        sendKeyJS(elSerial, Util.randomNumber(13));
    }

    public void enterRandomPin() {
        sendKeyJS(elPin, Util.randomNumber(10));
    }

    public void clickDeposit() {
        Util.clickJS(driver, elDeposit);
    }
}
