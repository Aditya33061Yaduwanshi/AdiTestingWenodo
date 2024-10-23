package StepDefinition;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty","html:src/test/java/resources/output/cucumber.html",
				 "json:src/test/java/resources/output/cucumber.json",
				 "junit:src/test/java/resources/output/cucumber.xml"},
		
		features = "src/test/java/featurefile/",
		glue = {"StepDefinition"},
		tags = "@tag1",
		dryRun = false, monochrome = true

		)

@RunWith(Cucumber.class)
public class Runner {

}
