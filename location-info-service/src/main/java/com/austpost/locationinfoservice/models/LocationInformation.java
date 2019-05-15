package com.austpost.locationinfoservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LocationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String suburbName;
    private int postalCode;

    public LocationInformation() {
    }

    public LocationInformation(int postalCode, String suburbName) {
        this.suburbName = suburbName;
        this.postalCode = postalCode;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
