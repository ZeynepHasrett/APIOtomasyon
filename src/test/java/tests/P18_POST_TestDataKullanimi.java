package tests;

public class P18_POST_TestDataKullanimi {

    /*
        https://restful-booker.herokuapp.com/booking url'ine asagidaki body'ye sahip
        bir POST request gonderdigimizde donen response'un
        id haric asagidaki gibi oldugunu test edin.

            Request body
               {
                   "firstname" : "Ahmet",
                   "lastname" : "Bulut",
                   "totalprice" : 500,
                   "depositpaid" : false,
                   "bookingdates" : {
                       "checkin" : "2021-06-01",
                       "checkout" : "2021-06-10"
                   },
                   "additionalneeds" : "wi-fi"
               }

            Response Body
                {
                    "bookingid": 24,
                    "booking": {
                        "firstname": "Ahmet",
                        "lastname": "Bulut",
                        "totalprice": 500,
                        "depositpaid": false,
                        "bookingdates": {
                            "checkin": "2021-06-01",
                            "checkout": "2021-06-10"
                        },
                        "additionalneeds": "wi-fi"
                    }
                }
         */



}
