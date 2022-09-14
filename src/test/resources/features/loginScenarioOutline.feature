@Smoke
Feature: Correct and incorrect login using scenario outline

  Scenario Outline: Login as a authenticated user
    Given homepage opened
    When click on agile page
    And enter <username> and <password>
    And press login button
    Then welcome message should be <expectedMessage>
    Examples:
      | username | password | expectedMessage |
      | 111      | xyz      | User or Password is not valid |
      | 1303     | Guru99   | Welcome To Customer's Page of Guru99 Bank |