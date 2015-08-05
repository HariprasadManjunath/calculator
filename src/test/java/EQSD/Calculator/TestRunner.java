package EQSD.Calculator;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/resource",
format = {"pretty","html:target/cucumber"})

public class TestRunner {
	


}

