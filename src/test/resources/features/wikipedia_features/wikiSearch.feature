@wiki
Feature: Wikipedia search functionality verifications


  Scenario: Wikipedia Search Functionality Title Verification
    When User is on Wikipedia home page
    And User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    When User is on Wikipedia home page
    And User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the main header


  Scenario: Wikipedia Search Functionality ImageHeader Verification
    When User is on Wikipedia home page
    And User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the image header

  # WORK ON THE LAST SCENARIO IN WIKI FEATURE TO MAKE IT SCENARIO OUTLINE
  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality ImageHeader Verification
    When User is on Wikipedia home page
    And User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedValue>" in the image header

    Examples: Test data for image header verification
      | searchValue  | expectedValue |
      | Steve Jobs   | Steve Jobs    |
      | Bill Gates   | Bill Gates    |
      | Donald Trump | Donald Trump  |
      | Ricky Martin | Ricky Martin  |
      | Esen Niiazov | Esen Niiazov  |



