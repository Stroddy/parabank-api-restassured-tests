package clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseClient {
        // ===== RAW =====
    public Response loginRaw (String username,String password){
        return given()
                .spec(spec)
                .pathParam("username",username)
                .pathParam("password",password)
                .when()
                .get("/login/{username}/{password}");
    }

}
