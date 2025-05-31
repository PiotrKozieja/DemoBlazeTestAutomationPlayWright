package Login;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeClass
    public void loadLoginPage(){this.loginPage = homePage.clickLogin();}

    @Test(priority = 1)
    public void testLoginPageLoads(){
        assertThat(loginPage.getPopUpTitle()).hasText("Log in");
    }
    @Test(priority = 2,dataProvider = "accountDataProvider")
    public void testLoggingIn(String username, String password){
        loginPage.fillLoginFormsAndLogin(username, password);
        assertThat(loginPage.getWelcomeMessage()).hasText("Welcome "+username);
    }
}
