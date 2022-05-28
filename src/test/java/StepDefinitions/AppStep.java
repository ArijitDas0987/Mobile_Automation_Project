package StepDefinitions;

import org.testng.Assert;
import org.apache.log4j.Logger;

import Pages.AppPage;
import Test.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppStep {
	
	public String actual;
	
	static Logger log = Logger.getLogger(AppStep.class);

	
	@Given("^User is in the application and clicks on app$")
	public void user_is_in_the_application_and_clicks_on_app() throws Throwable {
		
		
		log.info("Entering the App test case");
	    
		AppPage app=new AppPage(Base.driver);
		
		app.EnterApp();
	    
	}
	
	@Given("^user clicks on action bar$")
	public void user_clicks_on_action_bar() throws Throwable {
	
		AppPage app=new AppPage(Base.driver);
		app.Actionbar();
	}

	@When("^user clicks on display action$")
	public void user_clicks_on_display_action() throws Throwable {
		
		log.info("Performing display title action");
	
		AppPage app=new AppPage(Base.driver);
		app.Displayoption();
		
	}

	@When("^user clicks on display show title$")
	public void user_clicks_on_display_show_title() throws Throwable {
		
		log.info("Performing the display show title action");
		
		AppPage app=new AppPage(Base.driver);
		actual=app.Showtitle();

	}

	@Then("^validating the title is visble$")
	public void validating_the_title_is_visble() throws Throwable {
		
		log.info("Validating the outcome against the actions");
	
		String expected="true";
		Assert.assertEquals(actual, expected);
		
		log.info("End of the App test ");
		
	}
}
