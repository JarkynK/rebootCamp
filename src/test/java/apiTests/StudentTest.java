package apiTests;

import ApiModels.ResponseBody;
import ApiModels.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class StudentTest {

    @Test
    public void jobFoundTest() throws Exception{
        Response response = RestAssured.get("http://api.cybertektraining.com/student/all");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);

        int counter = 0;
        for(Student student: responseBody.getStudents()){

            if(student.getCompany().getStartDate().endsWith("2020")){
                System.out.println(student.getFirstName());
                counter++;
            }
        }
        System.out.println("\nCount: " + counter);
    }
}
