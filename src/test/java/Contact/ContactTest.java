package Contact;

import Base.BaseTest;
import Pages.ContactPage;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactTest extends BaseTest {
    ContactPage contactPage;
    @BeforeClass
    public void loadContactPage(){this.contactPage = homePage.clickContactButton();}
    @Test(priority = 1)
    public void testContactPageLoads(){
        assertThat(contactPage.getContactPopUpTitle()).hasText("New message");
    }
    @Test(priority = 2,dataProvider = "contactDataProvider")
    public void testThanksForTheMessageAlert(String contactEmail,String contactName,String contactMessage){
        String alert = contactPage.fillContactFormsSendAndGetAlertMessage(page, contactEmail,contactName,contactMessage);
        Assert.assertEquals(alert,"Thanks for the message!!","Could not send a message");

    }


}
