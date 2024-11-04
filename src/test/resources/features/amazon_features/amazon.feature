@regression @amazon
Feature: Amazon feature

  @p
  Scenario: Validate size of categories
    Given I login to "amazon" website
    When I click "hamburger menu" button
    Then I validate size of categories

    @t2
    Scenario: Creating teacher on web
    Given teacher value
      | first_name | John |
      | last_name  | Wick |