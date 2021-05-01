package com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public WebDriver driver;

    // threadLocal will provide the same copy of WebDriver driver to each thread simultaneously
    //ThreadLocal will have one set method and one get method
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();


    //we are giving this method the browser name using browser property
    // and it will initialise the value of the WebDriver on the basis
    // of browser property
    // OR this method is used to initialize the threadlocal driver on the basis of browser name

    public WebDriver setDriver(String browserName) {

        System.out.println("Browser Value is : " + browserName);

        if (browserName.equals("chrome")) {

            //checks for the latest version of the specified WebDriver binary.
            // If the binaries are not present on the machine, then it will download the WebDriver binaries.
            // Next, it instantiates the Selenium WebDriver instance with the ChromeDriver.
            WebDriverManager.chromedriver().setup();

            //the object of the chrome driver will be created and will be set with thread local driver
            threadLocalDriver.set(new ChromeDriver());

        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            threadLocalDriver.set(new FirefoxDriver()); //set method of threadloacl webdriver
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            threadLocalDriver.set(new EdgeDriver());
        } else {
            System.out.println("Your browser is not set with WebDriver: "+browserName);
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {

        return threadLocalDriver.get(); // get method of threadloacl webdriver
    }

}
