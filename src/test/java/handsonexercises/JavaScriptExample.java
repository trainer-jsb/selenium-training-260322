package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.WebDriverManager;
import util.WebDriverUtilities;

public class JavaScriptExample {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("edge");
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	@Test
	public void testMethod() {
		WebElement elem = driver.findElement(By.id("uploadPicture"));
		WebDriverUtilities webdrvutil = new WebDriverUtilities(driver);
		webdrvutil.scrollIntoView(elem);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
