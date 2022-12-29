package com.example.ee4354_g9_dr_doo;

public class CardShop {
    String cHeading;
    String cLocation;
    String cName;
    String cContact;

    public CardShop(String cHeading, String cLocation, String cName, String cContact){
        this.cContact=cContact;
        this.cName=cName;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
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
}
