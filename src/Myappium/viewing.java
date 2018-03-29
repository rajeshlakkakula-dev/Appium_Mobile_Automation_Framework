package Myappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class viewing {
	//AppiumDriver<MobileElement> driver;
		AndroidDriver<MobileElement> driver;
			public void base() throws MalformedURLException
			{
				System.out.println("session Started :)");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("platformName", "Android");
				cap.setCapability("deviceName", "1cb89bal");
				cap.setCapability("app", "C:\\Users\\shakthivel\\Eclipse_appium\\MyVin\\apps\\VodQA1.apk");
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap) ;
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			}
			public void set1()
			{
				System.out.println("Login :)");
				driver.findElementByXPath("//android.widget.TextView[@text='LOG IN']").click();
			}
			/*public void web()
			{
				System.out.println("webview creating new account :)");
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Web View\"))").click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.findElementByXPath("//android.view.View[@bounds='[966,300][1047,342]']").click();
				driver.findElementByXPath("//android.widget.EditText[@bounds='[270,957][855,1020]']").click();
				driver.findElementByXPath("//android.widget.EditText[@bounds='[270,957][855,1020]']").sendKeys("asvmjn");
				driver.hideKeyboard();
				driver.findElementByXPath("//android.widget.EditText[@bounds='[270,1032][855,1095]']").click();
				driver.findElementByXPath("//android.widget.EditText[@bounds='[270,1032][855,1095]']").sendKeys("12345678");
				driver.hideKeyboard();
				driver.findElementByXPath("//android.widget.Button[@text='create account']").click();
				//driver.findElementByAccessibilityId("recaptcha-anchor").click();
				//driver.findElementByXPath("//android.widget.Button[@text='create account']").click();
			}*/
			public void login() 
			{
				System.out.println("Webview login");
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Web View\"))").click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				driver.findElementByXPath("//android.view.View[@bounds='[966,300][1047,342]']").click();
				driver.findElementByXPath("//android.widget.EditText[@bounds='[270,405][855,468]']").sendKeys("asvmjn");
				driver.hideKeyboard();
				driver.findElementByXPath("//android.widget.EditText[@bounds='[270,480][855,543]']").sendKeys("12345678");
				driver.hideKeyboard();
				driver.findElementByXPath("//android.widget.Button[@text='login']").click();
			
			}
			public void comments() throws InterruptedException
		    {

				driver.findElementByXPath("//android.view.View[@text='welcome']").click();
				
				
			}
			
			public void logout()
			{
				driver.findElementByAccessibilityId("logout").click();
			}

public static void main(String args[]) throws MalformedURLException, InterruptedException
{
viewing wheel =new viewing();
wheel.base();
wheel.set1();
//wheel.web();
wheel.login();
wheel.comments();
wheel.logout();
}			
}
