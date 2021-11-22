import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@Debug",
        features = "src/test/features/",
        glue = "stepdefinitions"
)
public class ApiTest {
}
