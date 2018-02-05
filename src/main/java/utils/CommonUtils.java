package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;


/**
 * Created by shweta on 1/02/2018.
 */
public class CommonUtils {
    protected static WebDriver driver = BrowserFactory.getDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 30);

    public static void waitAndClickOnLink(String link) {
        waitElementPresent(By.linkText(link));
        driver.findElement(By.linkText(link)).click();
    }

    public static boolean isTextPresent(String text) {
        return getVisibleText().contains(text);
    }

    public static String getVisibleText() {
        driver = BrowserFactory.getDriver();
        return driver.findElement(By.tagName("body")).getText();
    }

    public static String getText(By element) {
        return driver.findElement(element).getText();
    }

    public static void waitElementPresent(By element) {
        int counter = 0;

        while (counter <= AutomationConstant.DEFAULT_WAIT_SECONDS) {
            try {
//                wait.until(ExpectedConditions.presenceOfElementLocated(element));
                if (driver.findElement(element).isDisplayed())
                    return;
                else {
                    counter++;
                    System.out.println("Waiting for a sec...");
                    sleep(1);
                }
            } catch (Exception e) {
                //
            }
        }
    }


    public static void sleep(int i) {
        try {
            Thread.sleep(i * 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void captureScreenshot(String screenshotName) throws IOException {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceScreenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            System.out.println("The current url is:" + driver.getCurrentUrl());
            File destinationScreenShot = new File("src/test/resources/screenshots/" + screenshotName + ".png");
             FileUtils.copyFile(sourceScreenShot, destinationScreenShot);
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }

}
