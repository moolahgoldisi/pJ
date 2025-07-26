package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.time.Duration;

public class Hooks extends CommonMethods {

    // This class is used to set up and tear down the WebDriver before and after each scenario
    // It ensures that the browser is opened before each test and closed after each test

    @Before
    public void start() {
        openBrowserAndLaunchApplication();

    }


    @After
    public void end(Scenario scenario) {
        byte[] pic;

        if (scenario.isFailed()) {
            pic = takeScreenshot("failed/" + scenario.getName());
        } else {
            pic = takeScreenshot("passed/" + scenario.getName());

            // If the scenario fails, you can take a screenshot or perform other actions
            // For example, you can call a method to take a screenshot

        }
        scenario.attach(pic, "image/png", scenario.getName());
        //driver.quit();
        closeBrowser();

    }
}


