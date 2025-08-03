package pages;

import org.openqa.selenium.By;

import core.base.BasePage;

public class ProductPage extends BasePage {

	private By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
	private By addToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
	private By viewCartBtn = By.xpath("//u[text()='View Cart']");

	public void addFirstProductToCart() {
		scrollToElement(firstProduct); // optional scroll
		click(addToCartBtn);
	}

	public void goToCartFromPopup() {
		click(viewCartBtn);
	}

}
