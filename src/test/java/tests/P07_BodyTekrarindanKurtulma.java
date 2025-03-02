package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P07_BodyTekrarindanKurtulma {

    /*
            https://restful-booker.herokuapp.com/booking/10 url'ine
            bir GET request gonderdigimizde donen Response'un,

                status code'unun 200,
                ve content type'inin application/json; charset=utf-8,
                ve response body'sindeki
                   "firstname"in, "Doc James",
                ve "lastname"in, "Brown",
                ve "totalprice"in, 111,
                ve "depositpaid"in, true,
                ve "additionalneeds"in, "Breakfast"

           oldugunu test edin.
    */

    @Test
    public void get01(){

        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

        response.then().assertThat()
                                    .statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .body("firstname", equalTo("Doc James"),
                                            "lastname", equalTo("Brown"),
                                            "totalprice", equalTo(111),
                                            "depositpaid", equalTo(true),
                                            "additionalneeds", equalTo("Breakfast"));

    }

}
