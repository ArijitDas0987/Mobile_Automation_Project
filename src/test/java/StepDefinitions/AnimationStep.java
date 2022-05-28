package StepDefinitions;

import org.testng.Assert;
import org.apache.log4j.Logger;
import Pages.AnimationPage;
import Test.Base;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AnimationStep {
	
	Base base=new Base();
	Scenario scn;

	
	static Logger log = Logger.getLogger(AnimationStep.class);


	@Given("^user is inside the application clicks on the animation option$")
	public void user_is_inside_the_application_clicks_on_the_animation_option() throws Throwable {
		
		log.info("Entering the Animation test cases");
		
		AnimationPage animation=new AnimationPage(Base.driver);

		animation.ClickAnimation();
	}

	@Given("^user clicks on the hide and show animation option$")
	public void user_clicks_on_the_hide_and_show_animation_option() throws Throwable {
	    
		AnimationPage animation=new AnimationPage(Base.driver);
		animation.Hide_Show_Animation();
	}

	@Given("^user performs action on hide$")
	public void user_performs_action_on_hide() throws Throwable {
		
		log.info("Performing hide operation");
	    
		AnimationPage animation=new AnimationPage(Base.driver);
		animation.Hide();
	}

	@Then("^Verify the hide action$")
	public void verify_the_hide_action() throws Throwable {
		
		log.info("Validating the outcome against the hide action");
	    
		AnimationPage animation=new AnimationPage(Base.driver);
		int expected=animation.Elements();

		animation.One_element();
		animation.Three_element();

		int actual=animation.elements.size();

		Assert.assertNotEquals(actual, expected);
	}

	@Given("^user performs action on show$")
	public void user_performs_action_on_show() throws Throwable {
		
		log.info("Performing show action");
	    
		AnimationPage animation=new AnimationPage(Base.driver);
		animation.Hide();
		animation.One_element();
		animation.Three_element();
		animation.Show();
	}

	@Then("^Verify the show action$")
	public void verify_the_show_action() throws Throwable {
		
		log.info("Validating the outcome against the show action");
	    
		AnimationPage animation=new AnimationPage(Base.driver);
		int  expected_result=animation.Elements();
		int actual_result=animation.elements.size();
		Assert.assertEquals(actual_result, expected_result);
		
		log.info("End of the Animation test case");
	}

}
