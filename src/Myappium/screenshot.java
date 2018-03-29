package Myappium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class screenshot {
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
	public void screening() throws IOException
	{
		try {
			System.out.println("dragging");
			driver.findElementByAccessibilityId("dragAndDrop").click();
		    WebElement drag = driver.findElementByAccessibilityId("dragMe");
			WebElement drop = driver.findElementByAccessibilityId("dropzone");
		    TouchAction action = new TouchAction(driver);
		    action.longPress(drag).moveTo(drop).release();
		    action.perform();
			String text = driver.findElementByXPath("//android.widget.TextView[@text='Circle !']").getText();
			System.out.println(text);
			if(text.equalsIgnoreCase("Circle dropped sucessfully!"))
			{
				System.out.println("Passed");
			} else
			{
				System.out.println("Failed");
				screencapturing(driver);
			}
		} catch (Exception e) {
			// TODO: handle exception
			screencapturing(driver);
		}
	}
	
	public void screencapturing(AppiumDriver<MobileElement> g) throws IOException
	{
		SimpleDateFormat sak = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		Date date= new Date();
		String filename=sak.format(date);
		File de = g.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(de, new File("C:\\Users\\shakthivel\\Eclipse_appium\\MyVin\\screenshot\\"+filename+".png"));
		System.out.println("screenshot taken");
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
	screenshot vin = new screenshot();
	vin.base();
	vin.set1();
	vin.screening();
	//vin.screencapturing(driver);

	}
	}


