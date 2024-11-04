Feature: Etsy search functionality
  CBT-25 Agile Story : can be placed here
#CucumberParserException
  Background: User is already on Etsy home page
    Given User is on Etsy home page
    #We can pass more than one step under background
  Scenario: Etsy search title verification
    When User searches for wooden spoon
    Then User should see wooden spoon in the Etsy title

  @etsy
  Scenario: Etsy search title verification
    When User searches for "wooden spoon"
    Then User should see "Wooden spoon" in the Etsy title

  @etsy2
  Scenario Outline: Etsy search title verification
    When User searches for "<searchValue>"
    Then User should see "<expectedTitle>" in the Etsy title

    Examples: different data sets
    #command option L for mac
      | searchValue         | expectedTitle       |
      | custom wooden spoon | Custom wooden spoon |
      | wooden spoon        | Wooden spoon        |
      | wooden spoon        | Wooden spoon        |







