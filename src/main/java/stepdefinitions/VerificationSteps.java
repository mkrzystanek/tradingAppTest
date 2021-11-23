package stepdefinitions;

import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.assertEquals;

public class VerificationSteps {

    private World world;

    public VerificationSteps(World world) {
        this.world = world;
    }

    @Then("response status is {int} or {int}")
    public void validateResponseStatusAnyOf(int statusOne, int statusTwo) {
        world.getResponse().statusCode(anyOf(is(statusOne), is(statusTwo)));
    }

    @Then("response status is {int}")
    public void validateResponseStatusIs(int status) {
        world.getResponse().statusCode(status);
    }

    @Then("response body contains fields:")
    public void validateResponseBody(Map<String, String> responseBody) {
        for (Map.Entry<String, String> entry : responseBody.entrySet()) {
            if (StringUtils.isNumeric(entry.getValue())) {
                world.getResponse()
                        .body(entry.getKey(), is(parseInt(entry.getValue())));
            } else {
                world.getResponse()
                        .body(
                                entry.getKey(),
                                anyOf(
                                        matchesPattern(entry.getValue()),
                                        is(parseBoolean(entry.getValue())),
                                        is(NumberUtils.toFloat(entry.getValue()))
                                )
                        );
            }
        }
    }

    @Then("order response body contains correct securityId")
    public void validateOrderSecurityId() {
        assertEquals(
                "Incorrect securityId!",
                world.getSecurity().getId(),
                world.getOrder().getSecurityId()
        );
    }

    @Then("order response body contains correct userId")
    public void validateOrderUserId() {
        assertEquals(
                "Incorrect userId!",
                world.getSavedUser().getId(),
                world.getOrder().getUserId()
        );
    }
}
