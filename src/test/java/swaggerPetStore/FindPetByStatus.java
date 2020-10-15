package swaggerPetStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FindPetByStatus {
    @BeforeClass
    public static void setBaseUri() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    } // end of BeforeClass method

    @Test
    public void findPetsByStatus() throws JSONException {
        Response response = given().queryParam("status", "available")
                .when().get("/pet/findByStatus")
                .then().assertThat()
                .contentType(ContentType.JSON)
                .and().statusCode(200).extract().response();
        // response.prettyPrint();
        // Fetching response in JSON
        JSONArray jsonArray = new JSONArray(response.asString());
        int count = 0;
        // Printing all the elements of the JSONArray
        System.out.println("All the pets available named doggie: ");
        for (int i = 0; i < jsonArray.length(); i++) {
                String petName = jsonArray.getJSONObject(i).getString("name");
                if (petName.equals("doggie")) {
                    System.out.print(petName + ", ");
                    count++;
                }
            }
        System.out.println("\nNo. of pets available named doggie = " + count);
    } // end of Test method
} // end of class
