package meetSky.pages.MainComponents_Page;

import meetSky.pages.BasePage;
import meetSky.utiliies.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class MainComponents_page extends BasePage {

    @FindBy (xpath = "//ul[@id='top-menu']//li[@id='menu-item-37']")
    public WebElement FeaturesButton;

    @FindBy(xpath = "//div[@id='et-boc']//div//div//div//section//div//div//div//h1")
    public WebElement FeaturesMessage;







    public void featuresButton(){
        FeaturesButton.click();
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       // Assert.assertEquals();
    }

    public void Message(String message){
       //String message = FeaturesMessage.getText();
        FeaturesMessage.getText();
//        System.out.println("Message is: " + message);
//        Assert.assertEquals("All the Right Features", message);
    }




}
