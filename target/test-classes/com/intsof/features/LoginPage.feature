Feature: Login Page Feature
  In order to validate user login
  As a registered user
  I should be able to login to Aires application

  Scenario: Validating Login page title
    Given user is on Aires application login page
    When user gets the title of the page
    Then page title should be "MobilityX 5.6.4 (07-21-2020)"

  Scenario: Validate Forgot password link
    Given user is on Aires application login page
    When user enters UserName "rohit.sharma@intsof.com"
    And user clicks on Next button
    Then forgot password link should be displayed

  @Smoke
  Scenario Outline: Validating Login functionality with valid credential
    Given user is on Aires application login page
    When user enters UserName "<UserName>"
    And user clicks on Next button
    And user enters Password "<Password>"
    And user clicks on Login button
    Then user should be navigated to AriesMobilityX Home Page
    When user logout from the application
    Then user should be navigated to Login page having Username text field

    Examples: 
      | UserName                | Password   |
      | rohit.sharma@intsof.com | relonetng1 |
      | 92265testone            | relonetng  |

  Scenario Outline: Validating Login functionality with invalid credentials
    Given user is on Aires application login page
    When user enters UserName "<UserName>"
    And user clicks on Next button
    And user enters Password "<Password>"
    And user clicks on Login button
    Then user should be navigated to Login page having Username text field
    And validation message "Invalid username or password. Please try again." should be displayed above Sign in section

    Examples: 
      | UserName                | Password        |
      | rohit.sharma@intsof.com | InvalidPassword |
      | Invalid.user@intsof.com | relonetng1      |
      | admin                   | admin           |

  Scenario: Validating Login functionality with Blank Username
    Given user is on Aires application login page
    When user enters UserName ""
    And user clicks on Next button
    Then user should NOT be navigated to Password page having Password text Field
    And validation message "Please enter username" should be displayed inside UserName text field

  Scenario: Validating Login functionality with Username and Blank Passowrd
    Given user is on Aires application login page
    When user enters UserName "rohit.sharma@intsof.com"
    And user clicks on Next button
    And user enters Password ""
    And user clicks on Login button
    Then user should be NOT navigated to Home page or sign in page having Username text Field
    And validation message "Please enter password" should be displayed inside Password text field

  Scenario: Validating Forgot Password functionality with Valid Username
    Given user is on Aires application login page
    When user enters UserName "rohit.sharma@intsof.com"
    And user clicks on Next button
    And user clicks on Forgot password? link
    Then user should be navigated to UserProfileIntermediate Page having security question(s)

  Scenario: Validating Forgot Password functionality with Invalid Username and user clicks on Back to Login button
    Given user is on Aires application login page
    When user enters UserName "vinod.invalid@intsof.com"
    And user clicks on Next button
    And user clicks on Forgot password? link
    Then pop up box having message "Invalid username. Please try again." should be displayed
    When user clicks on Back To Login button
    Then user should be navigated to sign in page having Username text Field
