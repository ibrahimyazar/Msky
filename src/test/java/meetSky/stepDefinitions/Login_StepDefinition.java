package meetSky.stepDefinitions;

import io.cucumber.java.en.*;
import meetSky.pages.Login_Page;
import meetSky.utiliies.ConfigurationReader;
import meetSky.utiliies.Driver;
import org.junit.Assert;

import javax.swing.*;

public class Login_StepDefinition {

    Login_Page loginPage = new Login_Page();

    @Given("User in homepage")
    public void user_in_homepage() {
        Driver.get().get(ConfigurationReader.getProperty("url"));

    }

    @Then("user click the login button")
    public void user_click_the_login_button() {
    loginPage.clickLogin();
    }

    @Then("user enter the valid credentials")
    public void user_enter_the_valid_credentials() {
      String username =  ConfigurationReader.getProperty("userName");
      String password = ConfigurationReader.getProperty("password");
    loginPage.login(username, password);
    }

    @Then("Verify that title is {string}")
    public void verify_that_title_is(String string) {
        String actualResult =  Driver.get().getTitle();
        System.out.println(actualResult);
        String expectedResult = string;
        Assert.assertEquals(actualResult, expectedResult);
    }

    // login with data table
    @Then("user enter {string} and {string}")
    public void user_enter_and(String string, String string2) {
        System.out.println("Login with " + string + " user name " + string2 + " password." );
        loginPage.login(string, string2);

    }

    @Then("user enter the invalid credentials")
    public void user_enter_the_invalid_credentials() {
       String invalidUserName = ConfigurationReader.getProperty("invalidUserName");
       String invalidPassword = ConfigurationReader.getProperty("invalidPassword");
       loginPage.login(invalidUserName, invalidPassword);
    }

    @Then("Verify that warning message is {string}")
    public void verify_that_warning_message_is(String string) {
        String actualResult = loginPage.warningMessage.getText();
        String expectedResult = string;
        Assert.assertEquals(actualResult, expectedResult);
    }




}
