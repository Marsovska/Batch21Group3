package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ApiFeature/APIUserCreation.feature",
        glue = "APISteps",
        dryRun = true,
        tags = "",
        plugin = {"pretty", "html:target/cucumber.html", "rerun:target/failed.txt",
                "json:target/cucumber-reports/cucumber.json"}
)


public class APIRunner {

}