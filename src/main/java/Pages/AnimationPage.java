package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AnimationPage {

	AppiumDriver driver;

	public AnimationPage(AppiumDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*--Page Elements--*/

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]")
	public WebElement animation;

	public void ClickAnimation() {

		animation.click();
	}

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[7]")
	public WebElement hide_show_animations;

	@FindBy(how = How.ID, using = "com.example.android.apis:id/hideGoneCB")
	public WebElement hide;

	@FindBy(how = How.CLASS_NAME, using = "android.widget.Button")
	public List<WebElement> elements;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[2]")
	public WebElement one_element;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[3]")
	public WebElement three_element;

	@FindBy(how = How.ID, using = "com.example.android.apis:id/addNewButton")
	public WebElement show;

	/*--Methods to access the elements--*/

	public void Hide_Show_Animation() {

		hide_show_animations.click();
	}

	public void Hide() throws InterruptedException {

		hide.click();
		Thread.sleep(5000);
	}

	public void One_element() throws InterruptedException {

		one_element.click();
		Thread.sleep(4000);
	}

	public void Three_element() throws InterruptedException {

		three_element.click();
		Thread.sleep(3000);
	}

	public int Elements() {

		return elements.size();
	}

	public void Show() throws InterruptedException {

		show.click();
		Thread.sleep(5000);
	}

}
