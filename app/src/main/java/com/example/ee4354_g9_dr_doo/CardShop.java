package com.example.ee4354_g9_dr_doo;

import com.google.android.gms.maps.model.LatLng;

public class CardShop {
    String cHeading;
    LatLng cLocation;
    String cName;
    String cContact;
    String cImage;
    public CardShop(String cHeading, LatLng cLocation, String cName, String cContact,String cImage){
        this.cContact=cContact;
        this.cName=cName;
        this.cHeading=cHeading;
        this.cLocation=cLocation;
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
}
