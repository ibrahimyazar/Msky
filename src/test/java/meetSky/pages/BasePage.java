package meetSky.pages;

import meetSky.utiliies.Driver;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    //everything that is in common among pages
    //can go here
    //for example top menu elements don't belong to specific page
    //top menu appears on every single page
    //so we can keep them here

    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.get(), this);  // findby anotationlar icin pagefactory i kullaniyoruz
    }

    public static void clearCookies(){
        // Delete all cookies
        Driver.get().manage().deleteAllCookies();
    }

    public void scrollDopwn(WebElement link){
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println();
        }
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.get();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", link);
    }

    public void myWait(int second){
        try{
            Thread.sleep(second);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
