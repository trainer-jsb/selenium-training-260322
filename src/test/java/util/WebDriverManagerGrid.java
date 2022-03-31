package util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WebDriverManagerGrid {
	
	private WebDriver driver;
	private DesiredCapabilities cap;
	
	public WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
			cap = DesiredCapabilities.chrome();
		else if (browser.equalsIgnoreCase("edge"))
			cap = DesiredCapabilities.edge();
		else
			Assert.fail("Invalid browser name passed. Supported values are edge and chrome");
		
		
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.1.2:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.fail("FAIL | Malforemed URL; check logs for details");
		}
		driver.manage().window().maximize();
		return driver;
	}

}
