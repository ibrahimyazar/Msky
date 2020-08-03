 @buttons
  Feature: main component on the main page

    Background: open main page
      Given User in homepage

      @Features_button
    Scenario: User should login MeetSky.net and click Features button
#        Given User in homepage
      Then user should click Features button
        And User Should see "All the Right Features" message