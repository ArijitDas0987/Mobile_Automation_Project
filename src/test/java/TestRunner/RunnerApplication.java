package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features={"src/test/java/Features"},
		glue={"StepDefinitions"},
		tags={"@animation,@apps,@accessibility"}
	)

public class RunnerApplication extends AbstractTestNGCucumberTests{


}
