package Pages;
import Cart.CartPage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;


public class HomePage extends PageSample {
    private Page page;

    final Locator signUpButton;
    final Locator loginButton;
    final Locator contactButton;
    final Locator laptopCategoriesButton;
    final Locator monitorCategoriesButton;
    final Locator cartButton;
    final Locator logoutButton;
    final Locator categoriesTitle;

    public Locator getCartButton() {
        return cartButton;
    }
    public HomePage(Page page) {
        super(page);
        this.page = page;

        this.signUpButton = page.locator("#signin2");
        this.loginButton = page.locator("#login2");
        this.contactButton = page.locator("a[data-target*='exampleModal']");
        this.laptopCategoriesButton = page.locator("a[onclick*=\"byCat('notebook')\"]");
        this.monitorCategoriesButton = page.locator("a[onclick=\"byCat('monitor')\"]");
        this.cartButton = page.locator("#cartur");
        this.logoutButton = page.locator("//a[@onclick=\"logOut()\"]");
        this.categoriesTitle = page.locator("//a[@id='cat']");
    }

    public SignupPage clickSignUp() {
        signUpButton.click();
        return new SignupPage(page);
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return new LoginPage(page);
    }

    public ContactPage clickContactButton() {
        contactButton.click();
        return new ContactPage(page);
    }

    public CategoryPages clickLaptopsCategories() {
        laptopCategoriesButton.click();
        return new CategoryPages(page);
    }

    public CategoryPages clickMonitorCategoryPage() {
        monitorCategoriesButton.click();
        return new CategoryPages(page);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(page);
    }

    public HomePage clickLogoutButton() {
        logoutButton.click();
        return new HomePage(page);
    }
    public boolean checkLogout() {
        return loginButton.isVisible();
    }
    public Locator getCategoriesTitle(){
        return  categoriesTitle;
    }
}

