Feature: Teacher Details End to End for UI vs APIx

  Scenario Outline: UI vs API cross data validation
    Given user gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user opens teacher profile details page "<teacherID>"
    And user cross validates teacher details on API and on UI

    Examples:
      | resource      | teacherID |
      | /teacher/2625 | 2625      |
      | /teacher/2761 | 2761      |

  @e2e
  Scenario Outline: UI vs API cross data validation with name
    Given user gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user searches for teachers with name "<teacherName>"
    And user cross validates teachers name result on API and on UI with "<teacherName>"


    Examples:
      | resource            | teacherName |
      | /teacher/name/Rahul | Rahul       |



    Scenario: API vs DB end to end data validation

      Given user gets teacher at "/teacher/2625"
      And user connects to Cybertek Training DB
      Then user gets data from DB with "some SQL query"
      And user cross validates API with DB











