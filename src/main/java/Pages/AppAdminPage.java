package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class AppAdminPage {

	AppiumDriver driver;

	public AppAdminPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*--Page Elements--*/

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[5]")
	public WebElement device_admin;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]")
	public WebElement general;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout")
	public WebElement checkbox;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]")
	public WebElement enable_admin;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]")
	public WebElement capabilities;

	/*--Methods to access the elements--*/

	public void ClickAdmin() throws InterruptedException {
		device_admin.click();
		Thread.sleep(2000);
	}

	public void ClickGeneral() throws InterruptedException {
		general.click();
		Thread.sleep(2000);
	}

	public void Enablecheck() throws InterruptedException {

		boolean check = capabilities.isEnabled();

		if (check == false) {

			checkbox.click();

			driver.findElement(MobileBy
					.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));

			enable_admin.click();
			Thread.sleep(2000);

			capabilities.click();
		}

		if (check) {

			capabilities.click();

		}

	}
}
