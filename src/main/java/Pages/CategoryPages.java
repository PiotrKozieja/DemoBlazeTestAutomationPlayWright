package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class CategoryPages {
    private final Page page;

    private final Locator macBookAir;
    private final Locator appleMonitor24;

    public CategoryPages(Page page) {
        this.page = page;
        this.macBookAir = page.locator("a[href=\"prod.html?idp_=11\"][class*='hrefch']");
        this.appleMonitor24 = page.locator("a[href=\"prod.html?idp_=10\"][class=\"hrefch\"]");
    }

    public ProductPage clickMacBookAir() {
        macBookAir.click();
        return new ProductPage(page);
    }
    public Locator isLaptopCategoryDisplayed(){
        return macBookAir;
    }

    public ProductPage clickAppleMonitor24() {
        appleMonitor24.click();
        return new ProductPage(page);
    }
    public Locator isMonitorCategoryDisplayed(){
        return appleMonitor24;
    }
}
