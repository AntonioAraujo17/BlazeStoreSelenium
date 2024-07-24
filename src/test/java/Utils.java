import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends TestClassBase {

    Wait<WebDriver> wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(4));

    WebElement expectedElement(WebElement element){
        wait.until(a -> element.isDisplayed());
        return element;
    }

}
