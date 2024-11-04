package apiTests;

import ApiModels.RequestBody;
import ApiModels.Student;
import ApiModels.Teacher;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIUtil;

public class UtilTesting {

    @Test
    public void teacherTesting(){
        String resource = "/teacher/2192";

        APIUtil.hitGET(resource);

        System.out.println(APIUtil.getResponseBody().getTeachers().get(0).getFirstName());

        // APIUtil.getResponseBody() ==> ResponseBody object
    }

    @Test
    public void allTeacherTest(){
        APIUtil.hitGET("/teacher/all");

        for(Teacher t: APIUtil.getResponseBody().getTeachers()){
            if(t.getGender().equalsIgnoreCase("female")){
                System.out.println(t.getFirstName());
            }
        }
    }

    @Test
    public void batchTesting(){
        APIUtil.hitGET("/student/all");

        int index = 0;

        for(Student s: APIUtil.getResponseBody().getStudents()){
            if(s.getBatch() >= 7 && s.getBatch() <= 14){
                index++;
                continue;
            }
            Assert.fail("Student Batch Failed at: " + index);
        }
    }


    @Test
    public void postTesting(){
        RequestBody teacher = new RequestBody();
        teacher.setEmailAddress("new@gmail.com");
        teacher.setFirstName("Tim");
        teacher.setLastName("Ronaldo");
        teacher.setJoinDate("01/02/2003");
        teacher.setSalary(5004);
        teacher.setBatch(12);
        teacher.setBirthDate("01/01/1987");
        teacher.setGender("Male");
        teacher.setPassword("jb123");
        teacher.setPhone("2342-23423413");
        teacher.setPremanentAddress("32 main street");
        teacher.setSection("OK");
        teacher.setSubject("Coding");
        teacher.setDepartment("CS");

        APIUtil.hitPOST("/teacher/create", teacher);

    }

    @Test
    public void deleteTesting(){
        String resource = "/teacher/delete/1928";
        APIUtil.hitDELETE(resource);
    }

    @Test
    public void updateTesting(){
        String resource = "/teacher/update";

        RequestBody requestBody = new RequestBody();
        requestBody.setEmailAddress("new@gmail.com");
        requestBody.setFirstName("Tim");
        requestBody.setLastName("Ronaldo");
        requestBody.setJoinDate("01/02/2003");
        requestBody.setSalary(5004);
        requestBody.setBatch(12);
        requestBody.setBirthDate("01/01/1987");
        requestBody.setGender("Male");
        requestBody.setPassword("jb123");
        requestBody.setPhone("2342-23423413");
        requestBody.setPremanentAddress("32 main street");
        requestBody.setSection("OK");
        requestBody.setSubject("Coding");
        requestBody.setDepartment("CS");
        requestBody.setTeacherId(2708);

        APIUtil.hitPUT(resource, requestBody);
    }

    @Test
    public void authentification(){
        // Basic authentification
        // username: cbt1 pass: admin2020
        Response response = RestAssured.given().header("token", "admin2020").get("http://api.cybertektraining.com/teacher/all");
        System.out.println(response.asString());

    }

}












