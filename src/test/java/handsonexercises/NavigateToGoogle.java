package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class NavigateToGoogle {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("edge");
	}
	
	@Test
	public void navigateToGoogle() {
		sf = new SoftAssert();
		driver.get("https://www.google.co.in"); 
		String title = driver.getTitle();
		String currentURL = driver.getCurrentUrl();
		sf.assertEquals(title, "Google");
		sf.assertEquals(currentURL, "https://www.google.co.in/");
		//Get text of the locale
		String locale = driver.findElement(By.cssSelector("div.uU7dJb")).getText();
		sf.assertEquals(locale, "India");
		sf.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}