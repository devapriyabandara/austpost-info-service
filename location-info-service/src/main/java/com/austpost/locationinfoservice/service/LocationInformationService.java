/*
    This class implements the service to facilitate different API calls based on location information
 */
package com.austpost.locationinfoservice.service;

import com.austpost.locationinfoservice.repository.LocationServiceDao;
import com.austpost.locationinfoservice.models.LocationInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationInformationService {

    @Autowired
    private LocationServiceDao locationServiceDao;

    /*
        Implementation of save method in CrudRepository
     */
    public void save(LocationInformation locationInformation){
        locationServiceDao.save(locationInformation);
    }

    /*
        Implementation of findAll method in CrudRepository
     */
    public Iterable<LocationInformation> findAll(){
        return locationServiceDao.findAll();
    }

    /*
        Implementation of findSuburbByPostcode method in LocationServiceDao
     */
    public List<LocationInformation> findSuburbByPostcode(Integer postCode){
        return locationServiceDao.findSuburbByPostcode(postCode);
    }

    /*
        Implementation of findPostcodeBySuburb method in LocationServiceDao
     */
    public List<LocationInformation> findPostcodeBySuburb(String suburbName){
        return locationServiceDao.findPostcodeBySuburb(suburbName);
    }

    /*
        Implementation of isRecordExist method in LocationServiceDao
        This method will check record existence in database by passing suburb, postcode combination
     */
    public boolean isRecordExist(LocationInformation locationInformation){

        List<LocationInformation> locationInformations = locationServiceDao.isRecordExist(
                locationInformation.getSuburbName(), locationInformation.getPostCode());

        if (locationInformations == null || locationInformations.size() == 0){
            return false;
        } else {
            return true;
        }
    }
}
