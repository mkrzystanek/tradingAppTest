package stepdefinitions;

import io.cucumber.java.en.When;
import model.Trade;
import model.Type;

import java.util.List;
import java.util.function.Predicate;

import static model.Type.BUY;
import static model.Type.SELL;

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
        String path = String.format("/api/orders/%s", world.getFirstSavedOrder().getId());
        world.setResponse(world.getRequest().get(path).then());
    }

    @When("GET request is made for all trades")
    public void requestAllTrades() {
        Trade[] trades = world.getRequest().get("/api/trades").then().extract().as(Trade[].class);
        world.setTrades(trades);
    }

    @When("GET request is made for specific trade by id")
    public void requestSpecificTradeById() {
        requestAllTrades();

        world.setTrade(List.of(world.getTrades())
                .stream()
                .filter(withSellAndBuyOrderIds())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to find any trade!")));

        String path = String.format("/api/trades/%s", world.getTrade().getId());

        world.setResponse(world.getRequest().get(path).then());
    }

    private Predicate<Trade> withSellAndBuyOrderIds() {
        return trade -> trade.getOrderBuyId().equalsIgnoreCase(world.findOrderByType(BUY).getId()) &&
                trade.getOrderSellId().equalsIgnoreCase(world.findOrderByType(SELL).getId());
    }

    @When("GET request is made for specific trade by order ids")
    public void requestSpecificTradeByOrderIds() {
        String sellOrderId = world.findOrderByType(SELL).getId();
        String buyOrderId = world.findOrderByType(BUY).getId();

        String path = String.format("/api/trades/orderBuyId/%s/orderSellId/%s", buyOrderId, sellOrderId);

        world.setResponse(world.getRequest().get(path).then());

        world.setTrade(world.getResponse().extract().body().as(Trade.class));
    }

}
