package AppHooks;

import com.factory.DriverFactory;
import com.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;

    Properties prop;

    @Before(order = 0) // in @Before annotation execution order is 0,1,2..
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.setProp(); // entire property is stored in this prop.

    }

    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser"); // using prop we can store the value of  browser key
        driverFactory = new DriverFactory();
        driver = driverFactory.setDriver(browserName); // and that value is passed to driverFactory. it also returns driver
    }

    @After(order = 0) //in @After annotation execution order is 2,1,0.. It means order =0 will execute i the last
    public void quitBrowser(){

        driver.quit();
    }

    //to take screenshot when the test fails befor quiting the browser. hence the order = 1
    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            //take screenshot
            String screenshotName = scenario.getName().replaceAll("","");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png", screenshotName);
        }
    }


}
