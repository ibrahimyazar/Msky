package meetSky.pages.MainComponents_Page;

import meetSky.pages.BasePage;
import meetSky.utiliies.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class MainComponents_page extends BasePage {

    @FindBy (xpath = "//ul[@id='top-menu']//li[@id='menu-item-37']")
    public WebElement FeaturesButton;

    @FindBy(xpath = "//div[@id='et-boc']//div//div//div//section//div//div//div//h1")
    public WebElement FeaturesMessage;

    @FindBy(xpath = "//nav//li[2]//a[1]")
    public WebElement pricingButton;

    @FindBy(xpath = "//body//nav//li[3]")
    public WebElement contactButton;

    @FindBy(xpath = "//nav//li[4]//a[1]")
    public WebElement trialButton;

    @FindBy (css = "[href=\"http://app.meetsky.net/index.php/login\"]")
    public WebElement LoginButton;





    public void featuresButton(){
        FeaturesButton.click();
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       // Assert.assertEquals();
    }

    public void Message(String string){
       //String message = FeaturesMessage.getText();
        FeaturesMessage.getText();
//        System.out.println("Message is: " + message);
//        Assert.assertEquals("All the Right Features", message);
    }

    public void clickPricingButton(){
        pricingButton.click();
    }

    public void PageTitle(String string){
      Driver.get().getTitle();
        System.out.println("The title is: " + string);
        String expectedResult = string;
        String actualResult = Driver.get().getTitle();
        Assert.assertEquals(expectedResult, actualResult);
    }

    public void click_ContactButton(){
        contactButton.click();
    }

    public void click_Trial_Button(){
        trialButton.click();
    }

    public void click_Login_Button(){
        LoginButton.click();
    }

}
