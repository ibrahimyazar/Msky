@smaoke
Feature: Login Functionality

        As a user I can login the application

  @Login
  Scenario: login with valid credentials
    Given User in homepage
    Then user click the login button
    Then user enter the valid credentials
    And Verify that title is "Files - Trycloud"

  @login_with_data_table
  Scenario Outline: login with data table
    Given User in homepage
    Then user click the login button
    Then user enter "<username>" and "<password>"
    And Verify that title is "Files - Trycloud"
    Examples:
    | username | password    |
    | User1    | Userpass123 |
    | User3    | Userpass123 |
    | User11   | Userpass123 |
    | User33   | Userpass123 |
    | User111  | Userpass123 |
    | User300  | Userpass123 |
    | User210  | Userpass123 |
    | User233  | Userpass123 |

    @login_With_Invalid_Data
    Scenario: login with invalid credentials
      Given User in homepage
      Then user click the login button
      Then user enter the invalid credentials
      And Verify that warning message is "Wrong password."