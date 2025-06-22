package Pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class ProductPage {
    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    // Locators
    public Locator getProductTitleLocator() {
        return page.locator("h2[class*=\"name\"]");
    }

    public Locator getAddToCartButtonLocator() {
        return page.locator("a[href][class*=\"btn btn-success btn-lg\"]");
    }

    public Locator getHomePageButtonLocator() {
        return page.locator("a[class*='navbar'][href*='index.html']");
    }

    // Actions
    public void clickAddToCartButton() {
        getAddToCartButtonLocator().click();
    }

    public void clickHomePageButton() {
        getHomePageButtonLocator().click();
    }

    // Utility methods
    public String addToCartAndGetAlertMessage() {
        String[] messageHolder = new String[1];
        page.onceDialog(dialog -> {
            messageHolder[0] = dialog.message();
            dialog.accept();
        });

        clickAddToCartButton();
        page.waitForTimeout(1000); // krótkie oczekiwanie (niezalecane, ale proste)
        return messageHolder[0];
    }
}
