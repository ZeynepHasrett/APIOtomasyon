package pojo;

public class JsonPlaceHolderPOJO {

    /*
        Request Body
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }
     */

    // 1- Obje icerisindeki tum key degerleri, class level'da private variable olarak olusturulur.

    private String title;
    private String body;
    private int userId;
    private int id;


    // 2- Tum variable'lar icin Getter ve Setter olusturulur.

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3- Tum variable'lari iceren parametreli constructor olusturulur.

    public JsonPlaceHolderPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }


    // 4- Default (parametresiz) constructor olusturulur.

    public JsonPlaceHolderPOJO() {
    }


    // 5-  Verileri yazdirabilmek icin toString() method'u olusturulur.

    @Override
    public String toString() {
        return "POJOJPH{" +
                "title='" + title + '\'' +  // {title='Ahmet', body='Merhaba', userId=10, id=70}
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }

}
