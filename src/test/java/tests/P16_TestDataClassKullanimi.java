package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import testDatas.JPHDatas;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class P16_TestDataClassKullanimi extends JPH_baseUrl {

    /*
         https://jsonplaceholder.typicode.com/posts/22 url'ine bir
         GET request yolladigimizda donen response'in
         status kodunun 200 ve
         response body'sinin asagida verilen ile ayni oldugunu test ediniz.

            Response body : (expected data)
                {
                    "userId": 3,
                    "id": 22,
                    "title": "dolor sint quo a velit explicabo quia nam",
                    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
                }
    */

    @Test
    public void get01(){

        specJPH.pathParams("pp1", "posts", "pp2", 22);

        JSONObject expData = JPHDatas.expectedDataOlustur();

        Response response = given().spec(specJPH).when().get("/{pp1}/{pp2}");

        // response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        assertEquals(JPHDatas.basariliStatusCode, response.getStatusCode());
        assertEquals(expData.get("userId"), respJP.getInt("userId"));
        assertEquals(expData.get("id"), respJP.getInt("id"));
        assertEquals(expData.get("title"), respJP.getString("title"));
        assertEquals(expData.get("body"), respJP.getString("body"));

    }

}
