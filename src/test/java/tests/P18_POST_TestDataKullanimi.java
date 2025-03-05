package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.RestfulTestDatas;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P18_POST_TestDataKullanimi extends Restful_BaseUrl {

    /*
        https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip
        bir POST request gonderdigimizde donen response'un
        id haric asagidaki gibi oldugunu test edin.

            Request body
               {
                   "firstname" : "Ahmet",
                   "lastname" : "Bulut",
                   "totalprice" : 500,
                   "depositpaid" : false,
                   "bookingdates" : {
                       "checkin" : "2021-06-01",
                       "checkout" : "2021-06-10"
                   },
                   "additionalneeds" : "wi-fi"
               }

            Response Body
                {
                    "bookingid": 24,
                    "booking": {
                        "firstname": "Ahmet",
                        "lastname": "Bulut",
                        "totalprice": 500,
                        "depositpaid": false,
                        "bookingdates": {
                            "checkin": "2021-06-01",
                            "checkout": "2021-06-10"
                        },
                        "additionalneeds": "wi-fi"
                    }
                }
         */

    @Test
    public void post01(){

        specRestful.pathParam("pp1", "booking");

        JSONObject reqBody = RestfulTestDatas.requestBodyOlusturJSON();

        JSONObject expData = RestfulTestDatas.expectedBodyOlusturJSON();

        Response response = given()
                                .spec(specRestful)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .post("/{pp1}");

        response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        assertEquals(respJP.get("booking.firstname"), expData.getJSONObject("booking").get("firstname"));
        assertEquals(respJP.get("booking.lastname"), expData.getJSONObject("booking").get("lastname"));
        assertEquals(respJP.get("booking.totalprice"), expData.getJSONObject("booking").get("totalprice"));
        assertEquals(respJP.get("booking.depositpaid"), expData.getJSONObject("booking").get("depositpaid"));
        assertEquals(respJP.get("booking.bookingdates.checkin"), expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        assertEquals(respJP.get("booking.bookingdates.checkout"), expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));
        assertEquals(respJP.get("booking.additionalneeds"), expData.getJSONObject("booking").get("additionalneeds"));

    }

}
