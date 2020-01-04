package appium.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollWindow
{
	AndroidDriver<AndroidElement> driver1;
public ScrollWindow(AndroidDriver<AndroidElement> driver)
{
	this.driver1=driver;
}
public void scrolltest(String text)
{
	driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
}
}
