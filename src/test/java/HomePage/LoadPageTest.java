package HomePage;

import Base.BaseTest;
import org.testng.annotations.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class LoadPageTest extends BaseTest {

    @Test
    public void testSuccessfulLoading() {
        assertThat(homePage.getCartButtonLocator()).isVisible();
        assertTrue(homePage.isPageDisplayedCorrectly());
    }
}
