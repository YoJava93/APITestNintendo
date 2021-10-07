package nintendo.step_definition;




import org.junit.After;
import org.junit.Before;

public class Hooks {

    @Before
    public static void init() {
        System.out.println("Setting up browser, or API url..'");
    }

    @After
    public void tearDown() {
        //to close connections
    }
}
