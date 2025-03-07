package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P05_PUT_ResponseBodyTest extends ReqresBaseUrl {

    /*
            https://reqres.in/api/users/2 URL'ine
            aşağıdaki JSON body ile PUT request gönderildiğinde

                {
                    "name": "Murat",
                    "job": "Senior QA"
                }

                dönen Response’un:
                    Status code’unun 200 olduğunu,
                    Content type’ının application/json; charset=utf-8 olduğunu,
                    Response Body’sini updatedAt hariç aşağıdaki expectedBody ile birebir eşleştiğini test ediniz.

                {
                    "name": "Murat",
                    "job": "Senior QA",
                    "updatedAt": "2025-03-05T12:34:56.789Z"
                }
     */

    @Test
    public void put01() {

        specReqresBaseUrl.pathParams("pp1", "api", "pp2", "users", "pp3", 2);

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", "Murat");
        reqBody.put("job", "Senior QA");

        JSONObject expBody = new JSONObject();
        expBody.put("name", "Murat");
        expBody.put("job", "Senior QA");
        expBody.put("updatedAt", "2025-03-05T12:34:56.789Z");

        Response response = given()
                                .spec(specReqresBaseUrl)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .put("/{pp1}/{pp2}/{pp3}");

        response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(respJP.get("name"), expBody.get("name"));
        assertEquals(respJP.get("job"), expBody.get("job"));

    }

}
