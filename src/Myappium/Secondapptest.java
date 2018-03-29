package Myappium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Secondapptest {
	AndroidDriver<MobileElement> driver;
	//AppiumDriver<MobileElement> driver;
	
	public void voda1() throws MalformedURLException
	{
		System.out.println("session Started :)");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "1cb89bal");
		cap.setCapability("app", "C:\\Users\\shakthivel\\Eclipse_appium\\MyVin\\apps\\VodQA1.apk");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap) ;
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void voda2() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.EditText[1]").clear();
		driver.findElementByXPath("//android.widget.EditText[1]").sendKeys("admin");
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.EditText[2]").clear();
	    driver.findElementByXPath("//android.widget.EditText[2]").sendKeys("admin");
		driver.hideKeyboard();		
		driver.findElementByXPath("//android.widget.TextView[@text='LOG IN']").click();
	}
	
/*public void scroling()
	{
		System.out.println("session Starting :)");
	    driver.findElement(By.className("android.view.ViewGroup")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\" C#\"))");
	
	}*/
	

public static void main(String args[]) throws MalformedURLException, InterruptedException  {
	Secondapptest sec = new Secondapptest();
	sec.voda1();
	sec.voda2();
	//sec.scroling();
	

}
}


