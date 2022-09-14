@Test
Feature: File upload is working

  Scenario: User can upload file on uploadFilePage
    Given user is on uploadFilePage
    And title of page is "File Upload Demo"
    When user upload the File
    And click submit button
    Then success file upload message is shown