# Trading App testing project

This is project contains REST API test  scenarios for simple trading application found here: https://github.com/aldialimucaj/code-challenge.
The tests are written using Java 17, Rest Assured, Cucumber and JUnit.

### Test execution

In order to execute all test scenarios, launch the trading application on localhost, then use command:

```shell
mvn test -Dtest=ApiTest -Dcucumber.filter.tags="@Full"
```