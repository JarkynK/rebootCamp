package step_definitions.smartbear_stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.smartbear_pages.SBLandingPage;
import pages.smartbear_pages.SBLoginPage;
import pages.smartbear_pages.SBOrderPage;
import pages.smartbear_pages.SBViewAllOrdersPage;
import utilities.Driver;

public class SBOrder_StepDefs {
    //new class under smartbear_stepdefs package
    SBLoginPage sbLoginPage = new SBLoginPage();
    SBLandingPage sbLandingPage = new SBLandingPage();
    SBOrderPage sbOrderPage = new SBOrderPage();
    SBViewAllOrdersPage sbViewAllOrdersPage = new SBViewAllOrdersPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_SmartBear_Tester_account_and_on_Order_page() {

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        sbLoginPage.usernameInput.sendKeys("Tester");
        sbLoginPage.passwordInput.sendKeys("test");
        sbLoginPage.loginButton.click();

        sbLandingPage.orderLink.click();
    }

    @Given("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String dropdownValue) {
        Select productDropdown = new Select(sbOrderPage.productDropdown);
        productDropdown.selectByVisibleText(dropdownValue);
    }

    @Given("User enters {string} to quantity input box")
    public void user_enters_to_quantity_input_box(String givenQuantity) {
        sbOrderPage.quantity.sendKeys(Keys.BACK_SPACE + givenQuantity);
    }

    @Given("User enters {string} to costumer name input box")
    public void user_enters_to_costumer_name_input_box(String customerName) {
        sbOrderPage.customerName.sendKeys(customerName);
    }

    @Given("User enters {string} to street input box")
    public void user_enters_to_street_input_box(String givenStreet) {
        sbOrderPage.street.sendKeys(givenStreet);
    }

    @Given("User enters {string} to city input box")
    public void user_enters_to_city_input_box(String givenCity) {
        sbOrderPage.city.sendKeys(givenCity);
    }

    @Given("User enters {string} to state input box")
    public void user_enters_to_state_input_box(String givenState) {
        sbOrderPage.state.sendKeys(givenState);
    }

    @Given("User enters {string} to zip input box")
    public void user_enters_to_zip_input_box(String givenZip) {
        sbOrderPage.zip.sendKeys(givenZip);
    }

    @Given("User selects {string} as card type from radio buttons")
    public void user_selects_as_card_type_from_radio_buttons(String givenType) {
        if (givenType.equalsIgnoreCase("Visa")){
            sbOrderPage.visaCardType.click();
        }else if (givenType.equalsIgnoreCase("MasterCard")){
            sbOrderPage.masterCardType.click();
        }else if (givenType.equalsIgnoreCase("American Express")){
            sbOrderPage.americanExpressCardType.click();
        }else{
            Assert.assertTrue("INVALID CARD TYPE!",false);
        }
    }

    @Given("User enters {string} to card number input box")
    public void user_enters_to_card_number_input_box(String givenCardNumber) {
        sbOrderPage.creditCardNumberInput.sendKeys(givenCardNumber);
    }

    @Given("User enters {string} to expiration date into input box")
    public void user_enters_to_expiration_date_into_input_box(String givenExpirationDate) {
        sbOrderPage.expirationDateInput.sendKeys(givenExpirationDate);
    }

    @Given("User clicks process button")
    public void user_clicks_process_button() {
        sbOrderPage.processButton.click();
    }

    @Then("User verifies {string} is in the table")
    public void user_verifies_is_in_the_table(String givenName) throws InterruptedException {
        sbViewAllOrdersPage.viewAllOrdersLink.click();
        Thread.sleep(3000);
        String actualName = sbViewAllOrdersPage.newOrderNameCell.getText();

        Assert.assertTrue("Names are not matching!!!", actualName.equals(givenName));
    }
}
