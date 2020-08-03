package meetSky.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;

public class Login_Auto extends BasePage{

    /*
    Locators
     */

    @FindBy(xpath = "//span[contains(@title,'Browse by Make')]")
    public WebElement browseByMake;
    @FindBy(xpath = "//span[contains(@title,'Browse by Style')]")
    public WebElement browseByStyle;
    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advanceSearch;
    @FindBy(xpath = "//button[@id='search']")
    public WebElement searchButton;
    @FindBy(xpath = "//select[@id='makeCodeListPlaceHolder']")
    public WebElement makeElement;
    @FindBy(xpath = "//select[@id='modelCodeListPlaceHolder']")
    public WebElement modelElement;


    public void verification (String expected){

    /*
    Browse Make
    Browse Style
    Advance Search
     */
    if(expected.equals(browseByMake.getText())){
        String actual = browseByMake.getText();
        Assert.assertEquals(expected, actual);
        } else if(expected.equals(browseByStyle.getText())){
        String actual = browseByStyle.getText();
        Assert.assertEquals(expected, actual);
        }else if( expected.equals(advanceSearch.getText())){
         String actual = advanceSearch.getText();
         Assert.assertEquals(expected, actual);
        }else{
        System.out.println("Code is wrong");
        }
    }

    public void searchButton(){
        Assert.assertTrue(searchButton.isEnabled());
    }

    public void verifyMakeAndModel(String make, String model){
        Assert.assertTrue(makeElement.isEnabled());
        Assert.assertTrue(modelElement.isEnabled());
    }



}
