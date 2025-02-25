package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P01_GET_apiTest {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin Cowboy,
            ve status Line’in HTTP/1.1 200 OK
            ve response suresinin 5 sn’den kisa
        oldugunu manuel olarak test ediniz.
     */

    /*
        Tum API sorgulari 4 asamada yapilir:

            1- EndPoint hazirlanir, url ve VARSA (PUT-POST-PATCH) request body hazirlanir.
            2- Soruda verilmis ise expected data hazirlanir.
            3- Donen cevap kaydedilir.
            4- Assertion islemleri yapilir.
     */

    @Test
    public void test01() {

        // 1- EndPoint hazirlanir
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Soruda verilmisse expected data hazirlanir
        // Soruda verilmemis

        // 3- Donen cevap kaydedilir
        Response response = given().when().get(url);

        // response.prettyPrint();
        // response.prettyPeek();

        // 4- Assertion islemleri yapilir
        System.out.println("Status Degeri: " + response.getStatusCode()); // 200
        System.out.println("Content Type Degeri: " + response.getContentType()); // application/json; charset=utf-8
        System.out.println("Server Isimli Header Degeri: " + response.getHeader("Server")); // Cowboy
        System.out.println("Status Line Degeri: " + response.getStatusLine()); // HTTP/1.1 200 OK
        System.out.println("Response Suresi Degeri: " + response.getTime()); // 5 saniyeden kisa

    }

}
