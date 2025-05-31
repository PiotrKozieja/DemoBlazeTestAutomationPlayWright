package Pages;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.nio.file.Paths;
import java.time.Duration;

public abstract class PlaywrightBasePage {
    protected final Page page;
    protected final BrowserContext context;

    public PlaywrightBasePage(Page page) {
        this.page = page;
        this.context = page.context();
    }

    // Podstawowe operacje
    protected void clickElement(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(Duration.ofSeconds(15).toMillis()));
        locator.click();
    }

    protected void fillField(Locator locator, String text) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        locator.fill(text);
    }

    protected void clearField(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        locator.clear();
    }

    // Obsługa alertów/dialogów
    public String getAlertMessage() {
        // Playwright używa listenerów do obsługi dialogów
        final String[] message = {null};
        page.onceDialog(dialog -> {
            message[0] = dialog.message();
            dialog.accept();
        });
        return message[0];
    }

    public void acceptAlert() {
        page.onceDialog(Dialog::accept);
    }

    public void dismissAlert() {
        page.onceDialog(Dialog::dismiss);
    }

//    public String waitForAlertAndGetMessage() {
//        Dialog dialog = page.waitForDialog(() -> {});
//        String message = dialog.message();
//        dialog.accept();
//        return message;
//    }

    // Metody tekstowe
    public String getElementText(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        return locator.textContent().trim();
    }

    public String getPopUpTitle(Locator titleLocator) {
        titleLocator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        return titleLocator.textContent().trim();
    }

    // Walidacje
    public boolean isElementVisible(Locator locator) {
        return locator.isVisible();  // Playwright ma wbudowane auto-oczekiwanie
    }

    public boolean isElementEnabled(Locator locator) {
        return locator.isEnabled();
    }

    // Nawigacja
    public void waitForPageToLoad() {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void navigateBack() {
        page.goBack();
        waitForPageToLoad();
    }

    public void navigateForward() {
        page.goForward();
        waitForPageToLoad();
    }

    // Screenshoty
    public void takeScreenshot(String fileName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/" + fileName + ".png")));
    }

    // Zaawansowane metody
    public void scrollToElement(Locator locator) {
        locator.scrollIntoViewIfNeeded();
    }

    public void hoverElement(Locator locator) {
        locator.hover();
    }

    public void waitForElementToDisappear(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.HIDDEN));
    }
}
