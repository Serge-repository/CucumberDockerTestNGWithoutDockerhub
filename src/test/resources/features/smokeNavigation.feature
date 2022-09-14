@Smoke
Feature: Navigation to few pages is working

  Scenario: User navigates to homePage
    Given User is on homePage
    Then title of homePage is "Guru99 Bank Home Page"
    And login form is present

  Scenario: User can navigate to newToursPage
    Given User is on homePage
    When user click on newToursButton
    Then title of newToursPage is "Welcome: Mercury Tours"
    And main fragment is present

  Scenario: User can navigate to tablePage
    Given User is on homePage
    When user click on tableDemoLink
    Then title of tablePage is "Table Demo"
    And table is present