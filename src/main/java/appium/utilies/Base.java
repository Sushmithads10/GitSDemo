package appium.utilies;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base 
{
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static void startEmulator() throws IOException, InterruptedException
	{
		File dir =new File("C:\\Users\\Sam\\Desktop\\");
		
		System.out.println(dir);
ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","Start","StartEmulator.bat");
	pb.directory(dir);
	pb.start();
		
	System.out.println("emulator is running");

	}
	
	public AppiumDriverLocalService  StartServer()
	{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		/*boolean flag=checkIfServerIsRunning(4723);
		if(!flag)
		{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}*/
		return service;
	}
	/*public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("C:\\Users\\Sam\\Desktop\\StartEmulator.bat");
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c",System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\StartEmulator.bat");   
		Process p = pb.start();
		Thread.sleep(10000);
	}*/
	public static boolean checkIfServerIsRunning(int port)
	{
	boolean isServerRunning = false;
	ServerSocket serversocket;
	try{
		serversocket = new ServerSocket(port);
		serversocket.close();
	}
	catch(IOException e)
	{
		isServerRunning =true;
	}
	finally
	{
		serversocket=null;
	}
	return isServerRunning;
	}
	public static AndroidDriver <AndroidElement> capabality(String APPname ) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//InputStream fis = new InputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
	
		
	
	    File f2 = new File("src");
		File fd = new File (f2,(String) prop.get(APPname));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//String devicenamecmd =(String) prop.get("device");
		String devicenamecmd= System.getProperty("deviceName");
		if(devicenamecmd.contains("virtual"))
		{
			startEmulator();
		}
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicenamecmd);
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		capabilities.setCapability(MobileCapabilityType.APP, fd.getAbsolutePath());
		driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
System.out.println("Device is started");
return driver;
}
	public static void screenshot(String testname) throws IOException
	{
		File Srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Srcfile, new File (System.getProperty("user.dir")+"\\src\\screenshot\\"+testname+".png"));
	}
}
