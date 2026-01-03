package clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AccountsClient extends BaseClient {

    public Response getAccountIdRaw(int accountId){
        return given()
                .spec(spec)
                .pathParam("accountId",accountId)
                .when()
                .get("/accounts/{accountId}");
    }
}
