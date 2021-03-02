package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/features/TestBasf.feature",
	    glue="stepDefinations",
	    //tags="@Test",
	    strict=true,
	    monochrome=true,
	    dryRun=false,
	    plugin= {"pretty",
	    		"html:target/selenium-reports",
	    		"html:target/cucumber-reports",
	    		"json:target/cucumber.json"})
public class TestRunner {

}
