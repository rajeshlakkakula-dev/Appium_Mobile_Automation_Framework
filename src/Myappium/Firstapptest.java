package Myappium;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Firstapptest {

	//AppiumDriver<MobileElement> driver;
	AndroidDriver<MobileElement> driver;
	
	
	public void setup() throws MalformedURLException
	{
		System.out.println("Session is creating");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "1cb89bal");
		cap.setCapability("app", "C:\\Users\\shakthivel\\Eclipse_appium\\MyVin\\apps\\ApiDemos-debug.apk");
	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Session is created");
	}
	
	/*public void validateText()
	{
		//driver.findElementByAccessibilityId("Accessibility").click();
		driver.findElementByAccessibilityId("Animation").click();
		String text = driver.findElementByAccessibilityId("Cloning").getText();
		if(text.equalsIgnoreCase("Cloning"))
		{
			System.out.println("Passed");
		} else
		{
			System.out.println("Failed");
		}
	}*/
	
	/*public void clocktime()
	{
		
		System.out.println("clicking views");
	driver.findElementByAccessibilityId("Views").click();
	driver.findElementByAccessibilityId("Date Widgets").click();
	driver.findElementByAccessibilityId("2. Inline").click();
	driver.findElementByAccessibilityId("3").click();
	driver.findElementByAccessibilityId("45").click();
	driver.findElementByXPath("//android.widget.RadioButton[@text='AM']").click();
	
	}*/
	public void scrolls()
	{
		driver.findElementByAccessibilityId("Views").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\" Tabs\"))");
		
	}

	
public void tearDown()
{
		driver.quit();
}
	
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		Firstapptest objec = new Firstapptest();
		objec.setup();
		objec.scrolls();
		//objec.clocktime();
		//obj.validateText();
		//obj.tearDown();
		

	}
}