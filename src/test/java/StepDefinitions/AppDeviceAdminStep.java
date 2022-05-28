package StepDefinitions;

import org.testng.Assert;
import org.apache.log4j.Logger;

import Pages.AppAdminPage;
import Pages.AppPage;
import Test.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppDeviceAdminStep {
	
	public boolean flag,expected;
	static Logger log = Logger.getLogger(AppDeviceAdminStep.class);

	
	@Given("^User is inside the application and clicks on App option$")
	public void user_is_inside_the_application_and_clicks_on_App_option() throws Throwable {
		
		log.info("Entering the AppDeviceAdmin test case");
	    
		
		AppPage app=new AppPage(Base.driver);
		
		app.EnterApp();
		
	}

	@Given("^User clicks on the Device Admin option and clicks on general$")
	public void user_clicks_on_the_Device_Admin_option_and_clicks_on_general() throws Throwable {
	    
		AppAdminPage admin=new AppAdminPage(Base.driver);
		admin.ClickAdmin();
		admin.ClickGeneral();
	}

	@When("^user enables the admin rights$")
	public void user_enables_the_admin_rights() throws Throwable {
		
		
		log.info("Enable Device Admin and performing actions ");
	    
		AppAdminPage admin=new AppAdminPage(Base.driver);
		flag=admin.capabilities.isEnabled();
		admin.Enablecheck();
		
	}
	
	
	@Then("^Validate the outcomes$")
	public void validate_the_outcomes() throws Throwable {
		
		
		log.info("Validating the outcome against the actions");
		
		AppAdminPage admin=new AppAdminPage(Base.driver);
		boolean actual=flag;
		expected =admin.capabilities.isEnabled();
		
		if(actual==false)
			Assert.assertNotEquals(actual, expected);
		else
			Assert.assertEquals(actual, expected);
		
		
		log.info("End of the AppDeviceSAdmin test case");
		
	}

}
