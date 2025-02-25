package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P02_GET_ResponseAssertion {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin Cowboy,
            ve status Line’in HTTP/1.1 200 OK
        oldugunu otomasyon ile assert ediniz.
     */

    @Test
    public void test01() {

        // 1- Endpoint hazirlanir
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Soruda verilmisse expected data hazirlanir
        // Soruda verilmemis

        // 3- Donen cevap kaydedilir
        Response response = RestAssured.get(url);

        // 4- Assertion islemleri yapilir
        response.then().assertThat().statusCode(200)
                                    .contentType("application/json; charset=utf-8")
                                    .header("Server", "Cowboy")
                                    .statusLine("HTTP/1.1 200 OK");

    }

}
