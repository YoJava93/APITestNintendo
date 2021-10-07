package nintendo.step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setupScenario() {
        System.out.println("Setting up browser with further details...");
    }

    @After
    public void tearDown() {
        //to close connections
    }
}
