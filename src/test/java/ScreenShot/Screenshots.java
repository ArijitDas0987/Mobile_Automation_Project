package ScreenShot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;

public class Screenshots {
	public static void captureScreenshot(AppiumDriver driver,String testname) {
		
		try {
			
			File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("./Screenshots/"+testname+".png"));
				
		}
		
		catch(IOException e){
			
			e.printStackTrace();
		}
		
	}

}
