package HomePage;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LogoutTest extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public void setUpHomePage(){this.homePage = BaseTest.homePage.clickLogoutButton();}

    @Test
    public void testLogout(){
        Assert.assertTrue(homePage.checkLogout());
    }
}
