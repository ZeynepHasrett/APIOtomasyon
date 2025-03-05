package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JPHTestDatas {

    public static int basariliStatusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String connectionHeader = "keep-alive";

    public static JSONObject expectedDataOlusturJSON(){

        JSONObject expData = new JSONObject();

        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;

    }

    public static JSONObject expectedDataOlusturJSONParametreli(int userId, int id, String title, String body){

        JSONObject expData = new JSONObject();

        expData.put("userId", userId);
        expData.put("id", id);
        expData.put("title", title);
        expData.put("body", body);

        return expData;

    }

    public static JSONObject expectedDataOlusturJSONScanner(){

        Scanner scanner=new Scanner(System.in);

        System.out.println("Gerekli Bilgileri Giriniz!");
        System.out.print("userId: ");
        int userId=scanner.nextInt();

        System.out.print("id: ");
        int id=scanner.nextInt();

        System.out.print("title: ");
        String title=scanner.nextLine();

        System.out.print("body: ");
        String body=scanner.nextLine();


        JSONObject expBody=new JSONObject();
        expBody.put("userId",userId);
        expBody.put("id",id);
        expBody.put("title",title);
        expBody.put("body",body);

        return expBody;

    }

    public static JSONObject requestBodyOlusturJSON(){

        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 7);
        reqBody.put("id", 70);

        return reqBody;

    }

    public static JSONObject requestBodyOlusturJSONParametreli(String title, String body, int userId, int id){

        JSONObject reqBody = new JSONObject();
        reqBody.put("title", title);
        reqBody.put("body", body);
        reqBody.put("userId", userId);
        reqBody.put("id", id);

        return reqBody;

    }

    public static Map<String, Object> requestBodyOlusturMAP(){

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 7.0);
        reqBody.put("id", 70.0);

        return reqBody;
    }

    public static Map<String, Object> requestBodyOlusturMAPParametreli(String title, String body, double userId, double id){

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", title);
        reqBody.put("body", body);
        reqBody.put("userId", userId);
        reqBody.put("id", id);

        return reqBody;
    }

}
