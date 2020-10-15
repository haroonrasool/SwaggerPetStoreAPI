package swaggerPetStore;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqResTest {
    @Test
    public void Test() {
        String url = "https://reqres.in/api/users?pag=2";
        given().header("Content-Type", "application/json").
                when().get(url).
                then().statusCode(200).
                body("data.id[1]", equalTo(2)).
                body("data.first_name", hasItems("George", "Janet", "Emma", "Eve", "Charles", "Tracey")).
                body("ad.company", is("StatusCode Weekly")).
                log().all();
    }
}
