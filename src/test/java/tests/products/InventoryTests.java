package tests.products;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class InventoryTests extends BaseTest {

    @Test
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(page);
        ProductsPage productsPage = new ProductsPage(page);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");

        String badgeCount = page.locator(".shopping_cart_badge").innerText();
        Assert.assertEquals(badgeCount, "1", "Cart badge did not update!");
    }
}