package com.example.ee4354_g9_dr_doo;

public class CardCare {
    String cHeading;
    String cLocation;
    String cDate;
    String cContact;

    public CardCare(String cHeading, String cLocation, String cDate, String cContact){
        this.cContact=cContact;
        this.cDate=cDate;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
    }

    public String getcHeading() {
        return cHeading;
    }

    public String getcLocation() {
        return cLocation;
    }

    public String getcDate() {
        return cDate;
    }

    public String getcContact() {
        return cContact;
    }

    public void setcHeading(String cHeading) {
        this.cHeading = cHeading;
    }

    public void setcLocation(String cLocation) {
        this.cLocation = cLocation;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact;
    }
}
