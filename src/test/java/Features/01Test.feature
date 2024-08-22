Feature: Open Application
  @All @App

  Scenario: "Open the Application present in the desktop"()

    Given Open the App
    When enter the application details
    Then Print the Success message
