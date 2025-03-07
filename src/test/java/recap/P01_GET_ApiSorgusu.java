package recap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class P01_GET_ApiSorgusu {

    /*
           https://reqres.in/api/users/2 URL'ine bir GET isteği gönderin.
           Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
           Yanıtın JSON body'sinde yer alan data.id değerinin 2 olduğunu doğrulayın.
           Yanıt süresinin 2 saniyeden kısa olduğunu kontrol edin.
    */

    @Test
    public void get01() {

        String url = "https://reqres.in/api/users/2";

        // Response response = given().when().get(url); // Header değerleri eklenmeyecekse tercih edilmez.

        Response response = RestAssured.get(url);

        response.then().assertThat().statusCode(200);
        assertEquals(response.jsonPath().getInt("data.id"), 2);
        assertTrue(response.getTime() < 2000);

    }

}
