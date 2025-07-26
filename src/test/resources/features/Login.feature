Feature:Login related scenarios

  Background:

    #Given user is able to access HRMS application

  @sprint1 @smoke @regression @Veronica@login123
  Scenario: valid admin login

    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page

@error @Veronica
Scenario: Invalid admin login

  When user enters invalid username and password
  And user clicks on login button
  Then user can see error message

  @error
  Scenario: Empty admin login and password
    When user leaves username and password empty
    And user clicks on login button
    Then user can see error message