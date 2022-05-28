package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AppiumDriver<MobileElement>driver;

	public void base() {

	try {
		
		/*--Taking data from the excel file --*/
		

			DesiredCapabilities dc =new DesiredCapabilities();
			Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
			String sheetName = "SampleExcel";
			
			String PLATFORM_NAME_Value = reader.getCellData(sheetName, 1, 1);
			
			String PLATFORM_VERSION_Value = reader.getCellData(sheetName, 1, 2);
			
			String DEVICE_NAME_Value = reader.getCellData(sheetName, 1, 3);
			
			String AUTOMATION_NAME_Value = reader.getCellData(sheetName, 1, 4);
			
			String appPackage_Value = reader.getCellData(sheetName, 1, 5);

			String appActivity_Value = reader.getCellData(sheetName, 1, 6);
			
			String url_Value = reader.getCellData(sheetName, 1, 7);
			
			/*--Emulator Configuration*/
			
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME,PLATFORM_NAME_Value);
			
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,PLATFORM_VERSION_Value);
		
			dc.setCapability(MobileCapabilityType.DEVICE_NAME,DEVICE_NAME_Value );

			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AUTOMATION_NAME_Value);
						
			dc.setCapability("appPackage", appPackage_Value);
			
			dc.setCapability("appActivity", appActivity_Value);
			
			
			dc.setCapability("screenShotOnError", true);

			
			/*--Headless mode trigger*/
			
			dc.setCapability("avdArgs", "-no-window");

			

			/*Host and Port setup*/
			
			URL url = new URL(url_Value);
			
			
			/*--Driver setup--*/
			driver=new AppiumDriver<MobileElement>(url,dc);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		}

		catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}

}
