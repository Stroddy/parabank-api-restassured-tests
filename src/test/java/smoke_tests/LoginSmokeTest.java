package smoke_tests;

import clients.AccountsClient;
import clients.AuthClient;
import clients.CustomersClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.AuthCredentials;

import static org.junit.jupiter.api.Assertions.*;


public class LoginSmokeTest {
    // Login
    @Test
    void login_ShouldReturnCustomer() {
        AuthClient authClient = new AuthClient();
        Response response = authClient.loginRaw(
                AuthCredentials.username(),
                AuthCredentials.password()
        );
        assertEquals(200, response.statusCode());

        // Get customerId
        int customerId = response.jsonPath().getInt("id");
        assertTrue(customerId > 0);

        // Get Customer Details
        CustomersClient customersClient = new CustomersClient();
        Response customerResponse = customersClient.getCustomerRaw(customerId);
        assertEquals(200, customerResponse.statusCode());

        // Get customer Accounts list
        Response customersAccResponse = customersClient.getCustomerAccountsRaw(customerId);
        int size = customersAccResponse.jsonPath().getList("$").size();
        assertEquals(200,customersAccResponse.statusCode());
        assertTrue(size>0);

        // Get accountId from a List
        int accountId= customersAccResponse.jsonPath().getInt("[0].id");
        assertTrue(accountId>0);

        // Get Account by ID (by accountId)
        AccountsClient accountsClient = new AccountsClient();
        Response accountResponse = accountsClient.getAccountIdRaw(accountId);
        assertEquals(200,accountResponse.statusCode());
        assertEquals(accountId,accountResponse.jsonPath().getInt("id"));
        assertEquals(customerId,accountResponse.jsonPath().getInt("customerId"));
        assertNotNull(accountResponse.jsonPath().get("balance"));;
    }
}
