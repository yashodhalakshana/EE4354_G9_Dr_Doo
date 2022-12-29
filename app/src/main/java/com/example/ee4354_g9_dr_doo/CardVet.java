package com.example.ee4354_g9_dr_doo;

public class CardVet {

    String cHeading;
    String cLocation;
    String cName;
    String cContact;
    String cRating;

    public CardVet(String cHeading, String cLocation, String cName, String cContact,String cRating){
        this.cContact=cContact;
        this.cName=cName;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
        this.cRating=cRating;
    }

    public String getcHeading() {
        return cHeading;
    }

    public String getcLocation() {
        return cLocation;
    }

    public String getcName() {
        return cName;
    }

    public String getcContact() {
        return cContact;
    }

    public String getcRating() {
        return cRating;
    }

    public void setcHeading(String cHeading) {
        this.cHeading = cHeading;
    }

    public void setcLocation(String cLocation) {
        this.cLocation = cLocation;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact;
    }

    public void setcRating(String cRating) {
        this.cRating = cRating;
    }
}
