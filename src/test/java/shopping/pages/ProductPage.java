package shopping.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver webDriver;
    By addToCartButton = By.cssSelector("a[onclick='addToCart(10)']");
    By priceText = By.className("price-container");

    public ProductPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }


    public void clickAddToCart() {
        webDriver.findElement(addToCartButton).click();
    }

    public String getItemAddedText() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        return alert.getText();
    }

    public void dismissAlert() {
        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
    }

    public String getProductPrice(){
        return webDriver.findElement(priceText).getText().substring(0,4);
    }

}
