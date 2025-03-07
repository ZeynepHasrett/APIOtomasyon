package recap;

import baseUrl.OpenWeatherBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class P07_GET_OpenWeather extends OpenWeatherBaseUrl {

    /*
            Endpoint: https://api.openweathermap.org/data/2.5/weather?q=Istanbul&appid=YOUR_API_KEY
            HTTP Metodu: GET

            Senaryo:
            Bu endpoint'e bir GET request gönderdiğimizde dönen Response’un:

                Status code’unun 200,
                Content-Type’ının application/json; charset=utf-8,
                Response Body’sinde "name" alanının "Istanbul" olduğunu,
                Response Body’sinde "main.temp" değerinin -50 ile 50 arasında olmadığını test ediniz.
     */

    String myApiKey = "59cab9d7b63528c4269e6c57fed1c85e";

    @Test
    public void get01(){

        specOpenWeatherBaseUrl.pathParams("pp1", "data", "pp2", "2.5", "pp3", "weather")
                                .queryParams("q", "Istanbul", "appid", myApiKey);

        Response response = given()
                                .spec(specOpenWeatherBaseUrl)
                            .when()
                                .get("/{pp1}/{pp2}/{pp3}");

        JsonPath respJP = response.jsonPath();

        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8");

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        assertEquals(respJP.get("name"), "Istanbul");
        assertFalse(respJP.getDouble("main.temp") > -50 && respJP.getDouble("main.temp") < 50);

    }

}
