package ourvirtualmarket.step_definitions;

import ourvirtualmarket.utilities.BrowserUtils;
import ourvirtualmarket.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Driver.get().get(ConfigurationReader.get("url"));
    }

    @After()
    public void tearDown(Scenario scenario) throws InterruptedException {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        BrowserUtils.waitFor(2);
        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
