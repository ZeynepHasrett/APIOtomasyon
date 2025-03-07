package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class ReqresBaseUrl {

    protected RequestSpecification specReqresBaseUrl;

    @BeforeTest
    public void setup(){

        specReqresBaseUrl = new RequestSpecBuilder()
                                    .setBaseUri("https://reqres.in")
                                    .build();

    }

}
