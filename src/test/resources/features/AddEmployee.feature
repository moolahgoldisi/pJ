Feature: Add employee

  Background:
   # Given user is able to access HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then user is able to see dashboard page
    When user clicks on PIM option
    And user clicks on Add Employee option

  @sprint1 @melissa
  Scenario: Adding the employee firstname and lastname

    And user enters firstname and lastname
    And user clicks on save button
    Then user is able to see employee added successfully

    @sprint2 @smoke @regression @melissa
    Scenario: Adding the employee firstname and middlename and lastname and ID

      And user enters firstname and middlename and lastname and ID
      And user clicks on save button
      Then user is able to see employee added successfully

      @params
      Scenario: Adding employee using parameters
        And user enters "mark" and "anthony " and "jacob" and "12345"
        And user clicks on save button
        Then user is able to see employee added successfully

        @example
        Scenario Outline: adding multiple employees
          And user add "<firstname>" ,"<middlename>" , "<lastname>" and "<id>"
          And user clicks on save button
          Then user is able to see employee added successfully
          Examples:
            | firstname | middlename | lastname | id    |
            | mark      | anthony    | jacob    | 12345 |
            | john      | doe        | smith    | 67890 |
            | jane      | ms         | smith      | 54321 |

          @data
          Scenario: Adding multiple employees using data table

            When user adds multiple employees using data table and save them
            |firstName | middleName | lastName  | employeeId |
            | mark     | anthony    | jacob     | 12345 |
            | john     | doe        | smith     | 67890 |
            | jane     | ms         |  smith    | 54321 |

            @excel
            Scenario: adding employees using excel file
              When user adds multiple employees from excel file

@empty
              Scenario:Adding empty firstname and lastname employee
                When user enters empty firstname and lastname
                And user clicks on save button
                Then user is able to see error message for empty firstname and lastname
