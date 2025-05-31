package Pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class ProductPage {
    private final Page page;

    // Element locators
    private final Locator productTitle;
    private final Locator addToCartButton;
    private final Locator homePageButton;

    public ProductPage(Page page) {
        this.page = page;

        // Initialize locators
        this.productTitle = page.locator("h2[class*=\"name\"]");
        this.addToCartButton = page.locator("a[href][class*=\"btn btn-success btn-lg\"]");
        this.homePageButton = page.locator("a[class*='navbar'][href*='index.html']");
    }

    public Locator getProductTitle() {
        return productTitle;
    }

    public void clickHomePageButton() {
        homePageButton.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }
    public String addToCartAndGetAlertMessage(Page page) {
        String[] messageHolder = new String[1];
        page.onceDialog(dialog -> {
            messageHolder[0] = dialog.message();
            dialog.accept();
        });

        addToCartButton.click();
        page.waitForTimeout(1000); // krótkie oczekiwanie (niezalecane, ale proste)
        return messageHolder[0];
    }
}
