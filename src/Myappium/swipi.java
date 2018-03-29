package Myappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class swipi {
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
	public void swipings()
	{
		System.out.println("Swiping");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Web View\"))").click();
		//driver.findElementByAccessibilityId("carousel").click();
	}
	public static void main(String args[]) throws MalformedURLException
	{
		swipi swiping = new swipi();
		swiping.base();
		swiping.set1();
		swiping.swipings();
	}
	
	}

