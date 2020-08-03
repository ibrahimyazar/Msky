package meetSky.pages;

import io.cucumber.java.eo.Se;
import meetSky.utiliies.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdvanceSearchAuto extends BasePage {

    /**
     * Locators
     */
    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement clickAdvanceSearch;
    @FindBy(xpath = "//input[contains(@type,'tel')]")
    public WebElement enterZipCode;
    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement selectCertified;
    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement selectConvertible;
    @FindBy(xpath = "//select[contains(@name,'startYear')]")
    public WebElement selectFrom;
    @FindBy(xpath = "//select[contains(@name,'endYear')]")
    public WebElement selectTo;
    @FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
    public WebElement selectCars;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block ae-button']")
    public WebElement clickSearchButton;
    @FindBy(xpath = "//title[contains(text(),'Certified BMW Convertibles for Sale')]")
    public WebElement userInPage;
    @FindBy (xpath = "(//select[@class=\"form-control\"])[1]")
    public WebElement modelName;
    @FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
    public WebElement onlyBMW;
    @FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
    public WebElement numberOfBMW;

    public void advanceSearchClick(){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        clickAdvanceSearch.click();
    }

    public void zipCode(String zip){
        enterZipCode.sendKeys(zip);
    }

    public void verifyClickCertifiedAndConvertible(String a){

        if(a.equalsIgnoreCase(selectCertified.getText())){
            selectCertified.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            WebElement link = selectConvertible;
            scrollDopwn(link);
            selectConvertible.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectDate(String dateFrom, String dateTo){
        Select selectStartDate = new Select(selectFrom);
        selectStartDate.selectByValue(dateFrom);
        myWait(3000);
        Select selectEndDate= new Select(selectTo);
        selectEndDate.selectByValue(dateTo);
    }

    public void selectCarModel(String car){
        Select selectCar = new Select(selectCars);
        selectCar.selectByValue(car);
    }

    public void clickSearchButton(){
        WebElement link = clickSearchButton;
        scrollDopwn(link);
        clickSearchButton.click();
        myWait(2000);
    }

    public void resultPage(){
        userInPage.getText();
    }

    //Verifying that in result page there is no other car results come.
    public void listingCars(String listingCars){
        //Storing all the results in List and comparing all the results not contains BMW
        List<WebElement> list = Driver.get().findElements(By.xpath("//h2[contains(@data-cmp,'subheading')]"));
        int count = 0;
        int nonBMWCount = 0;
        for (WebElement each : list) {
            if(! each.getText().contains(listingCars)){
            System.out.println("We found non BMW listing "+ nonBMWCount);
        }
         count ++;
        }
         System.out.println("We found "+count+" BMW listing and There is no non BMW listing");


    }

    public void multibleChoices(String model){
    modelName.sendKeys(model);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println("Model Name: " + modelName.getText());
    }

}
