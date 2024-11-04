package step_definitions.etsy_stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.etsy_pages.Etsy_HomePage;
import utilities.Config;
import utilities.Driver;

public class EtsySearch_StepDefs {

    Etsy_HomePage etsy_homePage = new Etsy_HomePage();
    WebDriver driver = Driver.getDriver();

    @Given("User is on Etsy home page")
    public void user_is_on_Etsy_home_page() {
        driver.get(Config.getProperty("etsyURL"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        //use the object to sendKeys into searchBox
        etsy_homePage.searchBox.sendKeys("wooden spoon" + Keys.ENTER);
    }

    @Then("User should see wooden spoon in the Etsy title")
    public void user_should_see_wooden_spoon_in_the_Etsy_title() {
        //compare actual title vs expected title
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "Wooden spoon";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    @When("User searches for {string}")
    public void user_searches_for(String searchValue) {
        etsy_homePage.searchBox.sendKeys(searchValue + Keys.ENTER);

    }

    @Then("User should see {string} in the Etsy title")
    public void user_should_see_in_the_Etsy_title(String searchValue) {
        //compare actual title vs expected title
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

}
