Feature: Deleting teacher Service

  @teacherDelete
  Scenario: Positive teacher deleting
    Given user deletes teacher at "/teacher/delete/2463"
    And user gets teacher at "/teacher/2463"
    Then user verifies response message with "Teacher with id = 2463 NOT FOUND!"
