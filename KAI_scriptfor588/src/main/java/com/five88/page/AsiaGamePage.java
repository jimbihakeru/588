package com.five88.page;

import com.five88.utils.AppEnum;
import com.five88.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AsiaGamePage extends GamePage {

    private static final String tag = "asia";

    public AsiaGamePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRandomGame(AppEnum.GameType type) {
        String xpath = String.format("//div[contains(@class,'%s')]//div[@class='grid-container'][%s]//li", tag, type.toString());
        By by = By.xpath(xpath);
        if (isDisplayedOfElement(by)) {
            List<WebElement> elements = driver.findElements(by);
            int random = Util.randomNumber(0, elements.size() - 1);
            Util.click(driver, elements.get(random));
        }
    }
}
