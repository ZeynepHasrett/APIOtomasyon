package tests;

import baseUrl.CollectApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class P24_GET_CollectApi_NobetciEczaneler extends CollectApiBaseUrl {

    /*
           https://api.collectapi.com/health/dutyPharmacy?il=istanbul&ilce=Üsküdar
           adresine aşağıdaki bilgilerler bir GET request yapınca
           dönen cevabı yazdırınız.

           header
           Content-Type : application/json
           Authorization: apiKeyiniz
    */

    @Test
    public void get01(){

        specCollectApi.pathParams("pp1", "health", "pp2", "dutyPharmacy")
                            .queryParams("il", "istanbul", "ilce", "Üsküdar");

        Response response = given()
                                .spec(specCollectApi)
                            .when()
                                .header("Content-Type", "application/json")
                                .header("Authorization", "apikey 0Xm8EJfrD24WenAbwdt00x:6ohTrrcCPZaRuWEk5PSxrj")
                                .get("/{pp1}/{pp2}");

        response.prettyPrint();

    }

}
