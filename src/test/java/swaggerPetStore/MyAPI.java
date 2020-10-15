package swaggerPetStore;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyAPI {
    @Test
    public void users() {
        baseURI = "http://localhost:3000/";
        given().param("name", "Automation").get("/users")
                .then().statusCode(200).log().all();
    }

    @Test
    public void subjects() {
        baseURI = "http://localhost:3000/";
        given().param("name", "Automation").get("/subjects")
                .then().statusCode(200).log().all();
    }

    @Test
    public void post() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Tom");
        jsonObject.put("lastName", "Cruise");
        jsonObject.put("subjectID", 1);
        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when().post("/users")
                .then().statusCode(201).log().all();
    }

    @Test
    public void put() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Mary");
        jsonObject.put("lastName", "Jane");
        jsonObject.put("subjectID", 1);
        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when().put("/users/4")
                .then().statusCode(200).log().all();
    }

    @Test
    public void delete() {
        baseURI = "http://localhost:3000/";
        given().when().delete("/users/7").then().statusCode(200).log().all();
    }
}
