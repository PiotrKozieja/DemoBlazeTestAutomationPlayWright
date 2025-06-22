package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class CategoryPages {
    private final Page page;

    public CategoryPages(Page page) {
        this.page = page;
    }

    // Locators
    public Locator getMacBookAirLocator() {
        return page.locator("a[href=\"prod.html?idp_=11\"][class*='hrefch']");
    }

    public Locator getAppleMonitor24Locator() {
        return page.locator("a[href=\"prod.html?idp_=10\"][class=\"hrefch\"]");
    }

    // Actions
    public ProductPage clickMacBookAir() {
        getMacBookAirLocator().click();
        return new ProductPage(page);
    }

    public ProductPage clickAppleMonitor24() {
        getAppleMonitor24Locator().click();
        return new ProductPage(page);
    }

    // Verification methods
    public Locator isLaptopCategoryDisplayed() {
        return getMacBookAirLocator();
    }

    public Locator isMonitorCategoryDisplayed() {
        return getAppleMonitor24Locator();
    }
}
