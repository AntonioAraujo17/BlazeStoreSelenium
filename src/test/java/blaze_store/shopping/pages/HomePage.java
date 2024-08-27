package blaze_store.shopping.pages;

import blaze_store.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver webDriver;
    Utils utils;
    By header = By.id("nava");
    By monitorCategory = By.cssSelector("a[onclick=\"byCat('monitor')\"]");
    By phoneCategory = By.cssSelector("a[onclick=\"byCat('phonr')\"]");
    By laptopCategory = By.cssSelector("a[onclick=\"byCat('notebook')\"]");
    By shopItems = By.cssSelector("div[class=\"card h-100\"]");
    By cartLink = By.id("cartur");
    By loginLink = By.id("login2");

    public HomePage(WebDriver driver){
        this.webDriver = driver;
        this.utils =  new Utils(webDriver);
    }

    public void verifyHeader(){
        webDriver.findElement(header).isDisplayed();
    }

    public void clickMonitorCategory(){
        webDriver.findElement(monitorCategory).click();
    }

    public void selectFirstShopItem() {
        utils.dummySleep(2);
        var item = webDriver.findElements(shopItems);
        item.getFirst().click();
    }

    public void clickCartLink(){
        var cart = webDriver.findElement(cartLink);
        cart.isDisplayed();
        cart.click();
    }

    public void clickLogInLink(){
        utils.expectedAndClickElement(loginLink);
    }

}
