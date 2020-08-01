package com.five88.page;

import com.five88.utils.Constant;
import com.five88.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings("Duplicates")
public class NGNormalPage extends NumberGamePage {

    @FindBy(xpath = "//div[contains(@id,'nb-')][2]//div[@class='betGroup-ball']//div[contains(@class,'numberBall')]")
    List<WebElement> elBalls;

    @FindBy(xpath = "//div[contains(@id,'nb-')][2]//span[contains(@class,'bet-time')]")
    WebElement elBetTime;

    @FindBy(xpath = "//div[contains(@id,'nb-')][2]//*[text()='No more bets']")
    WebElement elNoMoreBet;

    public NGNormalPage(WebDriver driver) {
        super(driver);
    }

    public void waitAndClickOdd() throws Exception {
        Util.sleep(Constant.TIME_OUT_LONG / 2 * 1000);
        Util.log("--waitAndClickOdd");
        boolean result;
        int retry = 0;
        do {
            waitReadyToBet();
            clickRandomBall();
            result = isPlaceBetDisplayed();
            if (result) return;
        } while (++retry <= 5);

        throw new Exception("Can not click on Odds");
    }

    public void clickRandomBall() {
        Util.log("clickRandomBall");
        int min = 0;
        int max = elBalls.size() - 1;
        int random = Util.randomNumber(min, max);
        Util.click(driver, elBalls.get(random));
    }

    public void waitReadyToBet() {
        while (true) {
            Util.log("waitReadyToBet");
            String time = elBetTime.getText();
            if (!time.equalsIgnoreCase("No more bets")) {
                time = time.replace("s", "");
                int secode = Integer.parseInt(time);
                if (secode >= 25 && secode <= 55) {
                    break;
                }
            }
            Util.sleep(1000);
        }
    }

    public void waitNoMoreBet() {
        while (true) {
            Util.log("waitNoMoreBet");
            if (isDisplayedOfElement(elNoMoreBet))
                break;
        }
    }
}
