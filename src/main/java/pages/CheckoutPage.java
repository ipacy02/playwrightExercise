package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {

    public CheckoutPage(Page page) {
        super(page);
    }

    public void submitDetails(String first, String last, String zip) {
        page.locator("[data-test='firstName']").fill(first);
        page.locator("[data-test='lastName']").fill(last);
        page.locator("[data-test='postalCode']").fill(zip);
        page.locator("[data-test='continue']").click();
    }

    public void finish() {
        page.locator("[data-test='finish']").click();
    }

    public String getConfirmationMessage() {
        // This handles Image 3: Checkout: Complete!
        return page.locator(".complete-header").innerText();
    }
}