package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void begin() {
        openBrowser();
    }


    @After
    public void finish(Scenario scenario) {
        byte[] pic;
        if (scenario.isFailed()) {
            pic = takeScreenShot("failed/" + scenario.getName());
        } else {
            pic = takeScreenShot("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image.png", scenario.getName());

        shutDownBrowser();
    }
}
