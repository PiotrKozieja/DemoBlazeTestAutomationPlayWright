package Pages;



import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.time.Duration;

public abstract class PageSample {
    protected Page page;

    protected PageSample(Page page) {
        this.page = page;
    }

    protected void clickElement(String selector) {
        page.waitForSelector(selector,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.ATTACHED)
                        .setTimeout(Duration.ofSeconds(15).toMillis()));
        page.click(selector);
    }

    protected void alertWait() {
        page.waitForTimeout(100); // krótkie opóźnienie dla pewności
        // W Playwright obsługa alertów jest inna - nie ma bezpośredniego odpowiednika waitForAlert
    }
    public static String getAlertMessage(Page page, Runnable action) {
        String[] messageHolder = new String[1];
        page.onceDialog(dialog -> {
            messageHolder[0] = dialog.message();
            dialog.accept();
        });
        action.run();
        return messageHolder[0];
    }

    public void acceptAlert() {
        // Handler dla dialogu powinien być ustawiony przed wystąpieniem alertu
        page.onDialog(dialog -> {
            dialog.accept();
        });
    }

    public String getPopUpTitle(String selector) {
        page.waitForSelector(selector,
                new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(Duration.ofSeconds(15).toMillis()));
        return page.textContent(selector);
    }
}
