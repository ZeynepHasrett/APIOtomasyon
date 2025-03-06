package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPOJO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P21_PUT_PojoClass extends JPH_baseUrl {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body'e sahip bir PUT request yolladigimizda
        donen response'in response body'sinin
        asagida verilen ile ayni oldugunu test ediniz.

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
    public void put01(){

        specJPH.pathParams("pp1", "posts", "pp2", 70);

        JsonPlaceHolderPOJO reqBody = new JsonPlaceHolderPOJO("Ahmet", "Merhaba", 10, 70);

        System.out.println("reqBody: " + reqBody);

        JsonPlaceHolderPOJO expBody = new JsonPlaceHolderPOJO("Ahmet", "Merhaba", 10, 70);

        Response response = given()
                                .spec(specJPH)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .put("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPlaceHolderPOJO respPojo = response.as(JsonPlaceHolderPOJO.class);

        assertEquals(respPojo.getTitle(), expBody.getTitle());
        assertEquals(respPojo.getBody(), expBody.getBody());
        assertEquals(respPojo.getUserId(), expBody.getUserId());
        assertEquals(respPojo.getId(), expBody.getId());

    }
}
