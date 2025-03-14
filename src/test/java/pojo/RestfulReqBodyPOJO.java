package pojo;

public class RestfulReqBodyPOJO {

    /*
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
     */

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private RestfulBookingDatesPOJO bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public RestfulBookingDatesPOJO getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(RestfulBookingDatesPOJO bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public RestfulReqBodyPOJO(String firstname, String lastname, int totalprice, boolean depositpaid, RestfulBookingDatesPOJO bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public RestfulReqBodyPOJO() {
    }

    @Override
    public String toString() {
        return "RestfulReqBodyPOJO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }

}
