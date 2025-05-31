package Cart;

import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class CartPageTest extends BaseTest {
    Cart.CartPage cartPage;

    @BeforeClass
    public void loadCartPage(){this.cartPage= homePage.clickCartButton();}
    @Test(priority = 1)
    public void testCartPageLoads(){
        assertThat(cartPage.getTitle()).hasText("Products");
    }
    @Test(priority = 2)
    public void testAppleMoniotrDeleteFromCart() {
        cartPage.deleteProductFromCart("Apple monitor");
    }
    @Test(priority = 3)
    public void testCartTotalPrice(){
        BigDecimal actualTotalPrice = cartPage.getCartTotalPrice();
        setProductPriceSum(cartPage.sumProductInCartPrices());
        assertEquals(actualTotalPrice,getProductPriceSum(),"Total price and sum of product prices are not the same");
    }
    @Test(priority = 4)
    public void testPlaceOrderButton(){
        cartPage.clickPlaceOrderButton();
        assertThat(cartPage.getCartPopUpTitle()).hasText("Place order");
    }
    @Test(priority = 5,dataProvider = "purchaseDataProvider")
    public void testPurchaseOrderPlace(String name,String country,String city, String creditCard, String month, String year){
        cartPage.fillPlaceOrderFormsAndPurchase(name,country,city,creditCard,month,year);
        assertThat(cartPage.getPurchasePopUpTitle()).hasText("Thank you for your purchase!");
    }
    @Test(priority = 6)
    public void testPopUpPrice(){
        BigDecimal popUpPrice = cartPage.getPopUpPrice();
        assertEquals(popUpPrice,getProductPriceSum(),"Order price and actual actual price are different");
        cartPage.clickOkButtonPopUp();
    }

}
