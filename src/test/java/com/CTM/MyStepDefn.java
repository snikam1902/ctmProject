package com.CTM;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

/**
 * Created by shweta on 01/02/2018.
 */
public class MyStepDefn {
    SupplierPage supplierPage = new SupplierPage();
    EnergyPage energyPage = new EnergyPage();
    CustomerDetailsPage customerDetailsPage = new CustomerDetailsPage();
    ResultPage resultPage = new ResultPage();


    @Given("^user is on supplier page$")
    public void user_is_on_supplier_page() {
        String text = supplierPage.isUserSupplierPage();
        Assert.assertEquals(text, "Your Supplier");
    }

    @When("^user enter postcode$")
    public void user_enter_postcode() throws IOException {
        supplierPage.enterPostCode();
    }

    @When("^user choose compare \"([^\"]*)\" option$")
    public void user_choose_compare_option(String arg1) throws IOException {
        supplierPage.compareEnergy(arg1);
    }

    @When("^have electricity bill,different gas and electricity supplier$")
    public void have_electricity_bill_different_gas_and_electricity_supplier() throws IOException {
        supplierPage.isCustomerHaveBill(true);//customer have bill
        supplierPage.isGasNElectricitySameSupply(false);
    }

    @When("^enter all details of gas and electricity supplier$")
    public void enter_all_details_of_gas_and_electricity_supplier() throws Throwable {
        supplierPage.enterGasNElectricitySupplier();
        supplierPage.gotoEnergyPage();
    }

    @Then("^user navigate to Energy Page$")
    public void user_navigate_to_Energy_Page() throws Throwable {
        String headerText = energyPage.isUserEnergyPage();
        Assert.assertEquals(headerText, "Your Energy");
    }

    @When("^user select energy plan and method of payment for electricity$")
    public void user_select_energy_plan_and_method_of_payment_for_electricity() throws Throwable {
        energyPage.selectEnergyPlan("Age UK Fixed 1 year");
        energyPage.selectPayForElectricity("Monthly Direct Debit");
    }

    @When("^select don't have economy(\\d+)meter$")
    public void select_don_t_have_economy_meter(int arg1) throws Throwable {
        energyPage.isEconomy7Meter(false);
    }

    @When("^select electricity is not main source of heating and enter current electricity usage$")
    public void select_electricity_is_not_main_source_of_heating_and_enter_current_electricity_usage() throws Throwable {
        energyPage.isElectricityMainSourceOfHeating(false);
        energyPage.currentElectricityUsage();
        energyPage.gotoNextPage();
    }

    @When("^select type of gas terrif ,method of gas payment$")
    public void select_type_of_gas_terrif_method_of_gas_payment() throws Throwable {
        energyPage.typeOfGasTerrif("Fixed May 2017");
        energyPage.methodOfPayForGas("Monthly Direct Debit");
    }

    @When("^choose gas is not main source of heating and enter current gas usage$")
    public void choose_gas_is_not_main_source_of_heating_and_enter_current_gas_usage() throws Throwable {
        energyPage.isGasMainHeatingSource(false);
        energyPage.currentGasUsage();
        energyPage.gotoNextPage();
    }

    @Then("^user navigate to customer details page$")
    public void user_navigate_to_customer_details_page() throws Throwable {
        Assert.assertEquals(customerDetailsPage.isUserCustomerDetailPage(), "Your Preferences");
    }

    @When("^user select interested terrif, interested payment type$")
    public void user_select_interested_terrif_interested_payment_type() throws Throwable {
        customerDetailsPage.interestedTerrif("Variable tariff");
        customerDetailsPage.interestedPaymentType("Pay on receipt of bill");
    }

    @When("^enter email and agree terms and condition$")
    public void enter_email_and_agree_terms_and_condition() throws Throwable {
        customerDetailsPage.enterEmail();
        customerDetailsPage.agreeTermsNCondition();
    }

    @When("^click on next button$")
    public void click_on_next_button() throws Throwable {
        customerDetailsPage.gotoResultPage();
    }

    @Then("^custome lands on result page$")
    public void custome_lands_on_result_page() throws Throwable {
        String resultText = resultPage.getResultText();
        Assert.assertTrue(resultText.contains("Your supplier details"));
    }

