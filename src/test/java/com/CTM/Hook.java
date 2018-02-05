package com.CTM;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

/**
 * Created by shweta on 04/02/2018.
 */
public class Hook {
    WebDriver driver = null;

    @Before
    public void open()
    {
        BrowserFactory.openBrowser();
        driver = BrowserFactory.getDriver();
    }

    @After
    public void shut()
    {
        BrowserFactory.stopBrowser();
    }
}
