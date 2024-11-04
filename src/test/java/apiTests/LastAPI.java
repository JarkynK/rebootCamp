package apiTests;

import org.junit.Assert;
import org.junit.Test;
import utilities.APIUtil;

public class LastAPI {

    @Test
    public void teacherDeletePositive(){
        String resourceForDelete = "/teacher/delete/2708";
        APIUtil.hitDELETE(resourceForDelete);

        String resourceForGet = "/teacher/2708";
        APIUtil.hitGET(resourceForGet);

        String message = APIUtil.getResponseBody().getMessage();

        System.out.println(message);

    }

    @Test
    public void teacherDeleteNegative(){
        String resource = "/teacher/delete/273458";
        APIUtil.hitDELETE(resource);

        String message = APIUtil.getResponseBody().getMessage();
        System.out.println(message);
        String expectedMessage = "Teacher with id = 273458 NOT FOUND!";
        Assert.assertEquals("Delete teacher negative scenario failed", expectedMessage, message);

    }
}
