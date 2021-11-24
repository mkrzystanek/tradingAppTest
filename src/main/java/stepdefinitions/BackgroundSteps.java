package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import model.Order;
import model.Security;
import model.Type;
import model.User;
import org.apache.http.entity.ContentType;

import static io.restassured.RestAssured.given;

public class BackgroundSteps {

    private World world;

    public BackgroundSteps(World world) {
        this.world = world;
    }

    @Given("request payload:")
    public void requestPayload(String payload) {
        world.getRequest().contentType(ContentType.APPLICATION_JSON.toString()).body(payload);
    }

    @Given("user is created with username: \"{}\" and password: \"{}\"")
    public void createUser(String username, String password) {
        world.setSavedUser(createUser(new User(username, password)));
    }

    @Given("security is created with name: \"{}\"")
    public void createSecurity(String name) {
        world.setSecurity(createSecurity(new Security(name)));
    }

    @When("{type} order is created for price {float} and quantity {int}")
    public void createOrder(Type orderType, double price, int quantity) {
        Order order = Order.builder()
                .fulfilled(false)
                .price(price)
                .quantity(quantity)
                .securityId(world.getSecurity().getId())
                .userId(world.getSavedUser().getId())
                .type(orderType)
                .build();

        world.getOrders().add(createOrder(order));
    }

    private User createUser(User user) {
        world.setResponse(given()
                .body(user)
                .contentType(ContentType.APPLICATION_JSON.toString())
                .when()
                .post("/api/users")
                .then()
                .statusCode(201));

        return world.getResponse().extract().as(User.class);
    }

    private Security createSecurity(Security security) {
        world.setResponse(given()
                .body(security)
                .contentType(ContentType.APPLICATION_JSON.toString())
                .when()
                .post("/api/securities")
                .then()
                .statusCode(201));

        return world.getResponse().extract().as(Security.class);
    }

    private Order createOrder(Order order) {
        world.setResponse(given()
                .body(order)
                .contentType(ContentType.APPLICATION_JSON.toString())
                .when()
                .post("/api/orders")
                .then()
                .statusCode(201));

        return world.getResponse().extract().as(Order.class);
    }

}
