package com.example.ee4354_g9_dr_doo;

import com.google.android.gms.maps.model.LatLng;

public class CardCare {
    String cHeading;
    LatLng cLocation;
    String cDate;
    String cContact;

    public CardCare(String cHeading, LatLng cLocation, String cDate, String cContact){
        this.cContact=cContact;
        this.cDate=cDate;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
    }

    public String getcHeading() {
        return cHeading;
    }

    public LatLng getcLocation() {
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

    public void setcLocation(LatLng cLocation) {
        this.cLocation = cLocation;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact;
    }
}
