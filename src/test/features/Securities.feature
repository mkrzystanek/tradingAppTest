@Full
Feature: Securities

  Scenario: Create a security
    Given request payload:
      """
      {
        "name": "ABC"
      }
      """
    When POST request is made to /api/securities
    Then response status is 201
    And response body contains fields:
      | name | ABC            |
      | id   | [A-Za-z0-9\-]+ |

  Scenario: Get security
    When GET request is made to /api/securities
    Then response status is 200 or 204

  Scenario: Get specific security
    Given security is created with name: "DEF"
    When GET request is made for specific security
    Then response status is 200
    And response body contains fields:
      | name | DEF            |
      | id   | [A-Za-z0-9\-]+ |