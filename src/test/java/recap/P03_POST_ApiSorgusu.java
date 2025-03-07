package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P03_POST_ApiSorgusu extends ReqresBaseUrl {

    /*
            https://reqres.in/api/users URL'ine
            header değeri "Content-Type", "application/json" olan bir POST isteği gönderin.

            İstek için JSON formatında şu bilgileri içeren bir body kullanın:

                {
                    "name": "morpheus",
                    "job": "leader"
                }

            Gelen yanıtın durum kodunun 201 olduğunu doğrulayın.
            Yanıtın JSON body'sinde name alanının morpheus olduğunu kontrol edin.
     */

    @Test
    public void post(){

        specReqresBaseUrl.pathParams("pp1", "api", "pp2", "users");

//        JSONObject reqBody = new JSONObject();
//        reqBody.put("name", "morpheus");
//        reqBody.put("job", "leader");

        String reqBody = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        Response response = given()
                                .spec(specReqresBaseUrl)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .header("Content-Type", "application/json")
                                .post("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        assertEquals(response.statusCode(), 201);
        assertEquals(respJP.get("name"), "morpheus");

    }

}
