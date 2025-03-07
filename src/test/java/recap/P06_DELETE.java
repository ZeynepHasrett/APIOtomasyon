package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class P06_DELETE extends ReqresBaseUrl {

    /*
        https://reqres.in/api/users/57 URL'sine bir DELETE isteği gönderin.
        Gelen yanıtın durum kodunun 204 olduğunu doğrulayın.
    */

    @Test
    public void delete01(){

        specReqresBaseUrl.pathParams("pp1", "api", "pp2", "users", "pp3", 57);

        Response response = given().spec(specReqresBaseUrl).when().delete("/{pp1}/{pp2}/{pp3}");

        response.then().assertThat().statusCode(204);

    }

}
