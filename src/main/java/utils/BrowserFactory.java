package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by shweta on 01/02/2018.
 */
public class BrowserFactory {
    static WebDriver driver;

    public static void openBrowser() {
        String url = AutomationConstant.URL;
        String browser = AutomationConstant.BROWSER_TYPE;
        try {
            if (browser.matches("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/browser/geckodriver.exe");//open browser
                driver = new FirefoxDriver();
            } else if (browser.matches("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/browser/chromedriver.exe");//open browser
                driver = new ChromeDriver();

            } else if (browser.matches("internetExplorer")) {
                System.setProperty("webdriver.ie.driver", "src/main/browser/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("FAILURE: Browser did not load: ");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stopBrowser() {
        driver.quit();
    }

}
