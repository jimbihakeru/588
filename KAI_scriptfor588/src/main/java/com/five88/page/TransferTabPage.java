package com.five88.page;

import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("Duplicates")
public class TransferTabPage extends DepositPage {

    @FindBy(id = "bank_code_option")
    WebElement elBank;

    @FindBy(xpath = "//*[@id='radio-method']//li[.//*[text()='Internet Banking']]")
    WebElement elInternetBanking;

    @FindBy(xpath = "//*[@id='radio-method']//li[.//*[text()='ATM']]")
    WebElement elATM;

    @FindBy(xpath = "//*[@id='radio-method']//li[.//*[text()='Quầy Giao Dịch']]")
    WebElement elTransactionCounters;

    @FindBy(xpath = "//*[@id='frmDeposit']//button[text()='Nạp tiền']")
    WebElement elDeposit;

    @FindBy(id = "amount-money")
    WebElement elMoney;

    @FindBy(id = "from_bank_name")
    WebElement elFromBankName;

    @FindBy(id = "bank_trancode")
    WebElement elBankTransCode;

    @FindBy(xpath = "//*[@id='frmDeposit']//*[@name='package_id']")
    WebElement elPackage;

    public TransferTabPage(WebDriver driver) {
        super(driver);
    }

    public void chooseRandomBank() {
        int min = 0;
        int max = banks.length - 1;
        int index = Util.randomNumber(min, max);

        Select select = new Select(elBank);
        select.selectByIndex(index + 1);
        Util.sleep(3000);
    }

    public void clickInternetBanking() {
        Util.click(driver, elInternetBanking);
    }

    public void clickTransCounter() {
        Util.click(driver, elTransactionCounters);
    }

    public void clickATM() {
        Util.click(driver, elATM);
    }

    public void enterValidAmount() {
        int min = 50;
        int max = 60;
        int random = Util.randomNumber(min, max);
        elMoney.clear();
        elMoney.sendKeys(String.format("%s", random));
    }

    public void enterInvalidAmount() {
        int min = 1;
        int max = 49;
        int random = Util.randomNumber(min, max);
        elMoney.clear();
        elMoney.sendKeys(String.format("%s", random));
    }

    public void enterSenderNameIfExist() {
        if (isDisplayedOfElement(elFromBankName)) {
            String text = String.format("%s %s %s",
                    Util.generateRandomeString(5),
                    Util.generateRandomeString(5),
                    Util.generateRandomeString(5));
            elFromBankName.clear();
            elFromBankName.sendKeys(text);
        }
    }

    public void enterTransCodeIfExist() {
        if (isDisplayedOfElement(elBankTransCode)) {
            String text = String.format("%s %s %s",
                    Util.generateRandomeString(5),
                    Util.generateRandomeString(5),
                    Util.generateRandomeString(5));

            elBankTransCode.clear();
            elBankTransCode.sendKeys(text);
        }
    }

    public void choosePackingIfExist() {
        if (isDisplayedOfElement(elPackage)) {
            Select select = new Select(elPackage);
            int index = Util.randomNumber(1, 2);
            select.selectByIndex(index);
        }
    }

    public void clickDeposit() {
        Util.clickJS(driver, elDeposit);
    }
}
