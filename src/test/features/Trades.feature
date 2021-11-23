@Full
  Feature: Trades

    Scenario: Get all trades
      When GET request is made to /api/trades
      Then response status is 200 or 204

      Scenario: Request a specific trade by trade id
        Given security is created with name: "ASD"
        And user is created with username: "Barry White" and password: "secret"
        And SELL order is created for price 10.00 and quantity 20
        And user is created with username: "Larry White" and password: "secret"
        And BUY order is created for price 10.00 and quantity 20
        When GET request is made for specific trade by id
        Then response body contains fields:
          | id        | [A-Za-z0-9\-]+ |
          | price     | 10.0           |
          | quantity  | 20             |
        And trade response body contains correct orderBuyId
        And trade response body contains correct orderSellId