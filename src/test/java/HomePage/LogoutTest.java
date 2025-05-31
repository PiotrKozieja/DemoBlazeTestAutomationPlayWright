package HomePage;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {
    HomePage homePage;

    @Test
    public void testLogout(){
        homePage.clickLogoutButton();
        Assert.assertTrue(homePage.checkLogout());
    }
}
