/*
    Interface extends from CRUD repository and declares two new custom methods
    which finds suburb and post code information
 */
package com.austpost.locationinfoservice.repository;

import com.austpost.locationinfoservice.models.LocationInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationServiceDao extends CrudRepository<LocationInformation, Integer> {

    /*
        Custom method declaration to find suburb by passing post code
     */
    @Query(value="SELECT *FROM location_information WHERE post_code=?1", nativeQuery=true)
    List<LocationInformation> findSuburbByPostcode(Integer postCode);

    /*
        Custom method declaration to find post code by passing suburb name
     */
    @Query(value="SELECT *FROM location_information WHERE suburb_name=?1", nativeQuery=true)
    List<LocationInformation> findPostcodeBySuburb(String suburbName);

    /*
        Custom method declaration to find postcode and suburb combination existence
        by passing suburb name and postcode
     */
    @Query(value="SELECT *FROM location_information WHERE suburb_name=?1 AND post_code=?2", nativeQuery=true)
    List<LocationInformation> isRecordExist(String suburbName, int postCode);
}
