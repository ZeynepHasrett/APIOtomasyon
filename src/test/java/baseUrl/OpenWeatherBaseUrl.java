package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class OpenWeatherBaseUrl {

    protected RequestSpecification specOpenWeatherBaseUrl;

    @BeforeTest
    public void setup(){

        specOpenWeatherBaseUrl = new RequestSpecBuilder()
                                            .setBaseUri("https://api.openweathermap.org")
                                            .build();

    }

}
