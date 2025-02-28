package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class JSONObjectVerileriCagirma {

    @Test
    public void test01(){

        /*
            {
                "firstName":"John",
                "lastName":"Doe",
                "address":{
                    "streetAddress":"naist street",
                    "city":"Nara",
                    "postalCode":"630-0192"
                    },
                "age":26,
                "phoneNumbers": [
                                {
                                    "number":"0123-4567-8888",
                                    "type":"iPhone"
                                },
                                {
                                    "number":"0123-4567-8910",
                                    "type":"home"
                                }
                                ]
             }
         */

        JSONObject cepTel = new JSONObject();
        cepTel.put("type", "iPhone");
        cepTel.put("number", "0123-4567-8888");

        JSONObject evTel = new JSONObject();
        evTel.put("type", "home");
        evTel.put("number", "0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0, cepTel);
        phoneNumbers.put(1, evTel);

        JSONObject address = new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city", "Nara");
        address.put("postalCode", "630-0192");

        JSONObject kisibilgisi = new JSONObject();

        kisibilgisi.put("firstName", "John");
        kisibilgisi.put("lastName", "Doe");
        kisibilgisi.put("age", 26);
        kisibilgisi.put("address", address);
        kisibilgisi.put("phoneNumbers", phoneNumbers);

        System.out.println("Kisi Bilgisi: " + kisibilgisi);

        System.out.println("Isim: " + kisibilgisi.get("firstName"));
        System.out.println("Soyisim: " + kisibilgisi.get("lastName"));
        System.out.println("Yas: " + kisibilgisi.get("age"));
        System.out.println("Sokak Adi: " + kisibilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("Sehir: " + kisibilgisi.getJSONObject("address").get("city"));
        System.out.println("Posta Kodu: " + kisibilgisi.getJSONObject("address").get("postalCode"));
        System.out.println("Tel No: " + kisibilgisi.getJSONArray("phoneNumbers")
                                                   .getJSONObject(0)
                                                   .get("number"));

    }

}
