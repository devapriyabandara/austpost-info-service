package com.austpost.locationinfoservice.models;

import javax.persistence.*;

@Entity
@Table(name="location_information")
public class LocationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer postalCode;
    private String suburbName;


    public LocationInformation() {
    }

    public LocationInformation(Integer postalCode, String suburbName) {
        this.suburbName = suburbName;
        this.postalCode = postalCode;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
