package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class P10_POST_ExpectedDataSoftAssert {

    /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body’ye sahip bir POST request gonderdigimizde

            Request body
                  {
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

        donen response’un id haric asagidaki gibi oldugunu test edin.

            Response Body - Expected Data
             {
                “bookingid”: 24,
                “booking”: {
                    "firstname": "Ahmet",
                    "lastname": "Bulut",
                    "totalprice": 500,
                    "depositpaid": false,
                    "bookingdates": {
                        "checkin": "2021-06-01",
                        "checkout": "2021-06-10"
                    },
                    additionalneeds": "wi-fi"
                }
            }
    */

    @Test
    public static void post01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingDates);
        reqBody.put("additionalneeds", "wi-fi");

        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("booking", reqBody);

        Response response = given()
                                    .contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody.toString())
                                    .post(url);

        response.prettyPrint();

        SoftAssert softAssert = new SoftAssert();

        JsonPath respJP = response.jsonPath();

        softAssert.assertEquals(respJP.get("booking.firstname"), expData.getJSONObject("booking").get("firstname"));
        softAssert.assertEquals(respJP.get("booking.lastname"), expData.getJSONObject("booking").get("lastname"));
        softAssert.assertEquals(respJP.get("booking.totalprice"), expData.getJSONObject("booking").get("totalprice"));
        softAssert.assertEquals(respJP.get("booking.depositpaid"), expData.getJSONObject("booking").get("depositpaid"));
        softAssert.assertEquals(respJP.get("booking.additionalneeds"), expData.getJSONObject("booking").get("additionalneeds"));
        softAssert.assertEquals(respJP.get("booking.bookingdates.checkin"), expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        softAssert.assertEquals(respJP.get("booking.bookingdates.checkout"), expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"));

        softAssert.assertAll();

    }
}
