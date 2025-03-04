package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P13_RestfulBaseUrl extends Restful_BaseUrl {

     /*
         https://restful-booker.herokuapp.com/booking endpointine
         bir GET request gonderdigimizde donen response'un
             status code'unun 200 oldugunu ve
             Response'ta 12 booking id'sine sahip booking oldugunu test edin
    */

    @Test
    public void get01(){

        specRestful.pathParam("pp1", "booking");

        Response response = given().spec(specRestful).when().get("/{pp1}");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasItem(12));

    }

}
