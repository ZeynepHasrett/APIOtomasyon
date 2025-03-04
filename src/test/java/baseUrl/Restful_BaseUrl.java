package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class Restful_BaseUrl {

    protected RequestSpecification specRestful;

    @BeforeTest
    public void setup(){

        specRestful = new RequestSpecBuilder()
                                            .setBaseUri("https://restful-booker.herokuapp.com")
                                            .build();

    }

}
