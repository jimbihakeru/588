package com.five88.page;

import com.five88.utils.AppEnum;
import com.five88.utils.Constant;
import com.five88.utils.DriverUtil;
import com.five88.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class KenoPage extends BasePage {

    @FindBy(xpath = "//*[@id='main']//iframe")
    WebElement iframe;

    @FindBy(xpath = "//*[text()='Số tiền hiện tại:']")
    WebElement title;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement elStake;

    @FindBy(xpath = "//button[text()='Cược']")
    WebElement elPlaceBet;

    @FindBy(xpath = "//*[text()='Đặt cược thành công!']")
    WebElement elBetSuccess;

    @FindBy(xpath = "//div[@class='popper']")
    WebElement elPopUpBet;

    @FindBy(xpath = "//span[contains(@class,'oddsValue')]")
    WebElement elOdds;

    public KenoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() throws Exception {
        driver = DriverUtil.waitiframeReady(driver, iframe, elOdds, Constant.TIME_OUT_LONG * 2);
        if (driver != null) {
            return isDisplayedOfElement(elOdds);
        } else {
            Util.log("isDisplayed: false");
            throw new Exception("Can not switch into iframe --> Time out");
        }
    }

    public void scrollToType(AppEnum.KenoType type) {
        Util.log("scrollToType");
        String path = String.format("//*[@id='%s']//div[@class='game-name']", type.toString());
        By by = By.xpath(path);
        int retry = 0;
        while (retry <= 10) {
            if (isDisplayedOfElement(by)) {
                WebElement element = driver.findElement(by);
                Util.scrollToElement(driver, element);
                break;
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public void waitReadyToBet(AppEnum.KenoType type) {
        /*String path = String.format("//div[@id='%s']//span[contains(@class,'countdown')]", type.toString());
        String xpath = String.format("//div[@id='%s']/div[@class='game-container']", type.toString());
        By by = By.xpath(xpath);
        while (true) {
            if (isDisplayedOfElement(by)) {
                WebElement elCount = driver.findElement(By.xpath(path));
                String[] text = elCount.getText().split(":");
                if (text.length == 2 && Integer.parseInt(text[1]) > 15)
                    break;
            }
            Util.sleep(1000);
        }*/

        while (true) {
            try {
                Util.log("waitReadyToBet");
                String xpath = String.format("//div[@id='%s']//span[contains(@class,'countdown')]", type.toString());
                By by = By.xpath(xpath);
                String text = driver.findElement(by).getText();
                text = text.replace("0", "").replace(":", "").trim();
                if (!text.isEmpty())
                    if (Integer.parseInt(text) > 15)
                        break;
                Util.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean clickRandomOdd(AppEnum.KenoType type) {
        int retry = 0;
        int max = Constant.TIME_OUT;
        while (++retry <= max) {
            Util.log("clickRandomOdd");
            String xpath = String.format("//div[@id='%s']//span[@class='oddsName']", type.toString());
            By by = By.xpath(xpath);
            List<WebElement> elements = driver.findElements(by);
            int random = Util.randomNumber(0, elements.size() - 1);
            Util.clickJS(driver, elements.get(random));
            if (isDisplayPopUpBet())
                return true;
            Util.sleep(1000);
        }
        return false;
    }

    public boolean isDisplayPopUpBet() {
        return isDisplayedOfElement(elPopUpBet);
    }

    public void clickminBetAndPlaceBet(AppEnum.KenoType type) throws Exception {
        int retry = 0;
        int max = Constant.TIME_OUT;
        while (++retry <= max) {
            clickMinBet(type);
            if (isDisplayedOfElement(elPlaceBet)) {
                clickPlaceBet();
                return;
            }
        }
        throw new Exception("Click +10 does not work");
    }

    public void clickMinBet(AppEnum.KenoType type) {
        Util.log("clickMinBet");
        String xpath = String.format("//div[@id='%s']//a[text()='+10']", type.toString());
        By by = By.xpath(xpath);
        WebElement element = driver.findElement(by);
        Util.clickJS(driver, element);
    }

    public void enterStake() {
        elStake.clear();
        elStake.sendKeys(String.valueOf(10));
    }

    public void clickPlaceBet() {
        Util.log("clickPlaceBet");
        Util.clickJS(driver, elPlaceBet);
    }

    public boolean isBetSuccess() {
        return isDisplayedOfElement(elBetSuccess, Constant.TIME_OUT_LONG);
    }

    public void waitToStopStatus(AppEnum.KenoType type) {
        while (true) {
            Util.log("waitToStopStatus");
            try {
                String xpath = String.format("//div[@id='%s']//span[contains(@class,'countdown')]", type.toString());
                By by = By.xpath(xpath);
                String text = driver.findElement(by).getText();
                if (text.equalsIgnoreCase("00:00"))
                    break;
                Util.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isStopBetting(AppEnum.KenoType type) {
        String xpath = String.format("//div[@id='%s']/div[contains(@class,'game-container')][contains(@class,'stop-betting')]", type.toString());
        By by = By.xpath(xpath);
        return isDisplayedOfElement(by);
    }
}
