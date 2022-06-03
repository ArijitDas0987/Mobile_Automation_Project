package Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.excel.lib.util.Xls_Reader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public static AppiumDriver<MobileElement>driver;
	public static AppiumDriverLocalService se;

	String Appium_Main="C:/Program Files/Appium Server GUI/resources/app/node_modules/appium/build/lib/main.js";
	static String node="C:/Program Files/nodejs/node.exe";

	public void base() {
		
		System.out.println(System.getProperty("user.dir"));
		
		Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
		String sheetName = "SampleExcel";
		
		String Start_with_code=reader.getCellData(sheetName, 1, 8);
		
		String Start_Manual=reader.getCellData(sheetName, 1, 9);
		
		
		/* -- Here we can differentiate with start_with_code for starting the driver with 
		 * code or we can use start_Manual variable for start our appium server manually.
		 */
		
		if(Start_Manual.equalsIgnoreCase("headless")) {
			
			try {
				
				/*--Taking data from the excel file --*/
					
					DesiredCapabilities dc =new DesiredCapabilities();
					
					
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
					
					
					/*-- Headless Driver setup-- Here Appium server starts through code --*/
					
					se = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(node)).withAppiumJS(new File(Appium_Main)));
					se.start();
					driver=new AppiumDriver<MobileElement>(se.getUrl(),dc);
					
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
				}
		
				catch (MalformedURLException e) {
					
					e.printStackTrace();
				}
			
		}
		
		else {
			
			try {
				
				/*--Taking data from the excel file --*/
					
					DesiredCapabilities dc =new DesiredCapabilities();
					
					
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

}
