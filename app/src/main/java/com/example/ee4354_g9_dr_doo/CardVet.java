package com.example.ee4354_g9_dr_doo;

import com.google.android.gms.maps.model.LatLng;

public class CardVet {

    String cHeading;
    LatLng cLocation;
    String cName;
    String cContact;
    String cRating;
    String cImage;
    public CardVet(String cHeading, LatLng cLocation, String cName, String cContact,String cRating,String cImage){
        this.cContact=cContact;
        this.cName=cName;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
        this.cRating=cRating;
        this.cImage=cImage;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public String getcHeading() {
        return cHeading;
    }

    public LatLng getcLocation() {
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

    public void setcLocation(LatLng cLocation) {
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
