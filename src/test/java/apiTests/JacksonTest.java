package apiTests;

import ApiModels.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class JacksonTest {

    @Test
    public void jackson() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setEmailAddress("gson@gmail.com");
        teacher.setFirstName("Jennifer");
        teacher.setJoinDate("03/15/2020");
        teacher.setSalary(500);

        Subject subject = new Subject();
        subject.setBatch(14);
        subject.setName("Automation");
        subject.setYear(2020);


        ObjectMapper objectMapper = new ObjectMapper();
        String teacherJson = objectMapper.writeValueAsString(teacher);

        System.out.println(teacherJson);


    }

    @Test
    public void studentTest() throws Exception{
        Company company = new Company();
        Address address = new Address();
        address.setCity("Chicago");
        address.setState("IL");
        address.setZipCode(60018);
        company.setAddress(address);
        company.setCompanyName("Chase");
        company.setStartDate("03/16/2020");
        company.setTitle("Engineer");
        Contact contact = new Contact();
        contact.setEmailAddress("test@gmail.com");
        contact.setPhone("79238290");
        Student student = new Student();
        student.setFirstName("Jamie");
        student.setLastName("Vardy");
        student.setCompany(company);
        student.setContact(contact);

        ObjectMapper objectMapper = new ObjectMapper();
        String studentJSON = objectMapper.writeValueAsString(student);

        System.out.println(studentJSON);

    }

    @Test
    public void studentGet() throws Exception {
        Response response = RestAssured.get("http://api.cybertektraining.com/student/6842");

        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);

        String fName = rb.getStudents().get(0).getFirstName();

        System.out.println(fName);

    }
}












