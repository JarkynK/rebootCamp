package step_definitions.smartbear_stepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.smartbear_pages.SBLoginPage;
import utilities.Driver;

public class SBLogin_StepDefs {
    SBLoginPage sbLoginPage = new SBLoginPage();

    @When("User is on SmartBear login page")
    public void user_is_on_SmartBear_login_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @When("User enters correct username")
    public void user_enters_correct_username() {
        sbLoginPage.usernameInput.sendKeys("Tester");
    }

    @When("User enters correct {string}")
    public void user_enters_correct(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("User enters correct password")
    public void user_enters_correct_password() {
        sbLoginPage.passwordInput.sendKeys("test");
    }

    @When("User clicks to login button")
    public void user_clicks_to_login_button() {
        sbLoginPage.loginButton.click();
    }

    @Then("User should be logged in and be able to verify Welcome text is displayed")
    public void user_should_be_logged_in_and_be_able_to_verify_Welcome_text_is_displayed() {
        // instead of asserting welcome webelement we just assert the title
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle = "Web Orders";

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @When("User enters incorrect password")
    public void user_enters_incorrect_password() {
        sbLoginPage.passwordInput.sendKeys("wrongpassword");
    }

    @Then("User should see the error message displayed on the page")
    public void user_should_see_the_error_message_displayed_on_the_page() {
        Assert.assertTrue("Error message is not displayed! ",sbLoginPage.errorMessage.isDisplayed());
    }
}
