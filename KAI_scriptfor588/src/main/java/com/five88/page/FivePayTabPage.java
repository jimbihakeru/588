package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FivePayTabPage extends DepositPage {

    @FindBy(id = "dataFivepay")
    WebElement elSelectBank;

    @FindBy(xpath = "//*[@id='frmFivepayDeposit']//input[@name='amount']")
    WebElement elMoney;

    @FindBy(xpath = "//*[@id='frmFivepayDeposit']//*[@name='package_id']")
    WebElement elPackage;

    @FindBy(xpath = "//*[@id='frmFivepayDeposit']//button[text()='Nạp tiền']")
    WebElement elDeposit;

    public FivePayTabPage(WebDriver driver) {
        super(driver);
    }

    public void chooseRandomBank() {
        int min = 0;
        int max = banks.length - 1;
        int index = Util.randomNumber(min, max);

        Select select = new Select(elSelectBank);
        select.selectByIndex(index + 1);
        Util.sleep(1000);
    }

    public void choosePackageIfExist() {
        if (isDisplayedOfElement(elPackage)) {
            int min = 0;
            int max = 1;
            int index = Util.randomNumber(min, max);

            Select select = new Select(elPackage);
            select.selectByIndex(index + 1);
        }
    }

    public void enterValidAmout() {
        int min = 50;
        int max = 100;
        int random = Util.randomNumber(min, max);
        elMoney.clear();
        elMoney.sendKeys(String.valueOf(random));
        // sendKeyJS(elMoney, String.valueOf(random));
    }

    public void enterInvalidAmout() {
        int min = 1;
        int max = 49;
        int random = Util.randomNumber(min, max);
        elMoney.clear();
        elMoney.sendKeys(String.valueOf(random));
        // sendKeyJS(elMoney, String.valueOf(random));
    }

    public void clickDeposit() {
        Util.clickJS(driver, elDeposit);
    }
}
