package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P14_RestfulPOST extends Restful_BaseUrl {

    /*
            https://restful-booker.herokuapp.com/booking endpointine
            asagidaki body'ye sahip bir POST request gonderdigimizde donen response'un

            status code'unun 200 oldugunu
            ve "firstname" degerinin "Murat" oldugunu test edin

                {
                     "firstname" : "Murat",
                     "lastname" : "Yiğit",
                     "totalprice" : 500,
                     "depositpaid" : false,
                     "bookingdates" : {
                              "checkin" : "2021-06-01",
                              "checkout" : "2021-06-10"
                                       },
                     "additionalneeds" : "wi-fi"
                  }
     */

    @Test
    public void post01(){

        specRestful.pathParam("pp1", "booking");

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Murat");
        reqBody.put("lastname", "Yiğit");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingDates);
        reqBody.put("additionalneeds", "wi-fi");

        Response response = given()
                                .spec(specRestful).contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .post("/{pp1}");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Murat"));

    }

}
