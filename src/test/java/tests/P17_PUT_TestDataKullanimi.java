package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.JPHTestDatas;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class P17_PUT_TestDataKullanimi extends JPH_baseUrl {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip
        bir PUT request yolladigimizda donen response'in
        status kodunun 200,
        content type'inin "application/json; charset=utf-8",
        Connection header degerinin "keep-alive"
        ve response body'sinin asagida verilen ile ayni oldugunu test ediniz.

            Request Body
                {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 7,
                    "id": 70
                }

            Response Body
                 {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 7,
                    "id": 70
                }
    */

    @Test
    public void put01(){

        specJPH.pathParams("pp1", "posts", "pp2", 70);

        JSONObject reqBody = JPHTestDatas.requestBodyOlusturJSON();

        JSONObject expData = JPHTestDatas.expectedDataOlusturJSONParametreli(7, 70, "Ahmet", "Merhaba");

        Response response = given()
                                .spec(specJPH)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .put("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        assertEquals(JPHTestDatas.basariliStatusCode, response.getStatusCode());
        assertEquals(JPHTestDatas.contentType, response.getContentType());
        assertEquals(JPHTestDatas.connectionHeader, response.getHeader("Connection"));

        assertEquals(expData.get("title"), respJP.getString("title"));
        assertEquals(expData.get("body"), respJP.getString("body"));
        assertEquals(expData.get("userId"), respJP.getInt("userId"));
        assertEquals(expData.get("id"), respJP.getInt("id"));

    }

}
