package com.austpost.locationinfoservice.service;

import com.austpost.locationinfoservice.dao.LocationServiceDao;
import com.austpost.locationinfoservice.models.LocationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationInformationService {

    @Autowired
    private LocationServiceDao locationServiceDao;

    public void save(LocationInformation locationInformation){
        locationServiceDao.save(locationInformation);
    }

    public Iterable<LocationInformation> findAll(){
        return locationServiceDao.findAll();
    }

    public List<LocationInformation> findSuburbByPostcode(Integer postCode){
        return locationServiceDao.findSuburbByPostcode(postCode);
    }

    public List<LocationInformation> findPostcodeBySuburb(String suburbName){
        return locationServiceDao.findPostcodeBySuburb(suburbName);
    }
}
