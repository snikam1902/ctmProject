package com.CTM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

/**
 * Created by shweta on 01/02/2018.
 */
public class BasePage extends BrowserFactory {

    WebDriver driver = BrowserFactory.getDriver();
    public BasePage() {
        PageFactory.initElements(driver, this);
    }
}
