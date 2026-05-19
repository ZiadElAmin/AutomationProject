package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"StepsDefinition"},
        plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html"
}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