    @Then("^get best supplier$")
    public void get_best_supplier() throws Throwable {
        Assert.assertNotNull(resultPage.tableIsNotNull());
    }

    //Electricity tests
    @When("^user choose don't have electricity bill and select \"([^\"]*)\" option$")
    public void user_choose_don_t_have_electricity_bill_and_select_option(String electricityOnly) throws Throwable {
        supplierPage.isCustomerHaveBill(false);
        supplierPage.compareEnergy(electricityOnly);
    }

    @When("^select electricity supplier$")
    public void select_electricity_supplier() throws Throwable {
        supplierPage.selectElectricitySupplier();
        supplierPage.gotoEnergyPage();

    }

    @Then("^user lands on the Energy Page$")
    public void user_lands_on_the_Energy_Page() {
        String message = energyPage.isOnEnergyPage();
        Assert.assertTrue(message.contains("So that we can work out how much energy you might use in the future, please complete the details below from a recent bill."));

    }


    @When("^user select no option for EconomySevenMeter$")
    public void user_select_no_option_for_EconomySevenMeter() throws IOException {
        energyPage.isEconomy7Meter(false);
    }

    @When("^ender the expenses for electricity$")
    public void ender_the_expenses_for_electricity() throws Throwable {
        energyPage.enterCurrentElectricityUsage();
        energyPage.gotoNextPage();
    }

    @Then("^user navigate to the customer details page$")
    public void user_navigate_to_the_customer_details_page() throws Throwable {
        Assert.assertEquals(customerDetailsPage.isUserCustomerDetailPage(), "Your Preferences");
    }

    @When("^user select interested terrif and emailId$")
    public void user_select_interested_terrif_and_emailId() throws IOException {
        customerDetailsPage.interestedTerrif("Fixed tariff");
        customerDetailsPage.interestedPaymentType("Quarterly direct debit");
        customerDetailsPage.enterEmail();
    }

    @When("^agree terms and conditions$")
    public void agree_terms_and_conditions() throws IOException {
        customerDetailsPage.agreeTermsNCondition();
    }

    @Then("^user navigate to result page$")
    public void user_navigate_to_result_page() throws IOException {
        customerDetailsPage.gotoResultPage();
    }

    @Then("^get best options for electricity supplier$")
    public void get_best_options_for_electricity_supplier() {
        Assert.assertNotNull(resultPage.tableIsNotNull());
    }
//Gas

    @When("^user  have electricity bill and select \"([^\"]*)\" option$")
    public void user_have_electricity_bill_and_select_option(String gasOnly) throws IOException {
        supplierPage.isCustomerHaveBill(true);
        supplierPage.compareEnergy(gasOnly);
    }

    @When("^select Gas supplier and click next button$")
    public void select_Gas_supplier_and_click_next_button() throws IOException {
        supplierPage.selectGasSupplier();
        supplierPage.gotoEnergyPage();
    }

    @Then("^user navigate to the Energy Page$")
    public void user_navigate_to_the_Energy_Page() {
        String headerText = energyPage.isUserEnergyPage();
        Assert.assertEquals(headerText, "Your Energy");
    }

    @When("^user select terrif type and payment options$")
    public void user_select_terrif_type_and_payment_options() throws IOException {
        energyPage.typeOfGasTerrif("Fixed Price December 2017");
        energyPage.methodOfPayForGas("Monthly Direct Debit");
    }

    @When("^selct gas is not main source of heating$")
    public void selct_gas_is_not_main_source_of_heating() throws IOException {
        energyPage.isGasMainHeatingSource(false);
    }

    @When("^enter current gas usage , click next button$")
    public void enter_current_gas_usage_click_next_button() throws IOException {
        energyPage.currentGasUsage();
        energyPage.gotoNextPage();
    }

    @When("^user select interested terrif and interested payment method$")
    public void user_select_interested_terrif_and_interested_payment_method() throws IOException {
        customerDetailsPage.interestedTerrif("All tariffs");
        customerDetailsPage.interestedPaymentType("Monthly direct debit");
    }

    @When("^enter  emailId$")
    public void enter_emailId() throws IOException {
        customerDetailsPage.enterEmail();
    }

    @Then("^get best options for gas supplier$")
    public void get_best_options_for_gas_supplier() {
        Assert.assertNotNull(resultPage.tableIsNotNull());
    }
}
