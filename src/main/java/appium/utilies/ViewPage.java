package appium.utilies;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewPage 
{
public ViewPage(AndroidDriver driver)
{
	PageFactory.initElements( new AppiumFieldDecorator(driver), this);
}
@AndroidFindBy(className="android.view.View")
public List<WebElement> androidview;
}
