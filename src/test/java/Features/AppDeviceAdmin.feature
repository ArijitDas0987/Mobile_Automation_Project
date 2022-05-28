


@apps
Feature: Device admin feature

  
  Scenario: Here user is able to access all the admin controlls
    Given User is inside the application and clicks on App option
    And User clicks on the Device Admin option and clicks on general
    When user enables the admin rights
    Then Validate the outcomes

