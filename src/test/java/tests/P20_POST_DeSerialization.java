package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import testDatas.RestfulTestDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P20_POST_DeSerialization extends Restful_BaseUrl {

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
    public void post01() {

        specRestful.pathParam("pp1", "booking");

        Map<String, Object> reqBody = RestfulTestDatas.requestBodyOlusturMap();

        Map<String, Object> expBody = new HashMap<>();
        expBody.put("bookingid", 24);
        expBody.put("booking", RestfulTestDatas.requestBodyOlusturMap());

        System.out.println(expBody);

        Response response = given()
                .spec(specRestful)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .post("/{pp1}");

        response.prettyPrint();

        Map<String, Object> respMap = response.as(HashMap.class);

        assertEquals(((Map) (respMap.get("booking"))).get("firstname"), ((Map) (expBody.get("booking"))).get("firstname"));
        assertEquals(((Map) (respMap.get("booking"))).get("lastname"), ((Map) (expBody.get("booking"))).get("lastname"));
        assertEquals(((Map) (respMap.get("booking"))).get("totalprice"), ((Map) (expBody.get("booking"))).get("totalprice"));
        assertEquals(((Map) (respMap.get("booking"))).get("depositpaid"), ((Map) (expBody.get("booking"))).get("depositpaid"));
        assertEquals(((Map) (respMap.get("booking"))).get("additionalneeds"), ((Map) (expBody.get("booking"))).get("additionalneeds"));
        assertEquals(((Map) (((Map) (respMap.get("booking"))).get("bookingdates"))).get("checkin"),
                ((Map) (((Map) (expBody.get("booking"))).get("bookingdates"))).get("checkin"));
        assertEquals(((Map) (((Map) (respMap.get("booking"))).get("bookingdates"))).get("checkout"),
                ((Map) (((Map) (expBody.get("booking"))).get("bookingdates"))).get("checkout"));

    }

}
