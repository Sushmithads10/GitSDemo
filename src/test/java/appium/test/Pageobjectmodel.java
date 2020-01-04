package appium.test;


import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import appium.utilies.ApiDemoHomeBasic;
import appium.utilies.Homepage_PageFactory;
import appium.utilies.ViewPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Pageobjectmodel  extends ApiDemoHomeBasic
  
{
	@Test
public void Basicclass () throws InterruptedException, IOException
{

		AndroidDriver <AndroidElement> driver =capabality("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//pageobjectModle
		Homepage_PageFactory Homepage = new Homepage_PageFactory(driver);
		ViewPage Viewpage =new ViewPage(driver);
		Homepage.view.click();
		Thread.sleep(2000);
		Homepage.dragdrop.click();
		WebElement Source = Viewpage.androidview.get(0);
		WebElement Destination = Viewpage.androidview.get(1);
		
		//normal
		/*driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		Thread.sleep(2000);
		WebElement Source =driver.findElementsByClassName("android.view.View").get(0);
		Thread.sleep(2000);
		WebElement Destination =driver.findElementsByClassName("android.view.View").get(2);*/
		Thread.sleep(2000);
		TouchAction t= new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(Source))).moveTo(element(Destination)).release().perform();
		//t.longPress(element(Source)).moveTo(element(Destination)).release().perform();


}
}
