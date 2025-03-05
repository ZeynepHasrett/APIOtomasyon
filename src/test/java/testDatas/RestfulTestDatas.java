package testDatas;

import org.json.JSONObject;

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

}
