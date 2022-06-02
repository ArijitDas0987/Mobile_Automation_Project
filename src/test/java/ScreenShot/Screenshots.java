package ScreenShot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Screenshots {
	public static void captureScreenshot(AppiumDriver<MobileElement> driver) throws IOException {

		String Name="Failed Test";
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"//Screenshots//"+Name+".png"));


	}

}
