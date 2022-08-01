package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void load(String endPoint){
        driver.get("http://the-internet.herokuapp.com" + endPoint);
    }

    public void waitForOverlaysToDisappear(By overlay) {
        List<WebElement> loaders = driver.findElements(overlay);
        System.out.println("LOADERS size=" + loaders.size());
        if(loaders.size() > 0){
            // explicit wait
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                    ExpectedConditions.invisibilityOfAllElements(loaders)
            );
            System.out.println("OVERLAYS invisible");
        } else {
            System.out.println("OVERLAYS not found");
        }
    }

}
