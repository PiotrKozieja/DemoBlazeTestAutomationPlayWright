package Base;
import com.microsoft.playwright.*;
import org.testng.annotations.*;
import Pages.HomePage;
import org.testng.annotations.DataProvider;

import java.math.BigDecimal;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;
    protected static HomePage homePage;

    @BeforeSuite
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.demoblaze.com/index.html");
        homePage = new HomePage(page);
        System.out.println("Initialized HomePage: " + homePage);
    }

    @AfterSuite
    public void tearDown() {
            browser.close();
            playwright.close();
        System.out.println("TearDown");
    }

    @DataProvider
    public Object[][] accountDataProvider() {
        return new Object[][] {{"user126789453213123123121234567", "password"}};
    }

    @DataProvider
    public Object[][] contactDataProvider() {
        return new Object[][] {{"testemail@gmail.com", "Jan Kowalski", "Test message"}};
    }

    @DataProvider
    public Object[][] purchaseDataProvider() {
        return new Object[][] {{"jan", "Poland", "krakow", "123456789", "6", "2024"}};
    }

    public Page getPage() {
        return page;
    }
    private BigDecimal productPriceSum;
    public void setProductPriceSum(BigDecimal productPriceSum) {
        this.productPriceSum = productPriceSum;
    }

    public BigDecimal getProductPriceSum() {
        return productPriceSum;
    }
}