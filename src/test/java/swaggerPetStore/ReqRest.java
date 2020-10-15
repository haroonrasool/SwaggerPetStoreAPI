package swaggerPetStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqRest {
    @BeforeClass
    public static void setBaseUri() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    public void findPetsByStatus() {
        Response response = given().param("page", "2")
                .when().get("/api/users")
                .then().assertThat().contentType(ContentType.JSON)
                .and().statusCode(200).extract().response();

        List<Object> ids = response.jsonPath().getList("data.id");
        for (Object i : ids) {
            System.out.println(i);
        }
    }
}
