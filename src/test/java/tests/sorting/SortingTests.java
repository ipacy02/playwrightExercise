package tests.sorting;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

public class SortingTests extends BaseTest {

    @Test
    public void testSortPriceLowToHigh() {
        LoginPage loginPage = new LoginPage(page);
        ProductsPage productsPage = new ProductsPage(page);

        loginPage.login("standard_user", "secret_sauce");

        // 1. Sort by Price: Low to High
        productsPage.sortProducts("lohi");

        // 2. Verify the first item is the cheapest (7.99 for the Onesie)
        double firstPrice = productsPage.getFirstProductPrice();
        Assert.assertEquals(firstPrice, 7.99, "Sorting failed: The first item is not the cheapest!");
    }
}