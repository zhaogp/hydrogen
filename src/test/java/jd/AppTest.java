package jd;

import org.testng.annotations.*;
import org.testng.ITestContext;

import org.openqa.selenium.server.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@BeforeSuite(alwaysRun=true)
	public void setupBeforeSuite(ITestContext context) {
		String seleniumHost = context.getCurrentXmlTest().getParameter("selenium.host");
		String seleniumPort = context.getCurrentXmlTest().getParameter("selenium.port");
		String seleniumBrowser = context.getCurrentXmlTest().getParameter("selenium.browser");
		String seleniumUrl = context.getCurrentXmlTest().getParameter("selenium.url");
		
		RemoteControlConfiguration rcc = new RemoteControlConfiguration();
		rcc.setSingleWindow(true);
		rcc.setPort(Integer.parseInt(seleniumPort));

		try{
			server = new SeleniumServer(false, rcc);
			server.boot();
		} catch (Exception e) {
			throw new IllegalStateException("can not start selenium server", e);
		}
		
		proc = new HttpCommandProcessor(seleniumHost, Integer.parseInt(seleniumPort),
			seleniumBrowser, seleniumUrl);
		selenium = new DefaultSelenium(proc);
		selenium.start();
	}

	@AfterSuite(alwaysRun=true)
	public void setupAfterSuite(){
		selenium.stop();
		server.stop();
	}
}
