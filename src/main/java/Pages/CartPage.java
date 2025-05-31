package Cart;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.math.BigDecimal;
import java.util.List;

public class CartPage {
    private final Page page;

    // Elementy strony
    private final Locator productTitle;
    private final Locator totalPrice;
    private final Locator productPrices;
    private final Locator placeOrderButton;
    private final Locator cartPopUpTitle;
    private final Locator nameForm;
    private final Locator countryForm;
    private final Locator cityForm;
    private final Locator creditCardForm;
    private final Locator monthForm;
    private final Locator yearForm;
    private final Locator purchaseButton;
    private final Locator popUpTitleMessage;
    private final Locator popUpPrice;
    private final Locator okButton;

    public CartPage(Page page) {
        this.page = page;

        // Inicjalizacja lokatorów
        this.productTitle = page.locator("//*[@id=\"page-wrapper\"]/div/div[1]/h2");
        this.totalPrice = page.locator("#totalp");
        this.productPrices = page.locator("//tr[@class='success']/td[3]");
        this.placeOrderButton = page.locator("button[class*='btn btn-success']");
        this.cartPopUpTitle = page.locator("h5[id*=orderModalLabel]");
        this.nameForm = page.locator("#name");
        this.countryForm = page.locator("#country");
        this.cityForm = page.locator("#city");
        this.creditCardForm = page.locator("#card");
        this.monthForm = page.locator("#month");
        this.yearForm = page.locator("#year");
        this.purchaseButton = page.locator("button[onclick='purchaseOrder()']");
        this.popUpTitleMessage = page.locator("//div[@class=\"sweet-alert  showSweetAlert visible\"]/h2");
        this.popUpPrice = page.locator("//p[@class=\"lead text-muted \"]");
        this.okButton = page.locator("//button[@class=\"confirm btn btn-lg btn-primary\"]");
    }

    public Locator getTitle() {
        return productTitle;
    }

    public void deleteProductFromCart(String productName) {
        Locator productLocator = page.locator("(//tr[td[contains(text(),'" + productName + "')]]//a)[1]");
        productLocator.click();
        productLocator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN));
    }

    public BigDecimal getCartTotalPrice() {
        totalPrice.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return new BigDecimal(totalPrice.textContent());
    }

    public BigDecimal sumProductInCartPrices() {
        BigDecimal total = BigDecimal.ZERO;
        List<String> prices = productPrices.allTextContents();
        for (String price : prices) {
            total = total.add(new BigDecimal(price));
        }
        return total;
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public Locator getCartPopUpTitle() {
        return cartPopUpTitle;
    }

    public void fillPlaceOrderFormsAndPurchase(String name, String country, String city,
                                               String creditCard, String month, String year) {
        nameForm.fill(name);
        countryForm.fill(country);
        cityForm.fill(city);
        creditCardForm.fill(creditCard);
        monthForm.fill(month);
        yearForm.fill(year);
        purchaseButton.click();
    }

    public Locator getPurchasePopUpTitle() {
        return popUpTitleMessage;
    }

    public BigDecimal getPopUpPrice() {
        String text = popUpPrice.textContent();
        String[] words = text.split(" ");
        return new BigDecimal(words[2]);
    }

    public void clickOkButtonPopUp() {
        okButton.click();
    }
}
