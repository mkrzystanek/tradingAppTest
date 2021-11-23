package stepdefinitions;

import io.cucumber.java.en.When;
import model.Trades;

public class ExecutionSteps {

    private World world;

    public ExecutionSteps(World world) {
        this.world = world;
    }

    @When("POST request is made to {}")
    public void sendPostRequest(String path) {
        world.setResponse(world.getRequest().post(path).then());
    }

    @When("GET request is made to {}")
    public void sendGetRequest(String path) {
        world.setResponse(world.getRequest().get(path).then());
    }

    @When("GET request is made for specific user")
    public void requestSpecificUser() {
        String path = String.format("/api/users/%s", world.getSavedUser().getId());
        world.setResponse(world.getRequest().get(path).then());
    }

    @When("GET request is made for specific security")
    public void requestSpecificSecurity() {
        String path = String.format("/api/securities/%s", world.getSecurity().getId());
        world.setResponse(world.getRequest().get(path).then());
    }

    @When("GET request is made for specific order")
    public void requestSpecificOrder() {
        String path = String.format("/api/orders/%s", world.getOrder().getId());
        world.setResponse(world.getRequest().get(path).then());
    }

    @When("GET request is made for all trades")
    public void requestAllTrades() {
        Trades trades = world.getRequest().get("/api/trades").then().extract().as(Trades.class);
        world.setTrades(trades);
    }

    @When("GET request is made for specific trade by id")
    public void requestSpecificTradeById() {
        String tradeId = world
                .getTrades()
                .getTrades()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to find any trade!"))
                .getId();

        String path = String.format("/api/trades/%s", tradeId);

        world.setResponse(world.getRequest().get(path).then());
    }

}
