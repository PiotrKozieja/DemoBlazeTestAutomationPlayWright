package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginPage{
    Page page;

    final Locator loginPopUpTitle;
    final Locator usernameForm;
    final Locator passwordForm;
    final Locator loginButton;
    final Locator welcomeMessage;

    public LoginPage(Page page) {
        this.page = page;

        this.loginPopUpTitle = page.locator("#logInModalLabel");
        this.usernameForm = page.locator("#loginusername");
        this.passwordForm = page.locator("#loginpassword");
        this.loginButton = page.locator("//button[@onclick='logIn()']");
        this.welcomeMessage = page.locator("a[style*='display: block'][id*='nameofuser']");
    }
    public Locator getLoginPopUpTitle() {
        return loginPopUpTitle;
    }

    public Locator getUsernameForm() {
        return usernameForm;
    }

    public Locator getPasswordForm() {
        return passwordForm;
    }

    public Locator getLoginButton() {
        return loginButton;
    }
    public Locator getWelcomeMessage(){
        return welcomeMessage;
    }

    public Locator getPopUpTitle() {
        return loginPopUpTitle;
    }

    public void fillUsername(String username) {
        usernameForm.fill(username);
    }

    public void fillPassword(String password) {
        passwordForm.fill(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


    public void fillLoginFormsAndLogin(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        clickLoginButton();
    }
}
