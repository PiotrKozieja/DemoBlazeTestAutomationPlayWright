package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class SignupPage {
    private final Page page;

    public SignupPage(Page page) {
        this.page = page;
    }

    public Locator getRegistrationPopUpTitleLocator() {
        return page.locator("#signInModalLabel");
    }

    public Locator getUsernameFieldLocator() {
        return page.locator("#sign-username");
    }

    public Locator getPasswordFieldLocator() {
        return page.locator("#sign-password");
    }

    public Locator getSignUpButtonLocator() {
        return page.locator("button[onclick*='register()']");
    }

    public Locator getAlertSuccessLocator() {
        return page.locator(".alert-success");
    }

    public Locator getAlertDangerLocator() {
        return page.locator(".alert-danger");
    }

    // Actions
    public void setUsername(String username) {
        getUsernameFieldLocator().fill(username);
    }

    public void clearUsernameField() {
        getUsernameFieldLocator().clear();
    }

    public void setPassword(String password) {
        getPasswordFieldLocator().fill(password);
    }

    public void clickSignUpButton() {
        getSignUpButtonLocator().click();
    }

    public void fillSignupFormsAndSignup(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
    }

    // Utility methods
    public String getPopUpTitle() {
        getRegistrationPopUpTitleLocator().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return getRegistrationPopUpTitleLocator().textContent();
    }

    public boolean isSignUpSuccessful() {
        try {
            page.waitForSelector(".alert-success", new Page.WaitForSelectorOptions().setTimeout(5000));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return getAlertDangerLocator().textContent();
    }
}
