package framework.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import framework.functionlibrary.HomePageLib;
import framework.functionlibrary.SearchResultsLib;
import util.DataProvider;
import util.WebDriverManager;
import util.WebDriverUtilities;

public class SearchProductTests {

	private WebDriverManager webdrvmgr;
	private WebDriver driver;
	private HomePageLib homelib;
	private SearchResultsLib seareslib;
	private SoftAssert sf;
	private WebDriverUtilities webdrvutil;

	// Test Input (Arrange)
	private String propfile = "src/test/resources/base.prop";
	private String url = DataProvider.getTestData(propfile, "url");
	private String searchparam = DataProvider.getTestData(propfile, "searchParam");

	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("edge") String browser) {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser(browser);
		driver.get(url);
	}

	@Test
	public void searchProductTest() throws InterruptedException {
		System.out.println("Searching for product");
		Thread.sleep(5000);
		homelib = new HomePageLib(driver);
		homelib.searchProduct(searchparam);
		
		System.out.println("Waiting for page to load");
		webdrvutil = new WebDriverUtilities(driver);
		webdrvutil.waitForPageToLoad(120);
		
		Thread.sleep(5000);
		System.out.println("Iterating through product list");
		seareslib = new SearchResultsLib(driver);
		List<String> prodnames = seareslib.returnListOfProdNames();

		sf = new SoftAssert();
		for (String prodname : prodnames) {
			sf.assertTrue(prodname.toLowerCase().contains(searchparam.toLowerCase()),
					"FAIL | Product name " + prodname + " didnt contain the seach parameter " + searchparam);
		}
		Thread.sleep(5000);
		sf.assertAll();
	}

	@AfterClass
	public void teadown() {
		
		driver.quit();
	}
}
