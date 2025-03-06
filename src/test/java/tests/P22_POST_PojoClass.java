package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.RestfulBookingDatesPOJO;
import pojo.RestfulExpBodyPOJO;
import pojo.RestfulReqBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P22_POST_PojoClass extends Restful_BaseUrl{

    /*
        https://restful-booker.herokuapp.com/booking url'ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response'un id haric asagidaki gibi oldugunu test edin.

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

            Response Body // expected data

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

        RestfulBookingDatesPOJO bookingdates = new RestfulBookingDatesPOJO("2021-06-01", "2021-06-10");

        RestfulReqBodyPOJO reqBody = new RestfulReqBodyPOJO("Ahmet", "Bulut", 500, false, bookingdates, "wi-fi");

        RestfulExpBodyPOJO expbody = new RestfulExpBodyPOJO(24, reqBody);

        Response response = given()
                                .spec(specRestful)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .post("/{pp1}");

        RestfulExpBodyPOJO respPojo = response.as(RestfulExpBodyPOJO.class);

        // System.out.println(respPojo);

        assertEquals(respPojo.getBooking().getFirstname(), expbody.getBooking().getFirstname());
        assertEquals(respPojo.getBooking().getLastname(), expbody.getBooking().getLastname());
        assertEquals(respPojo.getBooking().getTotalprice(), expbody.getBooking().getTotalprice());
        assertEquals(respPojo.getBooking().isDepositpaid(), expbody.getBooking().isDepositpaid());
        assertEquals(respPojo.getBooking().getBookingdates().getCheckin(), expbody.getBooking().getBookingdates().getCheckin());
        assertEquals(respPojo.getBooking().getBookingdates().getCheckout(), expbody.getBooking().getBookingdates().getCheckout());
        assertEquals(respPojo.getBooking().getAdditionalneeds(), expbody.getBooking().getAdditionalneeds());

    }

}
