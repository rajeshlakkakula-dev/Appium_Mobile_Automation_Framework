package Myappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Draganddrop {
	AppiumDriver<MobileElement> driver;
	public void base() throws MalformedURLException
	{
		System.out.println("session Started :)");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "1cb89bal");
		cap.setCapability("app", "C:\\Users\\shakthivel\\Eclipse_appium\\MyVin\\apps\\VodQA.apk");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap) ;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void set1()
	{
		System.out.println("Login :)");
		driver.findElementByXPath("//android.widget.TextView[@text='LOG IN']").click();
	}
    
	public void draganddrop()
	{
		System.out.println("dragging");
		driver.findElementByAccessibilityId("dragAndDrop").click();
	    WebElement drag = driver.findElementByAccessibilityId("dragMe");
		WebElement drop = driver.findElementByAccessibilityId("dropzone");
	    TouchAction action = new TouchAction(driver);
	    action.longPress(drag).moveTo(drop).release();
	    action.perform();
		String text = driver.findElementByXPath("//android.widget.TextView[@text='Circle dropped sucessfully!']").getText();
		System.out.println(text);
		if(text.equalsIgnoreCase("Circle dropped sucessfully!"))
		{
			System.out.println("Passed");
		} else
		{
			System.out.println("Failed");
		}
	    
	}

	
public static void main(String args[]) throws MalformedURLException
	{
	Draganddrop dragu =new Draganddrop();
	dragu.base();
	dragu.set1();
	dragu.draganddrop();
	}
}
