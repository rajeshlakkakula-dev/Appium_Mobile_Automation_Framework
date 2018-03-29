package Myappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Slider {
	AppiumDriver<MobileElement> driver;
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
	public void siderbar()
	{
		System.out.println("Sliding");
		driver.findElementByAccessibilityId("slider1").click();
		WebElement seek_bar=driver.findElement(By.className("android.widget.SeekBar"));
		
		 int start=seek_bar.getLocation().getX();
	        System.out.println("Startpoint - " + start);
	        int y=seek_bar.getLocation().getY();
	        System.out.println("Yaxis - "+ y);
	        int end=start + seek_bar.getSize().getWidth();
	        System.out.println("End point - "+ end);
	        TouchAction action=new TouchAction(driver);
	        //move slider to 40% of width
	        int moveTo=(int)(end*0.4);
	        action.longPress(start,y).moveTo(moveTo,y).release().perform();
		
	}
	
	public static void main(String args[]) throws MalformedURLException
	{
		Slider slide = new Slider();
		slide.base();
		slide.set1();
		slide.siderbar();
	}
	
	}

