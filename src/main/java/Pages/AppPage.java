package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AppPage {

	AppiumDriver driver;
	public String Click = "false";

	public AppPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*--Page Elements--*/

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[3]")
	public WebElement clickApp;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[1]")
	public WebElement action;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[6]")
	public WebElement displayoption;

	@FindBy(how = How.ID, using = "com.example.android.apis:id/toggle_show_title")
	public WebElement showtitle;

	@FindBy(how = How.ID, using = "android:id/action_bar")
	public WebElement titlebar;

	/*--Methods to access the elements--*/

	public void EnterApp() throws InterruptedException {

		clickApp.click();
		Thread.sleep(4000);

	}

	public void Actionbar() throws InterruptedException {

		action.click();
		Thread.sleep(4000);

	}

	public void Displayoption() throws InterruptedException {

		displayoption.click();
		Thread.sleep(4000);

	}

	public String Showtitle() throws InterruptedException {

		showtitle.click();
		Thread.sleep(2000);
		Click = "true";
		return Click;

	}

}
