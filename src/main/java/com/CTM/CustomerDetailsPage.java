package com.CTM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.AutomationConstant;
import utils.CommonUtils;

import java.io.IOException;
import java.util.Random;

/**
 * Created by shweta on 01/02/2018.
 */
public class CustomerDetailsPage extends BasePage {

    public CustomerDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".icon.fixed-rate-1")
    WebElement fixedTerrif;
    @FindBy(how = How.CSS, using = ".icon.variable-bill-1")
    WebElement veriableBill;
    @FindBy(how = How.CSS, using = ".icon.tariff-all")
    WebElement allTerrif;
    @FindBy(how = How.CSS, using = ".icon.annual-1")
    WebElement monthlyPayment;
    @FindBy(how = How.CSS, using = ".icon.quarterly-1")
    WebElement qaurterlyPayment;
    @FindBy(how = How.CSS, using = ".icon.bill-1")
    WebElement payOnRecieptOfBill;
    @FindBy(how = How.CSS, using = ".icon.payment-all")
    WebElement paymentAll;
    @FindBy(how = How.ID, using = "Email")
    WebElement email;
    @FindBy(how = How.ID, using = "marketingPreference")
    WebElement marketingInformation;
    @FindBy(how = How.ID, using = "terms")
    WebElement termNCondition;
    @FindBy(how = How.ID, using = "email-submit")
    WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//main[@class='layout-with-help ng-scope']/div/div/h2")
    WebElement header;

    public String isUserCustomerDetailPage() {
        String pageHeaderText = header.getText();
        System.out.println("the heading:" + pageHeaderText);
        return pageHeaderText;
    }

    //Select interested Terrif type
    public void interestedTerrif(String terrrifType) throws IOException {

        try {
            Actions actions = new Actions(driver);

            {
                if (terrrifType.matches("Fixed tariff")) {
                    actions.moveToElement(fixedTerrif).click().build().perform();
                } else if (terrrifType.matches("Variable tariff")) {
                    actions.moveToElement(veriableBill).click().build().perform();
                } else {
                    actions.moveToElement(allTerrif).click().build().perform();
                }
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelectTerrif");
        }
    }

    //Select interested payment method
    public void interestedPaymentType(String paymentType) throws IOException {
        try {
            Actions actions = new Actions(driver);
            if (paymentType.matches("Monthly direct debit")) {
                actions.moveToElement(monthlyPayment).click().build().perform();
            } else if (paymentType.matches("Quarterly direct debit")) {
                actions.moveToElement(qaurterlyPayment).click().build().perform();
            } else if (paymentType.matches("Pay on receipt of bill")) {
                actions.moveToElement(payOnRecieptOfBill).click().build().perform();
            } else {
                actions.moveToElement(paymentAll).click().build().perform();
            }
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToSelectInterestedPaymentMethod");
        }
    }

    public void enterEmail() throws IOException {
        try {
            email.sendKeys(new Random().nextInt() + AutomationConstant.emailId);
        } catch (Exception e) {
            CommonUtils.captureScreenshot("NotAbleToEnterEmail");
        }
    }

    //Click terms and condition
    public void agreeTermsNCondition() throws IOException {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", marketingInformation);
            js.executeScript("arguments[0].click();", termNCondition);
        }catch (Exception e)
        {
            CommonUtils.captureScreenshot("NotAbleToSelectAgreement");
        }
        }

    public void gotoResultPage() throws IOException {
        try {
            submitButton.click();
            CommonUtils.sleep(1);
        }catch (Exception e)
        {
            CommonUtils.captureScreenshot("NotAbleTogoToNextPAge");
        }
    }
}

