package Pages;
import Cart.CartPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;


public class HomePage extends PageSample {
    private final Page page;

    public HomePage(Page page) {
        super(page);
        this.page = page;
    }

    // Locators
    public Locator getSignUpButtonLocator() {
        return page.locator("#signin2");
    }

    public Locator getLoginButtonLocator() {
        return page.locator("#login2");
    }

    public Locator getContactButtonLocator() {
        return page.locator("a[data-target*='exampleModal']");
    }

    public Locator getLaptopCategoriesButtonLocator() {
        return page.locator("a[onclick*=\"byCat('notebook')\"]");
    }

    public Locator getMonitorCategoriesButtonLocator() {
        return page.locator("a[onclick=\"byCat('monitor')\"]");
    }

    public Locator getPhoneCategoriesButtonLocator() {
        return page.locator("a[onclick=\"byCat('phone')\"]");
    }

    public Locator getCartButtonLocator() {
        return page.locator("#cartur");
    }

    public Locator getLogoutButtonLocator() {
        return page.locator("//a[@onclick=\"logOut()\"]");
    }

    public Locator getCategoriesTitleLocator() {
        return page.locator("//a[@id='cat']");
    }

    public Locator getAboutUsButtonLocator() {
        return page.locator("//a[@class=\"nav-link\"][contains(text(),\"About us\")]");
    }

    // Actions
    public SignupPage clickSignUp() {
        getSignUpButtonLocator().click();
        return new SignupPage(page);
    }

    public LoginPage clickLogin() {
        getLoginButtonLocator().click();
        return new LoginPage(page);
    }

    public ContactPage clickContactButton() {
        getContactButtonLocator().click();
        return new ContactPage(page);
    }

    public CategoryPages clickLaptopsCategories() {
        getLaptopCategoriesButtonLocator().click();
        return new CategoryPages(page);
    }

    public CategoryPages clickMonitorCategoryPage() {
        getMonitorCategoriesButtonLocator().click();
        return new CategoryPages(page);
    }

    public CartPage clickCartButton() {
        getCartButtonLocator().click();
        return new CartPage(page);
    }

    public HomePage clickLogoutButton() {
        getLogoutButtonLocator().click();
        return new HomePage(page);
    }

    // Utility methods
    public boolean checkLogout() {
        return getLoginButtonLocator().isVisible();
    }

    public boolean isPageDisplayedCorrectly() {
        return getContactButtonLocator().isVisible() &&
                getAboutUsButtonLocator().isVisible() &&
                getCartButtonLocator().isVisible() &&
                getLoginButtonLocator().isVisible() &&
                getSignUpButtonLocator().isVisible() &&
                getLaptopCategoriesButtonLocator().isVisible() &&
                getMonitorCategoriesButtonLocator().isVisible() &&
                getPhoneCategoriesButtonLocator().isVisible();
    }
}

