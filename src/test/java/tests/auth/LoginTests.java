package tests.auth;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest; // If you made a BaseTest class, otherwise include setup/teardown

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(page.url().contains("inventory.html"), "Redirection failed!");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("locked_out_user", "secret_sauce");

        boolean errorVisible = page.locator("[data-test='error']").isVisible();
        Assert.assertTrue(errorVisible, "Error message should be displayed for locked users");
    }
}