package meetSky.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/auto",
                "src/test/resources/features"
        },
        glue = "meetSky/stepDefinitions",
        dryRun = false,
       tags = " @Features_button",
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json", // create the report
                 "rerun:target/rerun.txt"
        }

)

public class CukesRunner {
}
