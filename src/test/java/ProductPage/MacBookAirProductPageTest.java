package ProductPage;

import Base.BaseTest;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class MacBookAirProductPageTest extends BaseTest {
    private ProductPage productPage;

    @BeforeClass
    public void loadMacBookAirProductPage() {
        this.productPage = homePage.clickLaptopsCategories().clickMacBookAir();
    }

    @Test(priority = 1)
    public void testProductLoadsCorrectly() {
        assertThat(productPage.getProductTitleLocator()).hasText("MacBook air");
    }

    @Test(priority = 2)
    public void testAddedToCartAlert() {
        String alert = productPage.addToCartAndGetAlertMessage();
        assertEquals(alert, "Product added.", "Cannot add product to the cart");
    }

    @Test(priority = 3)
    public void testHomePageButtonWorksCorrectly() {
        productPage.clickHomePageButton();
        assertThat(homePage.getCategoriesTitleLocator()).isVisible();
    }
}
