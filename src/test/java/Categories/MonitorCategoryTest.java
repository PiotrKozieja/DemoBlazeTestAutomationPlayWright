package Categories;

import Base.BaseTest;
import Pages.CategoryPages;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class MonitorCategoryTest extends BaseTest {
    CategoryPages monitorCategoryPage;
    @BeforeClass
    public void loadMoniotorCategory(){
        this.monitorCategoryPage = homePage.clickMonitorCategoryPage();
    }
    @Test
    public void testMonitorCategoryLoadsCorrect(){
        assertThat(monitorCategoryPage.isMonitorCategoryDisplayed());
    }
}
