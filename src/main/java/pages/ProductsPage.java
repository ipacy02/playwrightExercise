package pages;

import com.microsoft.playwright.Page;

public class ProductsPage extends BasePage {

    public ProductsPage(Page page) {
        super(page);
    }

    public void addToCart(String itemName) {
        page.locator(".inventory_item", new Page.LocatorOptions().setHasText(itemName))
                .locator("button").click();
    }

    public void openCart() {
        page.locator(".shopping_cart_link").click();
    }

    public void removeFromCart(String itemName) {
        page.locator(".inventory_item", new Page.LocatorOptions().setHasText(itemName))
                .locator("button").click();
    }

    public String getCartBadgeCount() {
        // Use this to check if the number on the cart goes away or changes
        return page.locator(".shopping_cart_badge").innerText();
    }

    public void sortProducts(String sortValue) {
        // Selects the option by its value (e.g., "lohi" for Price Low to High)
        page.selectOption(".product_sort_container", sortValue);
    }

    public double getFirstProductPrice() {
        // Helper to get the price of the first item to verify sorting worked
        String priceText = page.locator(".inventory_item_price").first().innerText();
        return Double.parseDouble(priceText.replace("$", ""));
    }

}