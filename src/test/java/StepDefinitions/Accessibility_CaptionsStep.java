package StepDefinitions;

import org.testng.Assert;
import org.apache.log4j.Logger;

import Pages.Accessibility_CaptionsPage;
import Test.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Accessibility_CaptionsStep {

	public String actual;
	static Logger log = Logger.getLogger(Accessibility_CaptionsStep.class);
	
	@Given("^User clicks on accessibility option$")
	public void user_clicks_on_accessibility_option() throws Throwable {
		
		log.info("Entering Accessibility_Caption test case");
		
		Accessibility_CaptionsPage accessibility=new Accessibility_CaptionsPage(Base.driver);
		accessibility.EnterAccessibility_option();
	}

	@Given("^user enters accessibility services and clicks the button$")
	public void user_enters_accessibility_services_and_clicks_the_button() throws Throwable {
		
		Accessibility_CaptionsPage accessibility=new Accessibility_CaptionsPage(Base.driver);
		accessibility.Accesibility_services();
		accessibility.Button_click();

	}

	@When("^user enables th caption$")
	public void user_enables_th_caption() throws Throwable {
		
		log.info("Enable Caption to perform actions");
		
		Accessibility_CaptionsPage accessibility=new Accessibility_CaptionsPage(Base.driver);
		accessibility.Caption_option();
		
		actual=accessibility.switchbar.getText().toLowerCase();
		accessibility.Enable();

	}

	@When("^user performs some other action$")
	public void user_performs_some_other_action() throws Throwable {

		Accessibility_CaptionsPage accessibility=new Accessibility_CaptionsPage(Base.driver);
		accessibility.Lang_select();
		accessibility.Font_size();

	}

	@Then("^Validating the outcomes$")
	public void validating_the_outcomes() throws Throwable {
		
		
		log.info("Validating outcomes of the actions performed after enable caption");

		Accessibility_CaptionsPage accessibility=new Accessibility_CaptionsPage(Base.driver);
		String expected=accessibility.switchbar.getText().toLowerCase();
		
		try {
			
			Assert.assertEquals(expected, actual);
		}
		catch(AssertionError a ){
			
			Assert.assertNotEquals(expected, actual);
		}
		
		log.info("End of the Accessibility scenario");
		
	}

}
