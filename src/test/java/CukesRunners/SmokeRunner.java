package CukesRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty","html:target/cucumber-reports.html"},
		features="src/test/resources/features", 
		glue = "stepDefinitions",  
		dryRun=false,
		tags="@smokeTest"
		
		// 82.30
		)
public class SmokeRunner {

	
	
}
