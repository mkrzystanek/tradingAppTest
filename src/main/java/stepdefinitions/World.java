package stepdefinitions;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import model.Order;
import model.Security;
import model.Trade;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class World {

    private RequestSpecification request = given();

    private ValidatableResponse response;

    private User savedUser;

    private Security security;

    private List<Order> orders = new ArrayList<>();

    private Trade[] trades;

    private Trade trade;

    public ValidatableResponse getResponse() {
        if (response == null) {
            throw new RuntimeException("No response found. Make sure an API request was executed before this step.");
        }
        return response;
    }

    public Order getFirstSavedOrder() {
        return getOrders()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to find order!"));
    }

    public Order findOrderByType(Type type) {
        return getOrders().stream()
                .filter(order -> order.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to find sell order!"));
    }
}
