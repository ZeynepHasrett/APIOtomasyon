package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestDatas {

    public static JSONObject bookingDatesOlustur() {

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        return bookingDates;
    }

    public static JSONObject requestBodyOlusturJSON() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingDatesOlustur());
        reqBody.put("additionalneeds", "wi-fi");

        return reqBody;
    }

    public static JSONObject requestBodyOlusturJSONParametreli(String firstname, String lastname, int totalprice, boolean depositpaid, JSONObject bookingdates, String additionalneeds) {

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", firstname);
        reqBody.put("lastname", lastname);
        reqBody.put("totalprice", totalprice);
        reqBody.put("depositpaid", depositpaid);
        reqBody.put("bookingdates", bookingDatesOlustur());
        reqBody.put("additionalneeds", additionalneeds);

        return reqBody;
    }

    public static JSONObject bookingDatesOlusturParametreli(String checkin, String checkout) {

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);

        return bookingDates;
    }

    public static JSONObject expectedBodyOlusturJSON() {

        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("booking", requestBodyOlusturJSON());

        return expData;
    }

    public static Map<String, Object> bookingDatesOlusturMap() {

        Map<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        return bookingdates;
    }

    public static Map<String, Object> requestBodyOlusturMap() {

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500.0);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingDatesOlusturMap());
        reqBody.put("additionalneeds", "wi-fi");

        return reqBody;
    }

}
