package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class LoginPage{
    Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public Locator getPopUpLocator() {
        return page.locator("#logInModalLabel");
    }

    public void clickLoginButton() {
        page.locator("//button[@onclick='logIn()']").click();
    }

    public void fillLoginFormsAndLogin(String username, String password) {
        page.locator("#loginusername").fill(username);
        page.locator("#loginpassword").fill(password);
        clickLoginButton();
    }
}
