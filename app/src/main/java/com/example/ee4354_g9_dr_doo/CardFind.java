package com.example.ee4354_g9_dr_doo;

public class CardFind {
    String cHeading;
    String cLocation;
    String cDate;
    String cContact;
    String cRewards;

    public CardFind(String cHeading, String cLocation, String cDate, String cContact,String cRewards){
        this.cContact=cContact;
        this.cDate=cDate;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
        this.cRewards=cRewards;
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

    public String getcRewards() {
        return cRewards;
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

    public void setcRewards(String cRewards) {
        this.cRewards = cRewards;
    }
}
