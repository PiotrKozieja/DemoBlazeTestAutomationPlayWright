package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class ContactPage {
    private final Page page;

    public ContactPage(Page page) {
        this.page = page;
    }

    // Locators
    public Locator getContactPopUpTitleLocator() {
        return page.locator("h5[id*='exampleModalLabel']");
    }

    public Locator getEmailFormLocator() {
        return page.locator("#recipient-email");
    }

    public Locator getContactNameFormLocator() {
        return page.locator("#recipient-name");
    }

    public Locator getMessageFormLocator() {
        return page.locator("#message-text");
    }

    public Locator getSendMessageButtonLocator() {
        return page.locator("button[onclick*='send()']");
    }

    // Actions
    public void fillContactEmailForm(String email) {
        getEmailFormLocator().fill(email);
    }

    public void fillContactNameForm(String name) {
        getContactNameFormLocator().fill(name);
    }

    public void fillMessageForm(String message) {
        getMessageFormLocator().fill(message);
    }

    public void clickSendMessageButton() {
        getSendMessageButtonLocator().click();
    }

    public void fillContactFormsAndSend(String email, String name, String message) {
        fillContactEmailForm(email);
        fillContactNameForm(name);
        fillMessageForm(message);
        clickSendMessageButton();
    }

    // Utility methods
    public String fillContactFormsSendAndGetAlertMessage(String email, String name, String message) {
        String[] messageHolder = new String[1];
        page.onceDialog(dialog -> {
            messageHolder[0] = dialog.message();
            dialog.accept();
        });

        fillContactFormsAndSend(email, name, message);
        return messageHolder[0];
    }
}
