package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
       features = "src/test/resources/features/",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,
        monochrome = true,
        tags = "not @Smoke",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
