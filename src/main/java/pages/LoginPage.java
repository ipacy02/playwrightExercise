package pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public void login(String user, String pass) {
        // We use the navigateToHome() from BasePage here
        navigateToHome();
        page.fill("#user-name", user);      // Using ID #user-name
        page.fill("#password", pass);       // Using ID #password
        page.click("#login-button");        // Using ID #login-button
    }
}