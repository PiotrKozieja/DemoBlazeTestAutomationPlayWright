package Cart;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.math.BigDecimal;
import java.util.List;

public class CartPage {
    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    // Locators
    public Locator getTitleLocator() {
        return page.locator("//*[@id=\"page-wrapper\"]/div/div[1]/h2");
    }

    public Locator getTotalPriceLocator() {
        return page.locator("#totalp");
    }

    public Locator getProductPricesLocator() {
        return page.locator("//tr[@class='success']/td[3]");
    }

    public Locator getPlaceOrderButtonLocator() {
        return page.locator("button[class*='btn btn-success']");
    }

    public Locator getCartPopUpTitleLocator() {
        return page.locator("h5[id*=orderModalLabel]");
    }

    public Locator getNameFormLocator() {
        return page.locator("#name");
    }

    public Locator getCountryFormLocator() {
        return page.locator("#country");
    }

    public Locator getCityFormLocator() {
        return page.locator("#city");
    }

    public Locator getCreditCardFormLocator() {
        return page.locator("#card");
    }

    public Locator getMonthFormLocator() {
        return page.locator("#month");
    }

    public Locator getYearFormLocator() {
        return page.locator("#year");
    }

    public Locator getPurchaseButtonLocator() {
        return page.locator("button[onclick='purchaseOrder()']");
    }


    public Locator getPopUpPriceLocator() {
        return page.locator("//p[@class=\"lead text-muted \"]");
    }

    public Locator getOkButtonLocator() {
        return page.locator("//button[@class=\"confirm btn btn-lg btn-primary\"]");
    }

    // Actions
    public void deleteProductFromCart(String productName) {
        Locator productLocator = page.locator("(//tr[td[contains(text(),'" + productName + "')]]//a)[1]");
        productLocator.click();
        productLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    public void clickPlaceOrderButton() {
        getPlaceOrderButtonLocator().click();
    }

    public Locator getPurchasePopUpTitleLocator() {
        return page.locator("//div[@class=\"sweet-alert  showSweetAlert visible\"]/h2");
    }

    public void fillPlaceOrderFormsAndPurchase(String name, String country, String city,
                                               String creditCard, String month, String year) {
        getNameFormLocator().fill(name);
        getCountryFormLocator().fill(country);
        getCityFormLocator().fill(city);
        getCreditCardFormLocator().fill(creditCard);
        getMonthFormLocator().fill(month);
        getYearFormLocator().fill(year);
        getPurchaseButtonLocator().click();
    }

    public void clickOkButtonPopUp() {
        getOkButtonLocator().click();
    }

    // Utility methods
    public BigDecimal getCartTotalPrice() {
        getTotalPriceLocator().waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return new BigDecimal(getTotalPriceLocator().textContent());
    }

    public BigDecimal sumProductInCartPrices() {
        BigDecimal total = BigDecimal.ZERO;
        List<String> prices = getProductPricesLocator().allTextContents();
        for (String price : prices) {
            total = total.add(new BigDecimal(price));
        }
        return total;
    }

    public BigDecimal getPopUpPrice() {
        String text = getPopUpPriceLocator().textContent();
        String[] words = text.split(" ");
        return new BigDecimal(words[2]);
    }
}
