package tests;

import baseUrl.Restful_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.RestfulTestDatas;

import static io.restassured.RestAssured.given;

public class P23_TokenKullanimi extends Restful_BaseUrl {

       /*
           https://restful-booker.herokuapp.com/booking/2924 (id güncellenmeli)
           adresindeki rezervasyon bilgilerini

               -H 'Content-Type: application/json' \
               -H 'Accept: application/json' \
               -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
               header değerleriyle PUT request göndererek update ediniz.

               Token Oluşturma
               Content-Type: application/json header değeriyle aşağıdaki body ile
               {
                       "username" : "admin",
                       "password" : "password123"
               }
               Post Request yapınız.
        */

    String token;

    @Test
    public void createToken(){

        specRestful.pathParams("pp1", "auth");

        JSONObject reqBody = new JSONObject();
        reqBody.put("username", "admin");
        reqBody.put("password", "password123");

        Response response = given()
                                .spec(specRestful)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .post("/{pp1}");

        response.prettyPrint();

        JsonPath respJP = response.jsonPath();

        token = respJP.getString("token");

        System.out.println("Token: " + token);

    }

    @Test
    public void put01(){

        specRestful.pathParams("pp1", "booking", "pp2", 2924);

        JSONObject reqBody = RestfulTestDatas.requestBodyOlusturJSON();

        Response response = given()
                                .spec(specRestful)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .header("Cookie", "token=" + token)
                                .put("/{pp1}/{pp2}");

    }

    @Test
    public void put02(){

        specRestful.pathParams("pp1", "booking", "pp2", 2924);

        JSONObject reqBody = RestfulTestDatas.requestBodyOlusturJSON();

        Response response = given()
                                .spec(specRestful)
                                .contentType(ContentType.JSON)
                            .when()
                                .body(reqBody.toString())
                                .header("Content-Type", "application/json")
                                .header("Accept", "application/json")
                                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                                .put("/{pp1}/{pp2}");

        response.prettyPrint();

    }

}
