package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class ContactPage{
    private final Page page;

    // Elementy strony
    private final Locator contactPopUpTitle;
    private final Locator emailForm;
    private final Locator contactNameForm;
    private final Locator messageForm;
    private final Locator sendMessageButton;

    public ContactPage(Page page) {
        this.page = page;

        // Inicjalizacja lokatorów
        this.contactPopUpTitle = page.locator("h5[id*='exampleModalLabel']");
        this.emailForm = page.locator("#recipient-email");
        this.contactNameForm = page.locator("#recipient-name");
        this.messageForm = page.locator("#message-text");
        this.sendMessageButton = page.locator("button[onclick*='send()']");
    }

    public Locator getContactPopUpTitle() {
        return contactPopUpTitle;
    }

    public void fillContactEmailForm(String email) {
        emailForm.fill(email);
    }

    public void fillContactNameForm(String name) {
        contactNameForm.fill(name);
    }

    public void fillMessageForm(String message) {
        messageForm.fill(message);
    }

    public void clickSendMessageButton() {
        sendMessageButton.click();
    }

    public void fillContactFormsAndSend(String email, String name, String message) {
        fillContactEmailForm(email);
        fillContactNameForm(name);
        fillMessageForm(message);
        clickSendMessageButton();
    }
    public String fillContactFormsSendAndGetAlertMessage(Page page, String email, String name, String message) {
        String[] messageHolder = new String[1];
        page.onceDialog(dialog -> {
            messageHolder[0] = dialog.message();
            dialog.accept();
        });

        fillContactFormsAndSend(email, name, message);
        return messageHolder[0];
    }
}
