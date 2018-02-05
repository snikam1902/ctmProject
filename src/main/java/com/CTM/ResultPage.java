package com.CTM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.util.List;

/**
 * Created by shweta on 01/02/2018.
 */
public class ResultPage extends BasePage {

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS,using =".flex-cell.ng-scope")
    WebElement resultPageText;


    public String getResultText() {
        CommonUtils.sleep(2);
        String result = resultPageText.getText();
        return result;
    }

    public int tableIsNotNull() {
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        System.out.println("table is not null:" + rows.size());
        int rowSize = rows.size();
        return rowSize;
    }
}
