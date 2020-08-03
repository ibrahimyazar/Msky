package meetSky.utiliies;

import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.security.auth.login.Configuration;
import java.net.URL;

public class Driver {

        private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();  // jan 3 20220
    // singleten oldugu icin private kullaniyoruz
        private Driver() {
        // driver objecmi privat olarak yapiyorium mehmet gul bey 27 mart 2 . ders basi
        }

        public static WebDriver get(){
            if(driverPool.get() == null){
                System.out.println("TRYING TO CREATE DRIVER");
                String browserParamfromEnv = System.getProperty("browser");
                String browser = browserParamfromEnv == null ? ConfigurationReader.getProperty("browser") : browserParamfromEnv;
                switch (browser){
                    case "chrome" :
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;

                    case "firefox" :
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "mobile_chrome":
                        try {
                            ChromeOptions chromeOptions = new ChromeOptions();
                            chromeOptions.addArguments("incognito");
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
                            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
                            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
                            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                            driverPool.set(new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        break;

                    case "remote_firefox":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
                            driverPool.set(new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        break;

                    case "remote_chrome":
                        try {
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName(BrowserType.CHROME);
                            driverPool.set(new RemoteWebDriver(new URL("http://172.20.10.3:4444/wd/hub"), desiredCapabilities));
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        break;


                }
            }
            //return corresponded to thread id webdriver object
            return driverPool.get();
        }

    public static void close() {
        driverPool.get().quit();
        driverPool.remove();
    }

}

//