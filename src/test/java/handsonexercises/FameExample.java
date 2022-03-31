package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.WebDriverManager;

public class FameExample {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("edge");
		driver.get("https://demoqa.com/frames");
	}
	
	@Test
	public void testMethod() {
		driver.switchTo().frame("frame1");
		String msg = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(msg);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
