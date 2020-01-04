package appium.utilies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;

public class ApiDemoHomeBasic {

	public static AndroidDriver <AndroidElement> capabality(String appname) throws IOException {
		// TODO Auto-generated method stub
	//public static void main(String[] args) throws MalformedURLException, InterruptedException {	
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
	prop.load(fis);
	
	    File f2 = new File("src");
		File fd = new File (f2,(String) prop.get(appname));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String devicename =(String) prop.get("device");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,devicename);
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability(MobileCapabilityType.APP, fd.getAbsolutePath());
		AndroidDriver<AndroidElement> d =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
System.out.println("hello");
return d;
	}

}
