package handsonexercises;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.WebDriverManager;

public class ZBaseTemplate {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("edge");
		driver.get(null);
	}
	
	@Test
	public void testMethod() {
		//Test method comes here
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
