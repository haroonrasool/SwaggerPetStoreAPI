package swaggerPetStore;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ParsingJSONResponse {
    @Test
    public void parsingJSONResponse() {
        Response response = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when().get("https://jsonplaceholder.typicode.com/users")
                .then().contentType(ContentType.JSON).extract().response();
//        response.prettyPrint();
        List<String> jsonResponse = response.jsonPath().getList("$"); // Note the $ notation which means the root element.
        System.out.println("Total No. of records available: " + jsonResponse.size());
        // Parsing JSON Arrays and Lists
        String userNames = response.jsonPath().getString("username");
        System.out.println("User Names: " + userNames);
        // If we then want to get the username of the first entry we could use:
        String usernames = response.jsonPath().getString("username[0]");
        // Using a List we can use:
        List<String> jsonResponse2 = response.jsonPath().getList("username");
        System.out.println("First User Name: " + jsonResponse2.get(0));
        // Parsing JSON ArrayList and HashMap
        List<Map<String, String>> company = response.jsonPath().getList("company");
        System.out.println(company.get(0).get("name"));
//        String userNames = response.jsonPath().getString("username");
//        System.out.println(userNames);
//        for (String variable : jsonResponse){
//            System.out.println(userNames);
//        }
    }
}
