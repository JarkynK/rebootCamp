package apiTests;

import ApiModels.ResponseBody;
import ApiModels.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

public class TeacherAPI {

    @Test
    public void departmentNameTest(){
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/department/Computer");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        JsonPath jsonPath = response.jsonPath();
        int size = jsonPath.getList("teachers").size();

        for(int i = 0; i < size; i++){
            String path = "teachers[" + i + "].department";
            String department = jsonPath.get(path);
            System.out.println(department);
            Assert.assertEquals("Department failed at: " + i, "Computer", department);
        }
    }


    @Test
    public void emailValidationTeacherAPI() throws Exception{
        Response response = RestAssured.get(Config.getProperty("baseURL") + "/teacher/all");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        Assert.assertEquals("List of Teachers API failed", 200, response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        ResponseBody rb =  objectMapper.readValue(response.asString(), ResponseBody.class);

        System.out.println(rb.getTeachers().size());

        for(int i = 0; i < rb.getTeachers().size(); i++){
            String email = rb.getTeachers().get(i).getEmailAddress();
            if(email.contains("@") && email.contains(".")){
                continue;
            }
            System.out.println(email);
        }


    }


    @Test
    public void createTeacherTest() throws Exception{
        Teacher teacher = new Teacher();
        teacher.setEmailAddress("jb2020@gmail.com");
        teacher.setFirstName("James");
        teacher.setLastName("Bond");
        teacher.setJoinDate("01/02/2031");
        teacher.setSalary(50000);
        teacher.setBatch(14);
        teacher.setBirthDate("01/01/1995");
        teacher.setGender("Male");
        teacher.setPassword("jb123");
        teacher.setPhone("2342-52324");
        teacher.setPremanentAddress("123 main street");
        teacher.setSection("Whatever");
        teacher.setSubject("Intro to Swimming");
        teacher.setDepartment("Sports");

        ObjectMapper objectMapper = new ObjectMapper();
        String teacherJson = objectMapper.writeValueAsString(teacher);
        System.out.println(teacherJson);

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(teacherJson).when().post(Config.getProperty("baseURL") + "/teacher/create");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }

    @Test
    public void updateTeacherTest() throws Exception{
        Teacher teacher = new Teacher();
        teacher.setEmailAddress("jb2020@gmail.com");
        teacher.setFirstName("Justin");
        teacher.setLastName("Bieber");
        teacher.setJoinDate("01/02/2031");
        teacher.setSalary(50000);
        teacher.setBatch(14);
        teacher.setBirthDate("01/01/1995");
        teacher.setGender("Male");
        teacher.setPassword("jb123");
        teacher.setPhone("2342-52324");
        teacher.setPremanentAddress("123 main street");
        teacher.setSection("Whatever");
        teacher.setSubject("Intro to Swimming");
        teacher.setDepartment("Sports");
        teacher.setTeacherId(2192);

        ObjectMapper objectMapper = new ObjectMapper();
        String teacherJson = objectMapper.writeValueAsString(teacher);
        System.out.println(teacherJson);

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(teacherJson).put(Config.getProperty("baseURL") + "/teacher/update");

        System.out.println(response.statusCode());
        System.out.println(response.asString());


    }


}

















