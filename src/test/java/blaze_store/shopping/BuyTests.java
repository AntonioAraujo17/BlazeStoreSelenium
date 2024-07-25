package blaze_store.shopping;

import blaze_store.TestClassBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import blaze_store.shopping.pages.CartPage;
import blaze_store.shopping.pages.HomePage;
import shopping.pages.ProductPage;



public class BuyTests {

    TestClassBase testClassBase = new TestClassBase();
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    ChromeDriver driver;


    String productValue;

    @BeforeMethod
    void setUp(){
        driver = testClassBase.setUpDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterTest
    void tearDown(){
        testClassBase.quitDriver();
    }

    @Test
    void test_NonLoggedCustomerMakesPurchaseSuccessfully() throws InterruptedException {
        homePage.verifyHeader();
        homePage.clickMonitorCategory();
        homePage.selectFirstShopItem();

        productValue = productPage.getProductPrice();
        productPage.clickAddToCart();

        Assert.assertEquals(productPage.getItemAddedText(), "Product added");
        productPage.dismissAlert();

        homePage.clickCartLink();
        Assert.assertEquals(productValue, "$400");

        cartPage.clickPlaceOrder();
        cartPage.fillPlaceOrderFields();

    }

    @Test
    void test_LoggedCustomerMakesPurchaseSuccessfully(){}

    @Test
    void test_CustomerWithMultipleItemsMakesPurchaseSuccessfully(){}

    @Test
    void test_CustomerRemovesItemFromTheCart(){}

}
