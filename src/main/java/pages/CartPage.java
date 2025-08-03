package pages;

import org.openqa.selenium.By;

import core.base.BasePage;

public class CartPage extends BasePage {

	private By cartProduct = By.xpath("//tr[contains(@id,'product')]");
	private By proceedToCheckout = By.xpath("//a[text()='Proceed To Checkout']");

	public boolean isProductVisibleInCart() {
		return isElementVisible(cartProduct);
	}

	public void clickProceedToCheckout() {
		click(proceedToCheckout);
	}
}
