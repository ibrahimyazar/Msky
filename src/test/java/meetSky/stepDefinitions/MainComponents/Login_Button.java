package meetSky.stepDefinitions.MainComponents;

import io.cucumber.java.en.Then;
import meetSky.pages.MainComponents_Page.MainComponents_page;

public class Login_Button {

    MainComponents_page loginButton = new MainComponents_page();

    @Then("user should click Login button")
    public void user_should_click_Login_button() {
       loginButton.click_Login_Button();
    }


}
