package tests;

import baseUrl.JPH_baseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P12_BaseUrl_JPH extends JPH_baseUrl {


    /*
        https://jsonplaceholder.typicode.com/posts endpointine
        bir GET request gonderdigimizde
        donen response'un

        status code'unun 200 oldugunu ve
        Response'ta 100 kayit oldugunu test edin.
    */

    @Test
    public void get01() {

        specJPH.pathParam("pp1", "posts");

        Response response = given().spec(specJPH).when().get("/{pp1}");

        // response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", hasSize(100));

    }


    /*
        https://jsonplaceholder.typicode.com/posts/44 endpointine
        bir GET request gonderdigimizde
        donen response'un

        status code'unun 200 oldugunu ve
        "title" degerinin "optio dolor molestias sit" oldugunu test edin..
    */

    @Test
    public void get02(){

        specJPH.pathParams("pp1", "posts", "pp2", 44);

        Response response = given().spec(specJPH).when().get("/{pp1}/{pp2}");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("optio dolor molestias sit"));

    }

    /*
        https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
        gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve
        response body’sinin null oldugunu test edin.
     */

    @Test
    public void delete01(){

        specJPH.pathParams("pp1", "posts", "pp2", 50);

        Response response = given().spec(specJPH).when().delete("/{pp1}/{pp2}");

        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("title", nullValue());

    }

}
