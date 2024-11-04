package step_definitions.amazon_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mentorings.tuesday.amazon.AmazonPage;

import java.util.Map;

public class Amazon_Stepdefs {

    AmazonPage amazonPage = new AmazonPage();


    @Given("teacher value")
    public void teacher_value(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        System.out.println(data.get("first_name"));
        System.out.println(data.get("last_name"));

    }


    @Given("I login to {string} website")
    public void iLoginToPage(String website) {
        switch (website) {
            case "amazon":
                amazonPage.navigateTo();
                break;
            default:
                break;
        }
    }

    @When("I click {string} button")
    public void iClickButton(String buttonName) {
        switch (buttonName) {
            case "hamburger menu":
                amazonPage.clickHamburgerMenu();
                break;
            default:
                break;
        }
    }

    @Then("I validate size of categories")
    public void iValidateSizeOfCategories() {
        amazonPage.validateCategoriesSize();
    }
}
