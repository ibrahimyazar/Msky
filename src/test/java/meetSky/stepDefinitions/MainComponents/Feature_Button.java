package meetSky.stepDefinitions.MainComponents;

import io.cucumber.java.en.Then;
import meetSky.pages.MainComponents_Page.MainComponents_page;
import org.junit.Assert;

public class Feature_Button {

    MainComponents_page mainComponentsPage = new MainComponents_page();

    @Then("user should click Features button")
    public void user_should_click_Features_button() {
        mainComponentsPage.featuresButton();
    }

    @Then("User Should see {string} message")
    public void user_Should_see_message(String string) {
        mainComponentsPage.Message(string);
        System.out.println("Message is: " + string);
        Assert.assertEquals("All the Right Features", string);


    }

}
