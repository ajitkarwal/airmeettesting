package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By btn_getStarted = By.xpath("//a[@data-vars-ga-label='get-started-desktop']");

    private By btn_signIn = By.xpath("(//a[contains(.,'Sign in')])[1]");

    public HomePage(WebDriver driver){
        this.driver=driver;

    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public boolean isSignInButtonExists(){
        return driver.findElement(btn_signIn).isDisplayed();
    }

    public boolean isGetStartedButtonExists(){
        return driver.findElement(btn_getStarted).isDisplayed();
    }

}
