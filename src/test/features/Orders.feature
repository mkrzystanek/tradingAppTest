@Full
Feature: Orders

  Scenario: Create a single buy order
    Given user is created with username: "John Doe" and password: "secret"
    And security is created with name: "XYZ"
    When BUY order is created for price 10.00 and quantity 20
    Then response body contains fields:
      | fulfilled | false          |
      | id        | [A-Za-z0-9\-]+ |
      | price     | 10.0           |
      | quantity  | 20             |
      | type      | BUY            |
    And order response body contains correct securityId
    And order response body contains correct userId

  Scenario: Create a single sell order
    Given user is created with username: "Barry White" and password: "secret"
    And security is created with name: "QWE"
    When SELL order is created for price 300.00 and quantity 1
    Then response body contains fields:
      | fulfilled | false          |
      | id        | [A-Za-z0-9\-]+ |
      | price     | 300.0          |
      | quantity  | 1              |
      | type      | SELL           |
    And order response body contains correct securityId
    And order response body contains correct userId

  Scenario: Create sell and buy order for the same security
    Given security is created with name: "RTY"
    And user is created with username: "Barry White" and password: "secret"
    When SELL order is created for price 10.00 and quantity 20
    Then response body contains fields:
      | fulfilled | false          |
      | id        | [A-Za-z0-9\-]+ |
      | price     | 10.0           |
      | quantity  | 20             |
      | type      | SELL           |
    And order response body contains correct securityId
    And order response body contains correct userId

    Given user is created with username: "Larry White" and password: "secret"
    When BUY order is created for price 10.00 and quantity 20
    Then response body contains fields:
      | fulfilled | true          |
      | id        | [A-Za-z0-9\-]+ |
      | price     | 10.0           |
      | quantity  | 20             |
      | type      | BUY           |
    And order response body contains correct securityId
    And order response body contains correct userId

  Scenario: Get all orders
    When GET request is made to /api/orders
    Then response status is 200 or 204

  Scenario: Request a single order
    Given user is created with username: "John Doe" and password: "secret"
    And security is created with name: "XYZ"
    And BUY order is created for price 10.00 and quantity 20
    When GET request is made for specific order
    Then response status is 200
    And response body contains fields:
      | fulfilled | false          |
      | id        | [A-Za-z0-9\-]+ |
      | price     | 10.0           |
      | quantity  | 20             |
      | type      | BUY            |
    And order response body contains correct securityId
    And order response body contains correct userId
