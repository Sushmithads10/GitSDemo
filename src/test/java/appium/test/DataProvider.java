package appium.test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import appium.utilies.AddtoCartPage;
import appium.utilies.Base;
import appium.utilies.Homepage_general;
import appium.utilies.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DataProvider extends Base{
	@Test(dataProvider="testdata",dataProviderClass=TestData.class)
	public void Checkingtext(String value) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	service=StartServer();
	
		 AndroidDriver<AndroidElement> driver =capabality("Appapk");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Homepage_general homegen = new Homepage_general(driver);
		 AddtoCartPage atc= new AddtoCartPage(driver);
		 Thread.sleep(2000);
		 homegen.NameField.click();
		 homegen.NameField.sendKeys(value);
		 Thread.sleep(2000);
		 driver.hideKeyboard();
		 homegen.RadioButton.click();
		 System.out.println(value);
		 Thread.sleep(5000);

}
}
