package meetSky.stepDefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import meetSky.utiliies.ConfigurationReader;
import meetSky.utiliies.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hook {
    private static Logger logger = Logger.getLogger(Hook.class);
    @Before
    public void setup(){
        logger.info ("================================");
       logger.info("Test setup is done!");
        String browser = ConfigurationReader.getProperty("browser");
        if(!browser.contains("remote") && !browser.contains("mobile")) {
             Driver.get().manage().window().maximize();
        }
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.getProperty("urlMeetsky"));
    }

    @After
    public void teardown(Scenario scenario){
        //if test failed - do this
        if(scenario.isFailed()){
            System.out.println("Test failed!");
            byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }else {
            System.out.println("Cleanup!");
            System.out.println("Test completed!");
        }
        //after every test, we gonna close browser
        Driver.close();

    }
}
