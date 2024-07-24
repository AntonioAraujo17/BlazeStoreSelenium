import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class  TestClassBase {

    ChromeDriver chromeDriver;

    ChromeDriver setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         return chromeDriver;
    }

    void quitDriver(){
        chromeDriver.quit();
    }

}
