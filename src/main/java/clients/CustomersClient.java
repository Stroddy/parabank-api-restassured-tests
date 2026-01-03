package clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CustomersClient extends BaseClient {

    public Response getCustomerRaw(int customerId){
        return given()
                .spec(spec)
                .pathParam("customerId",customerId)
                .when()
                .get("/customers/{customerId}");
    }

    public Response getCustomerPositionRaw(int customerId){
        return given()
                .spec(spec)
                .pathParam("customerId",customerId)
                .when()
                .get("/customers/{customerId}/positions");
    }

    public Response getCustomerAccountsRaw(int customerId){
        return given()
                .spec(spec)
                .pathParam("customerId",customerId)
                .when()
                .get("/customers/{customerId}/accounts");

    }

}
