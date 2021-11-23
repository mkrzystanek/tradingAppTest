package stepdefinitions;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import model.Order;
import model.Security;
import model.Trades;
import model.User;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class World {

    private RequestSpecification request = given();

    private ValidatableResponse response;

    private User savedUser;

    private Security security;

    private Order order;

    private Trades trades;

    public ValidatableResponse getResponse() {
        if (response == null) {
            throw new RuntimeException("No response found. Make sure an API request was executed before this step.");
        }
        return response;
    }
}
