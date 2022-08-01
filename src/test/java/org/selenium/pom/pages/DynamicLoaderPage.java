package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.BasePage;

import java.time.Duration;
import java.util.List;

public class DynamicLoaderPage extends BasePage {
    private final By startButton = By.cssSelector("#start > button");
    private final By firstDynamicElementLink = By.cssSelector("#content > div > a:nth-child(5)");
    private final By loadingBar = By.cssSelector("#loading");
    private final By loadingSuccessText = By.cssSelector("#finish > h4");

    public DynamicLoaderPage(WebDriver driver) {
        super(driver);
    }

    public DynamicLoaderPage clickFirstDynamicElementLink(){
        driver.findElement(firstDynamicElementLink).click();
        return this;
    }

    public DynamicLoaderPage clickSuccessMsg(){
        driver.findElement(loadingSuccessText).click();
        return this;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();
    }

    public DynamicLoaderPage waitUntilLoaderIsInvisible(){
        waitForOverlaysToDisappear(loadingBar);
        return this;
    }
}
