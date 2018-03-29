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

public class Longpress {
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

public void longpress()
{
	System.out.println("LongPress :)");
	driver.findElementByAccessibilityId("longPress").click();
	WebElement holdon= driver.findElementByAccessibilityId("longpress");
	TouchAction action = new TouchAction(driver);
	action.longPress(holdon);
	action.perform();
	driver.findElement(By.id("android:id/button1")).click();
}

public static void main(String args[]) throws MalformedURLException
{
Longpress vin = new Longpress();
vin.base();
vin.set1();
vin.longpress();

}
}
