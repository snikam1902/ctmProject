package com.CTM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.io.IOException;

/**
 * Created by shweta on 01/02/2018.
 */
public class EnergyPage extends BasePage {

    public EnergyPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//main[@class='your-energy ng-scope']/h2")
    WebElement headerText;
    @FindBy(how = How.XPATH, using = "//main[@class='layout-with-help ng-scope']//p[@class='intro']")
    WebElement msgText;
    @FindBy(how = How.CSS, using = "#electricity-tariff-additional-info")
    WebElement energyplan;
    @FindBy(how = How.CSS, using = "#electricity-payment-method-dropdown-link")
    WebElement methodOfPay;
    @FindBy(how = How.ID, using = "electricity-main-heating-yes")
    WebElement electricityMainHeatingYes;
    @FindBy(how = How.ID, using = "electricity-main-heating-no")
    WebElement electricityMainheatingNo;
    @FindBy(how = How.ID, using = "kwhSpend")
    WebElement kwhSpend;
    @FindBy(how = How.ID, using = "electricity-usage")
    WebElement electricityUsage;
    @FindBy(how = How.ID, using = "gas-tariff-additional-info")
    WebElement gasTerrifSelect;
    @FindBy(how = How.ID, using = "gas-payment-method-dropdown-link")
    WebElement gasPaymentMethod;
    @FindBy(how = How.ID, using = "electricity-usage-dropdown")
    WebElement timespan;
    @FindBy(how = How.ID, using = "gas-main-heating-yes")
    WebElement gasMainHeatingSource;
    @FindBy(how = How.ID, using = "gas-main-heating-yes")
    WebElement gasMainHeatingSourceNo;
    @FindBy(how = How.ID, using = "kwhSpendG")
    WebElement kwhSpendGas;
    @FindBy(how = How.ID, using = "gas-usage")
    WebElement valueGasSpend;
    @FindBy(how = How.ID, using = "type-of-Gas-bill-usage-dropdown")
    WebElement typeOfGasUsageBilPeriod;
    @FindBy(how = How.ID, using = "economy-7-yes")
    WebElement economy7MeterYes;
    @FindBy(how = How.ID, using = "economy-7-no")
    WebElement economy7MeterNo;
    @FindBy(how = How.XPATH, using = "//main[@class='your-energy ng-scope']//p[@class='intro']")
    WebElement messageText;
    @FindBy(how = How.ID, using = "goto-your-energy")
    WebElement next;
    @FindBy(how = How.ID, using = "electricity-current-spend")
    WebElement electricityCurrentSpentTextBox;
    @FindBy(how = How.ID, using = "electricity-current-spend-period")
    WebElement electricityCurrentSpentPeriod;

    public String isUserEnergyPage() {
        String welcomeText = headerText.getText();
        System.out.println("the heading:" + welcomeText);
        return welcomeText;
    }


    public String isOnEnergyPage() {
        String text = msgText.getText();
        return text;
    }

    //This method is to select energy plan
    public void selectEnergyPlan(String plan) throws IOException {
        try {
            CommonUtils.selectByText(energyplan, plan);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelctEnergyPlan");
        }
    }

    //This method is to check how do you pay for electricity
    public void selectPayForElectricity(String type) throws IOException {
        try {
            CommonUtils.selectByText(methodOfPay, type);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbletToSelectPayForElectricity");
        }
    }

    //This method is to check electricity is main source of heating
    public void isElectricityMainSourceOfHeating(boolean yes) throws IOException {
        try {
            Actions actions = new Actions(driver);
            if (yes) {
                actions.moveToElement(electricityMainHeatingYes).click().build().perform();
            } else {
                actions.moveToElement(electricityMainheatingNo).click().build().perform();
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelctElectricityMainSourceOfHeating");
        }
    }

    public void currentElectricityUsage() throws IOException {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(kwhSpend).click().build().perform();
            electricityUsage.sendKeys("3000");
            CommonUtils.selectByText(timespan, "Annually");
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelectCurrentElectricityUsage");
        }
    }

    //This method is for Gas terrrif type
    public void typeOfGasTerrif(String plan) throws IOException {
        try {
            CommonUtils.selectByText(gasTerrifSelect, plan);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToTypeOfGasTerrif");
        }
    }

    //Select method of payement for gas
    public void methodOfPayForGas(String method) throws IOException {
        try {
            CommonUtils.selectByText(gasPaymentMethod, method);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelectMethodOfPayForGas");
        }
    }

    //Gas is the main source of heatig
    public void isGasMainHeatingSource(boolean yes) throws IOException {
        try {
            Actions actions = new Actions(driver);
            if (yes) {
                actions.moveToElement(gasMainHeatingSource).click().build().perform();
            } else {
                actions.moveToElement(gasMainHeatingSourceNo).click().build().perform();
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToGasIsMainHeatingSource");
        }
    }

    public void currentGasUsage() throws IOException {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(kwhSpendGas).click().build().perform();
            valueGasSpend.sendKeys("2000");
            CommonUtils.selectByText(typeOfGasUsageBilPeriod, "Annually");
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToCurrentGasUsage");
        }
    }

    //This method when user don't have bill and enter electricity current usage
    public void enterCurrentElectricityUsage() throws IOException {
        try {
            electricityCurrentSpentTextBox.sendKeys("3000");
            CommonUtils.selectByText(electricityCurrentSpentPeriod, "Annually");
        }catch (Exception e)
        {
            CommonUtils.captureScreenshot("NotAbleToEnterCurrentElectricityValue");
        }

    }

    //This methos is to check wheather customer have economy 7 meter
    public void isEconomy7Meter(boolean yes) throws IOException {
        try {
            Actions actions = new Actions(driver);
            if (yes) {
                actions.moveToElement(economy7MeterYes).click().build().perform();
            } else {
                actions.moveToElement(economy7MeterNo).click().build().perform();
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotIsEconomy7Meter");
        }
    }




    public void gotoNextPage() throws IOException {
        try {
            next.click();
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleTogotoNextPage");
        }
    }
    public void isPrepaymentMeter(boolean yes) {
        Actions actions = new Actions(driver);
        if (yes) {
            WebElement prePaymentMeter = driver.findElement(By.id("prepayment-no"));
            actions.moveToElement(prePaymentMeter).click().build().perform();

        } else {
            WebElement nb = driver.findElement(By.id("prepayment-yes"));
            actions.moveToElement(nb).click().build().perform();

        }
    }
}
