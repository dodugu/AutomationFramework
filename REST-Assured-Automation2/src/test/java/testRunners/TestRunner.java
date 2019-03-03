package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = "classpath:stepDefinition")
//@RunWith(Cucumber.class)
public class TestRunner extends AbstractTestNGCucumberTests {

}