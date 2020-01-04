package appium.test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import appium.AppiumFramework.ScrollWindow;
import appium.utilies.AddtoCartPage;
import appium.utilies.Base;
import appium.utilies.Homepage_general;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductSumTotal extends Base

{
	//public static void main(String[] args) throws IOException,InterruptedException{
@Test
	public void calculate() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	service=StartServer();
	
		 AndroidDriver<AndroidElement> driver =capabality("Appapk");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Homepage_general homegen = new Homepage_general(driver);
		 AddtoCartPage atc= new AddtoCartPage(driver);
		 Thread.sleep(2000);
		 homegen.NameField.click();
		 homegen.NameField.sendKeys("Hello");
		 Thread.sleep(2000);
		 driver.hideKeyboard();
		 homegen.RadioButton.click();
		 homegen.CountryDropdown.click();
		 ScrollWindow sw = new ScrollWindow(driver);
		 sw.scrolltest("Argentina");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))")); 
		 homegen.City.click();
		 homegen.Ok.click();
atc.product.get(0).click();
atc.product.get(0).click();
	  atc.ADDtocart.click(); 
	  	    System.out.println("Producted is added");
	  	    Thread.sleep(3000);
	  	  String Value1=atc.Price.get(0).getText();
	  	String Value2=atc.Price.get(1).getText();
	  	    //sum the product value
	  	    //value in string
	  	    Thread.sleep(2000);
	  	   
	  	 //remove dollar sysmbol
	  	Value1=Value1.substring(1);
	  	Value2=Value2.substring(1);
	  	//convert into double
	  double convalue1=	Double.parseDouble(Value1);
	  double convalue2=	Double.parseDouble(Value2);
	  double sum;
	  sum=convalue1+convalue2;
	  System.out.println("Doublevalue1="+convalue1);
	  System.out.println("Doublevalue2="+convalue2);
	  System.out.println("Sum of Product "+sum);
	 
	     
	    String Carttotal= atc.TotalAmt.getText();
	    Carttotal= Carttotal.substring(1);
	 double Carttotalfinal=  Double.parseDouble(Carttotal);
	 System.out.println(" CartTotal "+Carttotalfinal);
	 Assert.assertEquals(sum, Carttotalfinal);
	 //Asserts.assertEquals(sum,Carttotalfinal,0);
	 System.out.println("Sum is matching");
	     
	     service.stop();
	     
	}
@BeforeTest
public void killAllNodes() throws IOException
{
	Runtime.getRuntime().exec("taskkill /F /IM node.exe");
}

}


