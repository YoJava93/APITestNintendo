package nintendo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    //Creating the private constructor so this class object is not reachable from outside
    private Driver() {
    }
    //making our driver instance private so it is not reachable outside from the class.
    //we make it static because we want it to run before everything else and also we will use it in a static method

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    //creating re-usable utility method that will return same driver instance everytime we call it
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {

            /*
            We read our browser type from configuration.properties file using
            .getProperty method we creating in ConfigurationReader class.
             */
                String browserType = ConfigurationReader.getProperty("browser");
                String env = ConfigurationReader.getProperty("env");
            /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        // driver.get(env);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "remote-chrome":
                        try{
                        String gridAddress = "54.90.203.187";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

                }
            }
        }

        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driverPool.get();
    }

    //this method make sure we have some form of driver session or driver id has.
    //Either null or not null it must exist.
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
