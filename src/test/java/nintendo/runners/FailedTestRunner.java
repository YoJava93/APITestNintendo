package nintendo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                    //path from test which will fail
        features = "@target/rerun.txt",
        //path from step_definition
        glue = "nintendo/step_definition"
)

public class FailedTestRunner {
}
