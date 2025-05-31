package ProductPage;

import Base.BaseTest;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class AppleMonitor24ProductPageTest extends BaseTest {
    ProductPage productPage;
    @BeforeClass
    public void loadAppleMonitorPage(){
        this.productPage = homePage.clickMonitorCategoryPage().clickAppleMonitor24();
    }
    @Test(priority = 1)
    public void testProductLoadsCorrectly(){
        assertThat(productPage.getProductTitle()).hasText("Apple monitor 24");
    }
    @Test(priority = 2)
    public void testAddedToCartAlertTwoTimes(){
        String alert = productPage.addToCartAndGetAlertMessage(page);
        Assert.assertEquals(alert,"Product added.", "Cannot add product to the cart");
        String secondAlert = productPage.addToCartAndGetAlertMessage(page);
        Assert.assertEquals(secondAlert,"Product added.", "Cannot add product to the cart");
    }


}
