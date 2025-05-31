package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class SignupPage {
    private final Page page;

    // Element locators
    private final Locator registrationPopUpTitle;
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator signUpButton;

    public SignupPage(Page page) {
        this.page = page;

        // Initialize locators
        this.registrationPopUpTitle = page.locator("#signInModalLabel");
        this.usernameField = page.locator("#sign-username");
        this.passwordField = page.locator("#sign-password");
        this.signUpButton = page.locator("button[onclick*='register()']");
    }

    public String getPopUpTitle() {
        registrationPopUpTitle.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return registrationPopUpTitle.textContent();
    }

    public void setUsername(String username) {
        usernameField.fill(username);
    }

    public void clearUsernameField() {
        usernameField.clear();
    }

    public void setPassword(String password) {
        passwordField.fill(password);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void fillSignupFormsAndSignup(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
    }

    // Additional useful methods
    public boolean isSignUpSuccessful() {
        try {
            page.waitForSelector(".alert-success", new Page.WaitForSelectorOptions().setTimeout(5000));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return page.locator(".alert-danger").textContent();
    }
}
