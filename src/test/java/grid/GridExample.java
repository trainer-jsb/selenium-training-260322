package grid;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.WebDriverManagerGrid;

public class GridExample {
	
	private WebDriver driver;
	private WebDriverManagerGrid grid;
	
	@Test
	public void testGridExample() throws MalformedURLException, InterruptedException {
		grid = new WebDriverManagerGrid();
		driver = grid.launchBrowser("chrome");
		driver.get("http://www.google.co.in");
		Thread.sleep(10000);
		driver.quit();
	}

}
