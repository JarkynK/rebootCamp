package step_definitions.google_steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.google_pages.GoogleLandingPage;
import utilities.Driver;

public class Google_StepDefs {

    GoogleLandingPage googleLandingPage = new GoogleLandingPage();

    @When("User is on google homepage")
    public void user_is_on_google_homepage() {
        //1- get the google page
        getDriver().get("https://google.com");
    }

    @Then("User should see title contains Google")
    public void user_should_see_title_contains_Google() {
        //2- compare the actual title vs expected title
        String actualTitle = getDriver().getTitle();
        String expectedInTitle = "google";

        Assert.assertTrue("Title does not contain expected value!",
                actualTitle.contains(expectedInTitle));

    }

    private WebDriver getDriver() {
        return Driver.getDriver();
    }

    @When("User clicks to search button")
    public void user_clicks_to_search_button() {
        //googleLandingPage.searchButton.click();
        //   Assert.assertTrue("FAILING ON PURPOSE!!! ",false);

    }

    @Then("User should see {string} in the title")
    public void user_should_see_wooden_spoon_in_the_title(String criteria) {
        String actualTitle = getDriver().getTitle();
        String expectedInTitle = "wooden spoon";

        Assert.assertTrue("Title does not contain expected value!",
                actualTitle.contains(expectedInTitle));

    }

    @When("User types {string} into the search box")
    public void user_types_wooden_spoon_into_the_search_box(String criteria) {
        googleLandingPage
                .searchBox
                .sendKeys("wooden spoon" + Keys.ENTER);
    }
}
