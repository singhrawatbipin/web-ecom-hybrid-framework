package tests.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.base.BaseTest;
import pages.CartPage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {

	@Test
	public void verifyProductAddToCartAndCheckout() {

		ProductPage productPage = new ProductPage();
		CartPage cartPage = new CartPage();

		extentTest.info("Adding first product to cart...");
		productPage.addFirstProductToCart();

		extentTest.info("Opening cart from popup...");
		productPage.goToCartFromPopup();

		extentTest.info("Verifying product is added to cart...");
		Assert.assertTrue(cartPage.isProductVisibleInCart(), "Product not found in cart");

		extentTest.info("Proceeding to checkout...");
		cartPage.clickProceedToCheckout();

		extentTest.pass("Product add to cart and checkout flow verified successfully.");

		// Optional: add assertions or page checks if CheckoutPage is implemented
	}

	@Test
	public void verifyMultipleProductAddToCartByIndexAndCheckout() {

		ProductPage productPage = new ProductPage();
		CartPage cartPage = new CartPage();

		extentTest.info("Adding first product to cart...");
		productPage.addProductToCartByIndex(2); //index value we can also take from excel

		extentTest.info("Continue your shopping...");
		productPage.continueShopping();
		
		extentTest.info("Adding Second product to cart...");
		productPage.addProductToCartByIndex(3);
		
		extentTest.info("Opening cart from popup...");
		productPage.goToCartFromPopup();

		extentTest.info("Verifying product is added to cart...");
		Assert.assertTrue(cartPage.isProductVisibleInCart(), "Product not found in cart");

		extentTest.info("Proceeding to checkout...");
		cartPage.clickProceedToCheckout();

		extentTest.pass("Product add to cart and checkout flow verified successfully.");

		// Optional: add assertions or page checks if CheckoutPage is implemented
	}

}
