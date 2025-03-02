package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        dryRun = false,
        plugin = {"pretty", "html:target/project.html", "json:target/cucumber-reports/cucumber.json"},
        tags = ""
)


public class TestRunner {
}