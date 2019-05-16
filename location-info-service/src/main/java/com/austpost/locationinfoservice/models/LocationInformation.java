/*
    Entity class to location information (suburb name and post code)
*/
package com.austpost.locationinfoservice.models;

import javax.persistence.*;

@Entity
@Table(name="location_information")
public class LocationInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer postCode;   // Holds post code data
    private String suburbName;  // Holds suburb name


    public LocationInformation() {
    }

    public LocationInformation(Integer postCode, String suburbName) {
        this.suburbName = suburbName;
        this.postCode = postCode;
    }

    public Integer getId() { return id; }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }
}
