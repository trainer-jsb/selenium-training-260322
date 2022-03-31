package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPO {
	private WebDriver driver;
	private WebDriverWait webdrvwait;
	
	public ProductDetailPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "add-to-cart-button")
	private WebElement btnAddToCart;
	
	
	public void clickAddToCartButton() {
		webdrvwait = new WebDriverWait(driver, 120);
		webdrvwait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
		btnAddToCart.click();
	}
	
}
