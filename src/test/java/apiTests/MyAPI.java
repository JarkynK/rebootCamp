package apiTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class MyAPI {


    @Test
    public void getTeachersList(){
        // Step 1. Hit API
        // HTTP method, Endpoint, Body, Header
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/1807");

        System.out.println(response.statusCode());
        System.out.println(response.asString());

        JsonPath jp = response.jsonPath();
        String firstName = jp.get("teachers[0].firstName");
        System.out.println(firstName);
        Assert.assertTrue(firstName != null);

    }

    @Test
    public void allTeachersAttributeVerification(){
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");

        Assert.assertEquals("API Server down", 200, response.statusCode());
        System.out.println(response.asString());
        JsonPath jp = response.jsonPath();

        int size = jp.getList("teachers").size();
        System.out.println(size);

        // teachers[].firstName


        for(int i = 0; i< size; i++){
            String pathName = "teachers[" + i + "].firstName";
            String pathEmail = "teachers[" + i + "].emailAddress";
            String name = jp.get(pathName);
            String email = jp.get(pathEmail);

            Assert.assertTrue(name != null);
            Assert.assertTrue(email != null);
        }

    }


}
