package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTest;

public class CheckoutTests extends BaseTest {

    @Test
    public void testEndToEndPurchase() {
        LoginPage loginPage = new LoginPage(page);
        ProductsPage productsPage = new ProductsPage(page);
        CheckoutPage checkoutPage = new CheckoutPage(page);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();

        page.locator("[data-test='checkout']").click();
        checkoutPage.submitDetails("Jane", "Smith", "90210");
        checkoutPage.finish();

        String message = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(message, "Thank you for your order!");
    }

    @Test
    public void testRemoveProductFromCart() {
        LoginPage loginPage = new LoginPage(page);
        ProductsPage productsPage = new ProductsPage(page);

        loginPage.login("standard_user", "secret_sauce");

        // 1. Add the product first
        productsPage.addToCart("Sauce Labs Backpack");
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1");

        // 2. Remove the product
        productsPage.removeFromCart("Sauce Labs Backpack");

        // 3. Verify the badge is gone
        // Note: On SauceDemo, if the cart is empty, the badge element disappears entirely
        boolean isBadgeVisible = page.locator(".shopping_cart_badge").isVisible();
        Assert.assertFalse(isBadgeVisible, "The cart badge should not be visible after removing the last item.");
    }
}
