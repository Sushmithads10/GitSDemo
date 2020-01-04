package appium.utilies;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage_general
{
public Homepage_general(AndroidDriver driver)
{
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
public WebElement NameField ;

@AndroidFindBy(xpath="//*[@text='Female']")
public WebElement RadioButton;

@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
public WebElement CountryDropdown ;

@AndroidFindBy(xpath="//*[@text='Argentina']")
public WebElement City;


@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
public WebElement Ok ;
}
