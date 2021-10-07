package nintendo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                  //cucumber reporting plugin
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        //location of feature files
        features = "src/test/resources/features",
        //location of step_definition files
        glue = "nintendo/step_definition",
        //dryRun is used to get snippets
        dryRun = false,
        //using tags we specify which test we want to run
        tags = "@wip"
)

public class CukesRunner {
}
