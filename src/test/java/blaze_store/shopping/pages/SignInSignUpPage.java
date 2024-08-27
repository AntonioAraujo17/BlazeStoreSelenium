package blaze_store.shopping.pages;

import blaze_store.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInSignUpPage {

    WebDriver webDriver;
    Utils utils;

    By usernameInput = By.id("loginusername");
    By passwordInput = By.id("loginpassword");

    public SignInSignUpPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.utils = new Utils(webDriver);
    }

    public void inputLoginCredentials(String username, String password){
        utils.inputText(usernameInput, username);
        utils.inputText(passwordInput, password);
    }

}
