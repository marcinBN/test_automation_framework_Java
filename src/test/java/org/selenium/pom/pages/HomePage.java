package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By loginFormLink = By.cssSelector("#content > ul > li:nth-child(21) > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By prepareSelectorForGivenLinkText(String linkText){
        return By.xpath(String.format("//a[contains(text(),'%s')]", linkText));
    }

    public LoginPage clickLoginMenuLink(){
        driver.findElement(prepareSelectorForGivenLinkText("Form Authentication")).click();
        return new LoginPage(driver);
    }

    public DynamicLoaderPage clickDynamicLoadingLink(){
        driver.findElement(prepareSelectorForGivenLinkText("Dynamic Loading")).click();
        return new DynamicLoaderPage(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }
}
