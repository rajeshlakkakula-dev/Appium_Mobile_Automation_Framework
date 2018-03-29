package Myappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Searchdoc {
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<MobileElement> driver; 
	public void base() throws MalformedURLException
	{
		System.out.println("session Started :)");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "1cb89bal");
		cap.setCapability("appPackage", "com.practo.fabric");
		cap.setCapability("appActivity", "com.practo.fabric.LauncherAlias");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap) ;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
	public void loginset()
	{
		System.out.println("permission started :)");
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Chennai\"))").click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='Get Started']").click();
		driver.findElementByXPath("//android.widget.Button[@text='Enter your mobile number']").click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("com.practo.fabric:id/mobile_edit_text")).sendKeys("7358047087");
		driver.hideKeyboard();
		driver.findElement(By.id("com.practo.fabric:id/next")).click();
		driver.findElementByXPath("//android.widget.Button[@text='DENY']").click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

}