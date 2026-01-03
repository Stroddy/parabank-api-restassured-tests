package clients;

import io.restassured.specification.RequestSpecification;
import specs.RequestSpecFactory;

public abstract class BaseClient {

    protected final RequestSpecification spec;

    protected BaseClient(){
    this.spec=RequestSpecFactory.defaultSpec();
    }
}
