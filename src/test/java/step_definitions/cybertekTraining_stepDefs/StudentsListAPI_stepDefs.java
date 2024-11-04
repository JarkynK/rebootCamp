package step_definitions.cybertekTraining_stepDefs;

import ApiModels.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.cybertekTraning_pages.CBTHomepage;
import utilities.APIUtil;

import java.util.Map;

public class StudentsListAPI_stepDefs {

    CBTHomepage cbtHomepage = new CBTHomepage();


    @Given("user gets students list with {string}")
    public void user_gets_students_list_with(String resource) {

        APIUtil.hitGET(resource);
    }

    @Given("user validates data from response by batch number {string}")
    public void user_validates_data_from_response_by_batch_number(String batchID) {
        for(Student student: APIUtil.getResponseBody().getStudents()){
            String batchIDactual = student.getBatch()+"";
            Assert.assertEquals("Student Batch ID failed", batchID, batchIDactual);
        }
    }

    @Given("user deletes student with {string}")
    public void user_deletes_student_with(String resource) {
        APIUtil.hitDELETE(resource);
    }

    @Then("user searches for student with student ID {string}")
    public void user_searches_for_student_with_student_ID(String studentID) throws Exception{
        cbtHomepage.studentsDropdown.click();
        cbtHomepage.allStudentsLink.click();
        Thread.sleep(500);
        cbtHomepage.searchStudentById.sendKeys(studentID);
        cbtHomepage.searchBtn.click();
    }

    @Then("user verifies that no result should show")
    public void user_verifies_that_no_result_should_show() {
        Assert.assertEquals("Deleting student failed", 0, cbtHomepage.searchResultsName.size());
    }


    @Given("user creates student with following data {string}")
    public void user_creates_student_with_following_data(String resource, io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        RequestBody student = new RequestBody();

        student.setFirstName(data.get("firstName"));
        student.setLastName(data.get("lastName"));
        student.setMajor(data.get("major"));
        student.setSubject(data.get("subject"));
        student.setAdmissionNo(data.get("admissionNo"));
        student.setBatch(Integer.parseInt(data.get("batch")));
        student.setGender(data.get("gender"));
        student.setBirthDate(data.get("birthDate"));
        student.setJoinDate(data.get("joinDate"));
        student.setPassword(data.get("password"));
        student.setSection(data.get("section"));

        Contact contact=new Contact();
        contact.setPhone(data.get("phone"));
        contact.setEmailAddress(data.get("emailAddress"));
        contact.setPremanentAddress(data.get("premanentAddress"));

        Company company=new Company();
        company.setCompanyName(data.get("companyName"));
        company.setStartDate(data.get("startDate"));
        company.setTitle(data.get("title"));

        Address address=new Address();
        address.setStreet(data.get("street"));
        address.setCity(data.get("city"));
        address.setState(data.get("state"));
        address.setZipCode(Integer.parseInt(data.get("zipCode")));

        company.setAddress(address);

        student.setContact(contact);
        student.setCompany(company);

        APIUtil.hitPOST(resource, student);

    }

    @Then("user searches for student with newly created student ID")
    public void user_searches_for_student_with_newly_created_student_ID() throws Exception {
        cbtHomepage.studentsDropdown.click();
        cbtHomepage.allStudentsLink.click();
        Thread.sleep(500);
        String studentID = APIUtil.getResponseBody().getStudentId() + "";
        cbtHomepage.searchStudentById.sendKeys(studentID);
        cbtHomepage.searchBtn.click();
    }

    @Then("user verifies that student is created")
    public void user_verifies_that_student_is_created() {
        Assert.assertEquals("Student creation failed", 1, cbtHomepage.searchResultsName.size());
        String name = cbtHomepage.searchResultsName.get(0).getText();
        System.out.println(name);
    }


}
