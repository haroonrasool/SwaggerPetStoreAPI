package swaggerPetStore;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDrivenTesting extends TestingData {

    @Test(dataProvider = "DataForPost")
    public void post(String firstName, String lastName, int subjectID) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("subjectID", subjectID);
        baseURI = "http://localhost:3000/";
        given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
                .body(jsonObject.toJSONString())
                .when().post("/users")
                .then().statusCode(201).log().all();
    }

    @Test(dataProvider = "DeleteData")
    public void delete(int userID) {
        baseURI = "http://localhost:3000/";
        given().when().delete("/users/" + userID).then().statusCode(200).log().all();
    }

    @Parameters({"userID"})
    @Test
    public void delete2(int userID) {
        baseURI = "http://localhost:3000/";
        given().when().delete("/users/" + userID).then().statusCode(200).log().all();
    }
}
