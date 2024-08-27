package blaze_store.shopping.pages;

import blaze_store.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage{

    WebDriver webDriver;
    Utils utils;

    By placeOrderButton = By.cssSelector("button[data-toggle='modal']");
    By placeOrderHeader = By.id("orderModalLabel");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By creditCardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseButton = By.cssSelector("button[onclick=\"purchaseOrder()\"]");
    By successIcon = By.cssSelector("div[class=\"sa-icon sa-success animate\"]");
    By purchaseInformationCard = By.cssSelector("p[class=\"lead text-muted \"]");

    public CartPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.utils =  new Utils(webDriver);
    }

    public void clickPlaceOrder() {
        var placeOrder = webDriver.findElement(placeOrderButton);
        placeOrder.isDisplayed();
        placeOrder.click();
    }

    public void fillPlaceOrderFields(){

        utils.expectedElement(placeOrderHeader);
        utils.inputText(nameField, "Antonio" );
        utils.inputText(countryField, "Brasil" );
        utils.inputText(cityField, "Sao Paulo" );
        utils.inputText(creditCardField, "2223444455556666" );
        utils.inputText(monthField, "12" );
        utils.inputText(yearField, "31" );
        utils.dummySleep(2);
        utils.expectedAndClickElement(purchaseButton);

    }

    public String getAmount(){
        String[] lines = webDriver.findElement(purchaseInformationCard).getText().split(System.lineSeparator());
        var getCurrencyValue = lines[1].split("[\\s]");
        return getCurrencyValue[1];
    }



    public Boolean getSuccessIcon(){
        return webDriver.findElement(successIcon).isDisplayed();
    }

}
