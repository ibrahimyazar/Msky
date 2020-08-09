package meetSky.stepDefinitions.MainComponents;

import io.cucumber.java.en.Then;
import meetSky.pages.MainComponents_Page.MainComponents_page;
import meetSky.utiliies.Utills;
import org.junit.Assert;

public class Pricicng_Button {

    MainComponents_page MainComponents = new MainComponents_page();

    @Then("user should click Pricing button")
    public void user_should_click_Pricing_button() {
        MainComponents.clickPricingButton();
    }

    @Then("The title should {string}")
    public void the_title_should(String string) {
        MainComponents.PageTitle(string);
     //  System.out.println(MainComponents.PricingPageTitle());
        Utills.wait(3);
//        System.out.println("The title is: " + string);
//        Assert.assertEquals("https://meetsky.net/pricing/", string);
    }

}
