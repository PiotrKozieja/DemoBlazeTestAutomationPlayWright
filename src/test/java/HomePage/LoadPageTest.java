package HomePage;

import Base.BaseTest;
import org.testng.annotations.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoadPageTest extends BaseTest {
    @Test
    public void testSuccessfulLoading(){
        assertThat(homePage.getCartButton()).isVisible();
    }
}
