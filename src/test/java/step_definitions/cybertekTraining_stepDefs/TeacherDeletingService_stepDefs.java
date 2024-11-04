package step_definitions.cybertekTraining_stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.APIUtil;

public class TeacherDeletingService_stepDefs {

    @Given("user deletes teacher at {string}")
    public void user_deletes_teacher_at(String resource) {
        APIUtil.hitDELETE(resource);
    }

    @Given("user gets teacher at {string}")
    public void user_gets_teacher_at(String resource) {
        APIUtil.hitGET(resource);
    }

    @Then("user verifies response message with {string}")
    public void user_verifies_response_message_with(String expectedMessage) {
        String message = APIUtil.getResponseBody().getMessage();
        Assert.assertEquals("Delete teacher failed", expectedMessage, message);
    }
}
