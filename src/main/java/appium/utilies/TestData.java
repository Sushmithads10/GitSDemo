package appium.utilies;
import org.testng.annotations.DataProvider;

public class TestData 
{
@DataProvider(name="testdata")
public Object[][] Testdatavalue()
{
	Object[][] obj = new Object[][]
	{
		{"hello"},{"414qee"}
	};
	return obj;
}
}
