 @buttons
  Feature: main component on the main page

    Background: open main page
      Given User in homepage

      @Features_button
    Scenario: User should login MeetSky.net and click Features button
#        Given User in homepage
      Then user should click Features button
      And User Should see "All the Right Features" message

      @Pricing_button
     Scenario: User should login MeetSky.net and click Pricing button
       Then user should click Pricing button
       And The title should "Pricing - MeetSky"

    @contact_Button
    Scenario: User should login MeetSky.net and click Contact button
      Then user should click Contact button
      And The title should "Contact - MeetSky"

      @trial_Button
    Scenario: User should login MeetSky.net and click TRIAL button
        Then user should click TRIAL button
        And The title should "TRIAL - MeetSky"

     @login_Button
    Scenario: User should login MeetSky.net and click Login button
       Then user should click Login button
       And The title should "Login- MeetSky"


