package swaggerPetStore;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class WeatherAPI {
    @BeforeClass
    public static void setBaseUri() {
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city/";
    }

    @Test
    public void weather() {
        Response response = given().when().get("/Hyderabad");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.getBody().asString()); // or response.prettyPrint();
    }

    public static HashMap<String, String> hashMap = new HashMap<String, String>();

    @Test
    public void register() {
        hashMap.put("FirstName", "Haroon");
        hashMap.put("LastName", "Rasool");
        hashMap.put("UserName", "haroon.rasool");
        hashMap.put("Email", "haroon@gmail.com");
        RestAssured.baseURI = "http://restapi.demoqa.com/customer/";
        RestAssured.basePath = "/register";
    }

    @Test
    public void testPost() {
        ValidatableResponse body = given().contentType("application/json").body(hashMap)
                .when().post()
                .then().statusCode(405).and()
                .body("SuccessCode", equalTo(null))
                .body("Message", equalTo(null));
    }
}
