package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P09_ExpectedDataOlusturma {

    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda donen response body'sinin
        asagida verilen ile ayni oldugunu test ediniz.

        Response body :(EXPECTED DATA)

            {
                "userId": 3,
                "id": 22,
                "title": "dolor sint quo a velit explicabo quia nam",
                "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                        um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }
    */

    @Test
    public void get01() {

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        JSONObject expData = new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println("Expected Data: " + expData);

        Response response = given().when().get(url);

        response.prettyPrint();

        JsonPath resJP = response.jsonPath();

        Assert.assertEquals(expData.get("userId"), resJP.get("userId"));
        Assert.assertEquals(expData.get("id"), resJP.get("id"));
        Assert.assertEquals(expData.get("title"), resJP.get("title"));
        Assert.assertEquals(expData.get("body"), resJP.get("body"));

    }

}
