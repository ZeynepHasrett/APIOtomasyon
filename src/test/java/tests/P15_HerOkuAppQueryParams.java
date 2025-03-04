package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P15_HerOkuAppQueryParams extends Restful_BaseUrl {

    /*
            https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
            donen response’un status code’unun 200 oldugunu
            ve Response’ta 1134 id'ye sahip bir booking oldugunu test edin.
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
                .body("bookingid", Matchers.hasItem(1134));

    }


    /*
           https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
           "firstname" degeri "Josh" ve "lastname" degeri "Allen" olan rezervasyon oldugunu
           test edecek bir GET request gonderdigimizde,
           donen response'un status code'unun 200 oldugunu ve
           "Josh Allen" ismine sahip en az bir booking oldugunu test edin.
    */

    @Test
    public void get02(){

        specRestful.pathParam("pp1", "booking").queryParams("firstname", "Josh", "lastname", "Allen");

        Response response = given().spec(specRestful).when().get("/{pp1}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThan(0));

    }

}
