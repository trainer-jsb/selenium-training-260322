package handsonexercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class TableDataSearch {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("edge");
		driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
	}
	
	@Test
	public void testMethod() {
		sf = new SoftAssert();
		String expected = "pro";
		//Get list of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		if(rows.size() == 0)
			Assert.fail("FAIL | The row count is zero; failing the test");
		
		//Enter filter parameter
		WebElement oFilter = driver.findElement(By.id("task-table-filter"));
		oFilter.clear();
		oFilter.sendKeys(expected);
		
		//Iterate through search results and assert existence of filter parameter
		for(WebElement oelem: rows) {
			String styleAttrib = oelem.getAttribute("style");
			if(!styleAttrib.equalsIgnoreCase("display: none;")) {
				String actual = oelem.getText().toLowerCase();
				sf.assertTrue(actual.contains(expected), "FAIL | Actual result " +actual+ " didn't contain filter parameter " +expected);
			}
		}
		sf.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}