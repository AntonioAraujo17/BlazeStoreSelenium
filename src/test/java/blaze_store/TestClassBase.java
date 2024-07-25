package blaze_store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class  TestClassBase {

    ChromeDriver chromeDriver;
    WebDriver.Options driverManage;

    public ChromeDriver setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));

        chromeDriver = new ChromeDriver(options);
        driverManage = chromeDriver.manage();
        driverManage.timeouts().implicitlyWait(Duration.ofSeconds(10));

         return chromeDriver;
    }

    public void quitDriver(){
        driverManage.deleteAllCookies();
        chromeDriver.quit();
    }

}
