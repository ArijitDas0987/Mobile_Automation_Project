package StepDefinitions;

import org.apache.log4j.Logger;

import Pages.AddLayoutPage;
import Test.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AddLayout_step {
	
	public int actual,expected;
	
	static Logger log = Logger.getLogger(AddLayout_step.class);
	
	@Given("^User is in the application and uer clicks on animation button$")
	public void user_is_in_the_application_and_uer_clicks_on_animation_button() throws Throwable {
		
		log.info("Entering the animation Addlayout test case");
		
		AddLayoutPage layout=new AddLayoutPage(Base.driver);
		layout.ClickAnimation();
		
	}

	@Given("^user clicks on default layout animation$")
	public void user_clicks_on_default_layout_animation() throws Throwable {
		
		AddLayoutPage layout=new AddLayoutPage(Base.driver);
		layout.Layout();

	}

	@When("^user performs add operation$")
	public void user_performs_add_operation() throws Throwable {
		
		log.info("Adding element");
		
		AddLayoutPage layout=new AddLayoutPage(Base.driver);
		
		expected=layout.ListSize()-1;

		layout.Add_Button();

		actual=layout.ListSize();

	}

	@Then("^validating the outcomes against the action$")
	public void validating_the_outcomes_against_the_action() throws Throwable {
		
		log.info("Validating the outcome against the add performance");

		Assert.assertNotSame(expected, actual);
		
		log.info("End of the Addlayout testcase");
	}
}
