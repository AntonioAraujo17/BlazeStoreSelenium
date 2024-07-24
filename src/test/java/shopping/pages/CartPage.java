package shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver webDriver;

    By placeOrderButton = By.cssSelector("button[data-toggle='modal']");

    public CartPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickPlaceOrder() {
        var placeOrder = webDriver.findElement(placeOrderButton);
        placeOrder.isDisplayed();
        placeOrder.click();
    }
}
