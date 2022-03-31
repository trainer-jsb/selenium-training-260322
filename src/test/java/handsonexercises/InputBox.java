package handsonexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.WebDriverManager;

public class InputBox {

	WebDriver driver;
	WebDriverManager webdrvmgr;

	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("edge");
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
	}

	@Test
	public void testMethod() {
		String expected = "Testing";
		try {
			driver.findElement(By.xpath("//a[text()='No, thanks!']")).click();
		} catch (Exception ex) {
			// Do nothing
		}
		driver.findElement(By.id("user-message")).clear();
		driver.findElement(By.id("user-message")).sendKeys(expected);

		driver.findElement(By.xpath("//button[@class='btn btn-default'][text()='Show Message']")).click();
		String actual = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}