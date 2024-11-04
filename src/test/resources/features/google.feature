@regression
Feature: Google feature verifications
  Agile Story: User stories, acceptance criteria
  Basically we can pass here any additional information related to this feature file
  #comments are done using hashtag sign in feature file

  @smokeTest @miniRegression
  Scenario: Google title verification
    When User is on google homepage
    Then User should see title contains Google

  Scenario Outline: Google title verification after searching a term
    When User is on google homepage
    And User types "<criteria>" into the search box
    And User clicks to search button
    Then User should see "<criteria>" in the title
    Examples:
      | criteria     |
      | wooden spoon |
      | silver spoon |