package specs;

import config.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ApiConfig.BASE_URL)
                .setContentType(ApiConfig.CONTENT_TYPE)
                .setAccept(ApiConfig.ACCEPT)
                .build();
    }
}
