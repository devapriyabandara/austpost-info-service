package com.austpost.locationinfoservice.dao;

import com.austpost.locationinfoservice.models.LocationInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationServiceDao extends CrudRepository<LocationInformation, Integer> {

    @Query(value="SELECT *FROM location_information WHERE postal_code=?1", nativeQuery=true)
    List<LocationInformation> findSuburbByPostcode(Integer postCode);

    @Query(value="SELECT *FROM location_information WHERE suburb_name=?1", nativeQuery=true)
    List<LocationInformation> findPostcodeBySuburb(String suburbName);
}
