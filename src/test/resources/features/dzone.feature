Feature: DZone header
  @dzone
  Scenario: Header comparison
    Given user goes to "https://dzone.com/articles/gradle-vs-maven"
    And user takes header
    Then user goes to "https://dzone.com/articles/api-security-weekly-issue-71"
    And user takes header of that page
    Then user compares two headers
