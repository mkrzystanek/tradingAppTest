@Full
@Users
Feature: Users

  Scenario: Create user - success
    Given request payload:
      """
      {
        "password": "secret",
        "username": "Jane Doe"
      }
      """
    When POST request is made to /api/users
    Then response status is 201
    And response body contains fields:
      | username | Jane Doe       |
      | password | [A-Za-z0-9]+   |
      | id       | [A-Za-z0-9\-]+ |

  Scenario: Get users
    When GET request is made to /api/users
    Then response status is 200 or 204

  Scenario: Get specific user
    Given user is created with username: "John Doe" and password: "secret"
    When GET request is made for specific user
    Then response status is 200
    And response body contains fields:
      | username | John Doe       |
      | password | [A-Za-z0-9]+   |
      | id       | [A-Za-z0-9\-]+ |
