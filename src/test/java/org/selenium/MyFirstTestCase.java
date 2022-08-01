package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.pages.DynamicLoaderPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.LoginPage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {
    @Test
    public void validLoginTest() throws IOException {

// One way of defining test data, overloading constructor
 //       LoginCredentials loginCredentials = new LoginCredentials();
  //      loginCredentials.setUsername("tomsmith");
      //  loginCredentials.setPassword("SuperSecretPassword!");

        // Other way of defining test data, overloading constructor
     //   LoginCredentials loginCredentials = new LoginCredentials("tomsmith", "SuperSecretPassword!");

        // Other way, json
        LoginCredentials loginCredentials = JacksonUtils.deserializeJson("myLoginCredentials.json", LoginCredentials.class);

        HomePage homePage = new HomePage(driver).
                load();

        LoginPage loginPage = homePage.clickLoginMenuLink();

        loginPage.
                sendLoginForm(loginCredentials);

        System.out.println(loginPage.getResponseTitle());
        Assert.assertEquals(loginPage.getResponseTitle(),"You logged into a secure area!");



    }


    @Test
    public void dynamicLoaderTest() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver).
                load();

        DynamicLoaderPage dynamicLoaderPage = homePage.clickDynamicLoadingLink();
        dynamicLoaderPage.
                clickFirstDynamicElementLink().
                clickStartButton();
        dynamicLoaderPage.waitUntilLoaderIsInvisible();
        dynamicLoaderPage.clickSuccessMsg();
        Thread.sleep(5000);

        System.out.println(loginPage.getResponseTitle());
        Assert.assertEquals(loginPage.getResponseTitle(),"You logged into a secure area!");



    }

}



