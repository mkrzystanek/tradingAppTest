package stepdefinitions;

import io.cucumber.java.en.When;

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

}
