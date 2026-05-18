package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;
    protected String baseUrl = "https://www.saucedemo.com";

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigateToHome() {

        page.navigate(baseUrl);
    }
}