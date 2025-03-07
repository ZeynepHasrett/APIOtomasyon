package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ReqresPOJO;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P04_PUT_POJO extends ReqresBaseUrl {

    /*
        https://reqres.in/api/users/2 URL'ine
        header değeri "Content-Type","application/json" olan bir PUT isteği gönderin.
        Kullanıcıyı şu şekilde güncelleyin:

                 {
                     "name": "John Doe",
                     "job": "Manager"
                  }

        Yanıtın durum kodunun 200 olduğunu doğrulayın ve
        name alanının John Doe olduğunu doğrulayın.
    */

    @Test
    public void put01(){

        specReqresBaseUrl.pathParams("pp1", "api", "pp2", "users", "pp3", 2);

        ReqresPOJO reqBody = new ReqresPOJO("John Doe", "Manager");

        Response response = given()
                                .spec(specReqresBaseUrl)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .header("Content-Type","application/json")
                                .put("/{pp1}/{pp2}/{pp3}");

        response.prettyPrint();

        ReqresPOJO respPOJO = response.as(ReqresPOJO.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(respPOJO.getName(), "John Doe");

    }

}
