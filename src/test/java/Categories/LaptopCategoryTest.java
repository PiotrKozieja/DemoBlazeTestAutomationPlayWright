package Categories;

import Base.BaseTest;
import Pages.CategoryPages;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class LaptopCategoryTest extends BaseTest {
    CategoryPages laptopCategoryPage;
    @BeforeClass
    public void loadLaptopCategory(){this.laptopCategoryPage = homePage.clickLaptopsCategories();}
    @Test
    public void testLaptopCategoryLoadsCorrect(){
        assertThat(laptopCategoryPage.isLaptopCategoryDisplayed()).isVisible();
    }
}
