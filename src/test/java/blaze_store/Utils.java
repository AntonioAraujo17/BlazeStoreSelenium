package blaze_store;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends TestClassBase {

    WebDriver webDriver;

    public Utils(WebDriver driver){
        this.webDriver = driver;
    }

    public void expectedElement(By locator){
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(4));
        var elem = webDriver.findElement(locator);
        wait.until(a -> elem.isDisplayed());
    }

    @NotNull
    public void inputText(By locator, String text){
        webDriver.findElement(locator).sendKeys(text);
    }

    public void expectedAndClickElement(By locator){
        expectedElement(locator);
        webDriver.findElement(locator).click();
    }

    public void dummySleep(int bySeconds){
        try {
            Thread.sleep(Duration.ofSeconds(bySeconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
