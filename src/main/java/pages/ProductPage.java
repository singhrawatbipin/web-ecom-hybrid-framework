package pages;

import org.openqa.selenium.By;

import core.base.BasePage;

public class ProductPage extends BasePage {

	private By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
	private By addToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
	private By viewCartBtn = By.xpath("//u[text()='View Cart']");
	private By getAddToCartByIndex(int index) {
		return By.xpath("(//a[contains(text(),'Add to cart')])[" + index + "]");
	}
	
	
	

	public void addFirstProductToCart() {
		scrollToElement(firstProduct); // optional scroll
		click(addToCartBtn);
	}

	public void addProductToCartByIndex(int index) {
		By locator = getAddToCartByIndex(index);
		scrollToElement(locator);
		click(locator);
	}

	public void goToCartFromPopup() {
		click(viewCartBtn);
	}

	public void continueShopping() {
		click(By.xpath("//button[text()='Continue Shopping']"));
	}

}
