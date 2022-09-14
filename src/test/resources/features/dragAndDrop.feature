@DragDrop
Feature: Drag and drop is working

  Scenario: Put bank details into drag and drop form
    Given user is on dragAndDrop page
    When user drop debit account "BANK"
    And user drop debit amount "5000"
    And user drop credit account "SALES"
    And user drop credit amount "5000"
    Then success message is shown