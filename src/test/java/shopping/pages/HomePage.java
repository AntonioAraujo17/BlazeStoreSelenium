package shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{

    WebDriver webDriver;
    By header = By.id("nava");
    By monitorCategory = By.cssSelector("a[onclick=\"byCat('monitor')\"]");
    By phoneCategory = By.cssSelector("a[onclick=\"byCat('phonr')\"]");
    By laptopCategory = By.cssSelector("a[onclick=\"byCat('notebook')\"]");
    By shopItems = By.cssSelector("div[class=\"card h-100\"]");
    By cartLink = By.id("cartur");

    public HomePage(WebDriver driver){
        this.webDriver = driver;
    }

    public void verifyHeader(){
        webDriver.findElement(header).isDisplayed();
    }

    public void clickMonitorCategory(){
        webDriver.findElement(monitorCategory).click();
    }

    public void selectFirstShopItem() throws InterruptedException {
        Thread.sleep(3000);
        var item = webDriver.findElements(shopItems);
        item.getFirst().click();
    }

    public void clickCartLink(){
        var cart = webDriver.findElement(cartLink);
        cart.isDisplayed();
        cart.click();
    }

}
