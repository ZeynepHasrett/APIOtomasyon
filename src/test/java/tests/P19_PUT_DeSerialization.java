package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import testDatas.JPHTestDatas;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class P19_PUT_DeSerialization extends JPH_baseUrl {

    /*
            https://jsonplaceholder.typicode.com/posts/70 url'ine
            asagidaki body'e sahip bir PUT request yolladigimizda
            donen response'in response body'sinin
            asagida verilen ile ayni oldugunu test ediniz

                Request Body
                {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 10,
                    "id": 70
                }

                Expected Data :
                {
                    "title": "Ahmet",
                    "body": "Merhaba",
                    "userId": 10,
                    "id": 70
                }
 */

    @Test
    public void put01() {

        specJPH.pathParams("pp1", "posts", "pp2", 70);

        Map<String, Object> reqBody = JPHTestDatas.requestBodyOlusturMAP();

        Map<String, Object> expData = JPHTestDatas.requestBodyOlusturMAP();

        Response response = given()
                                .spec(specJPH)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .put("/{pp1}/{pp2}");

        response.prettyPrint();

        Map<String, Object> respMap = response.as(HashMap.class);

        assertEquals(respMap.get("title"), expData.get("title"));
        assertEquals(respMap.get("body"), expData.get("body"));
        assertEquals(respMap.get("userId"), expData.get("userId"));
        assertEquals(respMap.get("id"), expData.get("id"));

    }

}
