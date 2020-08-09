package meetSky.stepDefinitions.MainComponents;

import io.cucumber.java.en.Then;
import meetSky.pages.MainComponents_Page.MainComponents_page;

public class Trial_Button {

    MainComponents_page trialPage = new MainComponents_page();

    @Then("user should click TRIAL button")
    public void user_should_click_TRIAL_button() {
        trialPage.click_Trial_Button();
    }

}
