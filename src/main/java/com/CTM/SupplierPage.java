package com.CTM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.AutomationConstant;
import utils.CommonUtils;

import java.io.IOException;

/**
 * Created by shweta on 01/02/2018.
 */
public class SupplierPage extends BasePage {

    public SupplierPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='main-heading']")
    WebElement pageText;
    @FindBy(id = "your-postcode")
    WebElement postCode;
    @FindBy(id = "find-postcode")
    WebElement findPostCode;
    @FindBy(css = ".icon.have-bill-yes")
    WebElement yessHaveBill;
    @FindBy(css = ".icon.have-bill-no")
    WebElement haveBillNo;
    @FindBy(id = "same-supplier-yes")
    WebElement sameSupplier;
    @FindBy(css = ".icon.top-6-british-gas")
    WebElement britishGas;
    @FindBy(id = "same-supplier-no")
    WebElement differentSupplier;
    @FindBy(id = "sel1")
    WebElement supplier;
    @FindBy(css = ".icon.top-6-british-gas")
    WebElement eonEnery;
    @FindBy(css = ".icon.top-6-edf-energy")
    WebElement edfSupplier;
    @FindBy(id = "sel2")
    WebElement selctGasSupplier;
    @FindBy(css = ".icon.energy-gas-electricity")
    WebElement gasAndElectricity;
    @FindBy(css = ".icon.energy-gas")
    WebElement gasOnly;
    @FindBy(css = ".icon.energy-electricity")
    WebElement electricityOnly;
    @FindBy(css = ".button-primary")
    WebElement gotoNextPage;

    public String isUserSupplierPage() {
        String text = pageText.getText();
        return text;
    }

    public void enterPostCode() throws IOException {
        try {
            postCode.sendKeys(AutomationConstant.PostCode);
            findPostCode.click();
            CommonUtils.sleep(2);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("notAbleToEnterPostCode");
        }
    }

    public void isCustomerHaveBill(boolean yesHaveBill) throws IOException {
        try {
            if (yesHaveBill) {
                yessHaveBill.click();//customer has bill
            } else {
                haveBillNo.click();//customer don't have bill
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("isCustomerHaveBillError");
        }
    }

    //This method is to check Gas and electricity from same supplier
    public void isGasNElectricitySameSupply(boolean same) throws IOException {

        try {
            Actions actions = new Actions(driver);
            if (same) {
                actions.moveToElement(sameSupplier).click().build().perform();//Gas and electricity not from same supplier
                britishGas.click();//click British gas
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", differentSupplier);
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("isGasNElectricitySameSupplyError");
        }
    }

    public void selectElectricitySupplier() throws IOException {
        try {
            CommonUtils.selectByText(supplier, "Affect Energy");
        } catch (Exception e) {
            CommonUtils.captureScreenshot("selectElectricitySupplierError");
        }
    }

    public void selectGasSupplier() throws IOException {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(eonEnery).click().build().perform();//british gas
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelectGasSupplier");
        }
    }

    public void gotoEnergyPage() throws IOException {
        try {
            gotoNextPage.click();
        } catch (Exception e) {
            CommonUtils.captureScreenshot("notAbleTogoToEnergyPage");
        }
    }

    public void enterGasNElectricitySupplier() throws IOException {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(edfSupplier).click().build().perform();// EDF energy supplier
            CommonUtils.selectByText(selctGasSupplier, "Affect Energy");
            CommonUtils.sleep(1);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("EnetrGasAndElectricitySupplierError");
        }
    }


    public void compareEnergy(String element) throws IOException {
        try {
            if (element.matches("Gas and Electricity")) {
                gasAndElectricity.click();//compare Gas and Electricity supplier
            } else if (element.matches("Gas only")) {
                gasOnly.click();//compare Gas only
            } else {
                electricityOnly.click();//compare Electricity only
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("comapareEnergyError");
        }
    }


}
