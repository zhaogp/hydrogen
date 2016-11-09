package jd;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@BeforeSuite(alwaysRun=true)
	public void setupBeforeSuite(ITestContext context) {
	}

	@AfterSuite(alwaysRun=true)
	public void setupAfterSuite(){
	}

	@Test(description = "Launches the jd site")
	public void launchSite(){
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		//driver.get("www.jd.com");
		try {
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.59.1:4444/wd/hub"),
					DesiredCapabilities.firefox());
			driver.get("http://www.jd.com");
		}catch (MalformedURLException e){
			throw null;
		}
	}

	@Test
	public void test(){

	}




}
