package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\muthu\\Downloads\\CucumberPOM_task2-master\\CucumberPOM_task2-master\\Features\\ShoppingCart.feature",
        glue = "StepDefinitions",
        monochrome = true,
        plugin = {"pretty","html:target/CartReport"}
)
public class TestRunner {
}
