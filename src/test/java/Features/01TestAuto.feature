Feature: Automate Text Document
  @All @Auto

  Scenario: "Open the Application present in the desktop"()

    Given Open the text document
    When Enter the data
    Then Save the text document