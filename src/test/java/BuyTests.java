
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import shopping.pages.CartPage;
import shopping.pages.HomePage;
import shopping.pages.ProductPage;

public class BuyTests extends TestClassBase{

    ChromeDriver driver;
    HomePage homePage ;
    ProductPage productPage;
    CartPage cartPage;

    String productValue;

    @BeforeTest
    void setUp(){
        driver = setUpDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        driver.get("https://www.demoblaze.com/index.html");
    }

    @AfterTest
    void tearDown(){
        quitDriver();
    }

    @Test
    void test_userOrderOneProduct() throws InterruptedException {
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

    }


}
