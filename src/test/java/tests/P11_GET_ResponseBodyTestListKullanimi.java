package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P11_GET_ResponseBodyTestListKullanimi {

    /*
        https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url'ine
        bir GET request yolladigimizda
        donen Response'in

            status code'unun 200,
            ve content type'inin application/json,
            ve response body'sindeki
                eczane sayisinin 6
                ve eczanelerden birinin "ECE ECZANESI"
                ve eczane ilcelerinde icinde keskin, karakeçili ve yahsihan degerinin oldugunu test edin.
    */

    @Test
    public static void get01(){

        String url = "https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale";

        String apikey="apikey 4kI8rTnIIPO3yPcrzStSfI:1Hb4JHbWETWOQNHusEJo1a";

        Response response = given().when().header("authorization", apikey).get(url);

        // response.prettyPrint();

        response
                .then()
                .assertThat()
                            .statusCode(200)
                            .contentType("application/json")
                .body("result.dist", hasSize(6),
                        "result.name", hasItem("ECE ECZANESI"),
                        "result.dist", hasItems("keskin", "karakeçili", "yahşihan"));

    }

}
