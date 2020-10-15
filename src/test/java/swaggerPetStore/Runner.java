package swaggerPetStore;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        strict = true,
        dryRun = false,
        glue = {"stepDefs"},
        tags = {"@smoke", "@wireMock"}, // e.g. @filter @search @wip @smoke
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-html-report",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml"}
)

public class Runner {
}
