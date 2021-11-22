@Full
Feature: Orders

  @Debug
  Scenario: Create an order
    Given user is created with username: "John Doe" and password: "secret"
    And security is created with name: "XYZ"
    When BUY order is created for price 10.00 and quantity 20
    Then response body contains fields:
      | fulfilled | false          |
      | id        | [A-Za-z0-9\-]+ |
      | price     | 10.0F          |
      | quantity  | 20             |
      | type      | BUY            |
    And order response body contains correct securityId
    And order response body contains correct userId