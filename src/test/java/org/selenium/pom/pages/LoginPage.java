package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.pages.StorePage;

public class LoginPage extends BasePage {
    private final By usernameField = By.cssSelector("#username");
    private final By passwordField = By.cssSelector("#password");
    private final By submitButton = By.cssSelector(".fa.fa-2x.fa-sign-in");
    private final By responseTitle = By.cssSelector("#flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String txt){

        driver.findElement(usernameField).sendKeys(txt);
        return this;
    }

    public LoginPage enterPassword(String txt){
        driver.findElement(passwordField).sendKeys(txt);
        return this;
    }

    public void clickSubmitButton(){

        driver.findElement(submitButton).click();
    }

    public void sendLoginForm(LoginCredentials loginCredentials){
        enterUsername(loginCredentials.getUsername()).
                enterPassword(loginCredentials.getPassword()).
                clickSubmitButton();

    }

    public String getResponseTitle(){
        return driver.findElement(responseTitle).getText();
    }
}