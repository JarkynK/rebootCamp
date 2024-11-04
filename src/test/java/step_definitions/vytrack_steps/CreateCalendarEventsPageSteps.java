package step_definitions.vytrack_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.vytrack_pages.CreateCalendarEventsPage;
import pages.vytrack_pages.DashboardsPage;
import pages.vytrack_pages.LoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CreateCalendarEventsPageSteps {

    private LoginPage lp = new LoginPage();
    private CreateCalendarEventsPage createPage = new CreateCalendarEventsPage();



    @Given("the user is signed in as a sale manager")
    public void the_user_is_signed_in_as_a_sale_manager() {
        Driver.getDriver().get(Config.getProperty("vytrackUrl"));
        lp.usernameInput.sendKeys(Config.getProperty("vytrackUsername"));
        lp.passwordInput.sendKeys(Config.getProperty("vytrackPassword"));
        lp.loginButton.click();
    }

    @When("the user is on the All Calendar Events page under the Activities tab ")
    public void the_user_is_on_the_All_Calendar_Events_page_under_the_Activities_tab() {
        DashboardsPage.navigateToModule("Activities","Calendar Events");
    }

    @When("the user is taken to the Create Calendar Events page after clicking the Create Calendar Event button")
    public void the_user_is_taken_to_the_Create_Calendar_Events_page_after_clicking_the_Create_Calendar_Event_button() {
        createPage.createCalendarEventsBtn.click();
    }

    @When("the user should see their name as the default value of of the owner field")
    public void the_user_should_see_their_name_as_the_default_value_of_of_the_owner_field() {
        String owner = createPage.ownerField.getText().trim();
        String loginUser = createPage.loginUser.getText().trim();
        Assert.assertEquals(owner,loginUser);
    }

    @When("the user should see the title field to be empty by default ")
    public void the_user_should_see_the_title_field_to_be_empty_by_default() {
        Assert.assertTrue(createPage.titleField.getAttribute("value").isEmpty());
    }

    @When("the user should see the start date field with the default value of the current date")
    public void the_user_should_see_the_start_date_field_with_the_default_value_of_the_current_date() {
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
        String actualDate = createPage.startDate.getAttribute("value");
        Assert.assertEquals(expectedDate, actualDate);
    }

    @When("the user should see the start time field with the default value of the current time ")
    public void the_user_should_see_the_start_time_field_with_the_default_value_of_the_current_time() {
        String expectedTime = LocalTime.now().minusHours(2).format(DateTimeFormatter.ofPattern("h:mm a"));
        String actualTime = createPage.startTime.getAttribute("value");
        Assert.assertEquals(expectedTime, actualTime);
    }

    ///

    @When("the user clicks on the Repeat checkbox")
    public void the_user_clicks_on_the_Repeat_checkbox() {
        createPage.repeatCheckBox.click();
    }

    @Then("the user sees the Repeats select field with the following options: Daily, Weekly, Monthly, Yearly ")
    public void the_user_sees_the_Repeats_select_field_with_the_following_options_Daily_Weekly_Monthly_Yearly() {

        List<String> actualOptions = SeleniumUtils.getAllSelectOptions(createPage.repeatSelectField);
        List <String> expectedOptions = new ArrayList<>();
        expectedOptions.add("Daily"); expectedOptions.add("Weekly"); expectedOptions.add("Monthly");
        expectedOptions.add("Yearly");

        Assert.assertEquals(expectedOptions, actualOptions);

    }

}
