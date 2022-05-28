package StepDefinitions;

import org.apache.log4j.Logger;
import org.testng.ITestResult;

import ScreenShot.Screenshots;
import Test.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	Base base=new Base();
	static Logger log = Logger.getLogger(Hooks.class);


	@Before
	public void browser() {
		
		log.info("Application Started");
		
		base.base();
	}

	@After
	public void quit() {
		
		log.info("Application closed");
		
		Base.driver.quit();
		
	}


	public void ss(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus())
			Screenshots.captureScreenshot(Base.driver, result.getName());
	}

}
