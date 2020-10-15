package swaggerPetStore;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReqResPUT {
    @Test
    public void put() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Aftab");
        map.put("job", "Teacher");
        System.out.println(map);
        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
        System.out.println(jsonObject.toJSONString());
        String url = "https://reqres.in/api/users";
        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonObject.toJSONString()).when().post(url)
                .then().statusCode(201).log().all();
    }
}