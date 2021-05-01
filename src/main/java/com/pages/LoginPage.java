package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By txt_emailId = By.id("email");
    //private By txt_emailId = By.xpath("//input[@id='email']");
    private By btn_continue = By.id("Continue-with-email");
    private By txt_password = By.xpath("//input[@id='password']");
    private By btn_logIn = By.xpath("(//button[contains(.,'Login')])[2]");
    private By btn_privacyPolicy = By.linkText("Privacy Policy");
    private By btn_forgotPassword = By.linkText("Forgot password?");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLogInPageTitle(){
        return driver.getTitle();
    }

    public boolean isPrivacyPolicyLinkExists(){
        return driver.findElement(btn_privacyPolicy).isDisplayed();
    }

    // this username and password (arguments) is coming from feature file
    public void enterUserName(String username) {
        driver.findElement(txt_emailId).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickContinueButton(){
        driver.findElement(btn_continue).click();
    }
    public void clickLoginButton(){
        driver.findElement(btn_logIn).click();
    }

    public Boolean isForgotPasswordLinkExists(){
       return driver.findElement(btn_forgotPassword).isDisplayed();
    }
}
