/*
This is the class responsible for main rest apis
 */

package com.austpost.locationinfoservice.resources;

import com.austpost.locationinfoservice.models.LocationInformation;
import com.austpost.locationinfoservice.models.LocationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/locationservice")
public class LocationServiceRestController {

    @Autowired
    private LocationInformationRepository locationInformationRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewLocationInformation(@RequestParam int postCode, @RequestParam String suburbName){

        LocationInformation newLocationInfo = new LocationInformation();
        newLocationInfo.setPostalCode(postCode);
        newLocationInfo.setSuburbName(suburbName);

        locationInformationRepository.save(newLocationInfo);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<LocationInformation> getAllLocations(){

        return locationInformationRepository.findAll();

//        return Arrays.asList(
//            new LocationInformation(3806, "Berwick"),
//            new LocationInformation(3806, "Harkway"),
//            new LocationInformation(3977, "Cranbourne North")
//        );
    }




}
