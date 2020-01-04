package appium.utilies;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddtoCartPage 
{
public AddtoCartPage(AndroidDriver driver)
{
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
public List <WebElement> product;

@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
public WebElement ADDtocart;

@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
public List <WebElement> Price;

@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
public WebElement TotalAmt;
}
