package recap;

import baseUrl.ReqresBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class P02_GET_ListKullanimi extends ReqresBaseUrl {

    /*
            https://reqres.in/api/users?page=2 URL'ine bir GET isteği gönderin.
            Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
            Liste içerisindeki kullanıcı sayısının en az 1 olduğunu doğrulayın.
            Ilk kullanıcının email adresinin boş olmadığını kontrol edin.
    */

    @Test
    public void get01(){

        specReqresBaseUrl.pathParams("pp1", "api", "pp2", "users")
                            .queryParam("page", 2);

        Response response = given()
                                .spec(specReqresBaseUrl)
                            .when()
                                .get("/{pp1}/{pp2}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        assertEquals(response.getStatusCode(), 200);
        assertTrue(response.jsonPath().getList("data").size() > 0);
        assertFalse(response.jsonPath().getList("data").isEmpty());
        assertNotNull(response.jsonPath().get("data[0].email"));

    }

}
