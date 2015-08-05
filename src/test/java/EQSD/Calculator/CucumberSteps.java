package EQSD.Calculator;
import junit.framework.TestCase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CucumberSteps extends TestCase{
	
	String input ;
	Calculator calc = new Calculator();
	@Given("^user enters \"([^\"]*)\"$")
	public void user_enters(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		input = arg1;
		
	}

	@Then("^result should be \"([^\"]*)\"$")
	public void result_should_be(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		assertEquals(arg1,calc.calculatePostfix(input));
	}
	

}