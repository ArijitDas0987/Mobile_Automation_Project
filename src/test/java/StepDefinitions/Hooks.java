package StepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import ScreenShot.Screenshots;
import Test.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	
	Base base=new Base();
	static Logger log = Logger.getLogger(Hooks.class);


	@Before
	public void browser() throws MalformedURLException {
		
		log.info("Application Started");
	
		base.base();
	}

	@After
	public void quit(Scenario result) throws IOException {
	
		if(result.isFailed()) {
			
			Screenshots.captureScreenshot(Base.driver);
		}
		log.info("Application closed");
		
		Base.driver.quit();
		
	}

	


}
