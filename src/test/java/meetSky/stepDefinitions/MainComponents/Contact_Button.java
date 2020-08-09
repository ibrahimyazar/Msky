package meetSky.stepDefinitions.MainComponents;

import io.cucumber.java.en.Then;
import meetSky.pages.MainComponents_Page.MainComponents_page;
import meetSky.utiliies.Utills;

public class Contact_Button {

    MainComponents_page MainComponents = new MainComponents_page();

    @Then("user should click Contact button")
    public void user_should_click_Contact_button() {

        MainComponents.click_ContactButton();
        Utills.wait(1);


    }
//    @Then("The title should {string}")
//    public void the_title_should(String string) {
//        MainComponents.PageTitle(string);
//        //  System.out.println(MainComponents.PricingPageTitle());
//        Utills.wait(1);
//        System.out.println("The title is: " + string);
//        Assert.assertEquals("https://meetsky.net/contact/", string);
//    }


}
