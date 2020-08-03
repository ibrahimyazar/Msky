package meetSky.stepDefinitions;

import io.cucumber.java.en.*;
import meetSky.pages.AdvanceSearchAuto;
import meetSky.pages.BasePage;
import meetSky.pages.Login_Auto;
import meetSky.utiliies.Driver;
import org.junit.Assert;

public class Auto_StepDefinitions {

    Login_Auto loginauto = new Login_Auto();
    AdvanceSearchAuto advanceSearchAuto = new AdvanceSearchAuto();

    @Given("User is in landing page")
    public void user_is_in_landing_page() {
        System.out.println("Landing page");
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "New Cars, Used Cars - Find Cars for Sale and Reviews at Autotrader";
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("Verify that {string} are present")
    public void verify_that_are_present(String string) {
    loginauto.verification(string);


    }

    @Then("verify that search button is present.")
    public void verify_that_search_button_is_present() {
    loginauto.searchButton();
    }

    @Then("verify that {string} and {string} is visible")
    public void verify_that_and_is_visible(String make , String model) {
    loginauto.verifyMakeAndModel(make, model);
    }

    @Given("User click Advance Search link on the home page")
    public void user_click_Advance_Search_link_on_the_home_page() {
    BasePage.clearCookies();
    advanceSearchAuto.advanceSearchClick();
    }

    @Then("User enter {string} in the zip code text box")
    public void user_enter_in_the_zip_code_text_box(String zipcode) {
    advanceSearchAuto.zipCode(zipcode);
    }

    @Then("User select {string} check box under {string}")
    public void user_select_check_box_under(String string, String string2) {
    advanceSearchAuto.verifyClickCertifiedAndConvertible(string);
    advanceSearchAuto.verifyClickCertifiedAndConvertible(string2);
    }

    @Then("user update Year {string} to {string}")
    public void user_update_Year_to(String dateFrom, String dateTo) {
    advanceSearchAuto.selectDate(dateFrom, dateTo);
    }

    @Then("user select {string} car from Make,Model and Trim section")
    public void user_select_car_from_Make_Model_and_Trim_section(String carModel) {
    advanceSearchAuto.selectCarModel(carModel);
    }

    @Then("User clicks Search button")
    public void user_clicks_Search_button() {
    advanceSearchAuto.clickSearchButton();
    }

    @Then("User verifies that he is in result page")
    public void user_verifies_that_he_is_in_result_page() {
    String actulaResult = Driver.get().getTitle();
    String expectedResult = "Certified BMW Convertibles for Sale in Alpharetta, GA 30004 - Autotrader";
        System.out.println("Title is: " + actulaResult);
    Assert.assertEquals(expectedResult, actulaResult);
    }

    @Then("User verifies that he sees only {string} cars in listing")
    public void user_verifies_that_he_sees_only_cars_in_listing(String car) {
    advanceSearchAuto.listingCars(car);
    }

    @Then("Display in console, the number of cars listed in result page")
    public void display_in_console_the_number_of_cars_listed_in_result_page() {

    }

    @Given("choose make as {string}")
    public void choose_make_as(String string) {
    advanceSearchAuto.multibleChoices(string);
        System.out.println(string);
    }



}
