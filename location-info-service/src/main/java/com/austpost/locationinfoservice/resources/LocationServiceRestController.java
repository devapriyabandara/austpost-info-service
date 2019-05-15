/*
This is the class responsible for main rest apis
 */

package com.austpost.locationinfoservice.resources;

import com.austpost.locationinfoservice.models.LocationInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/locationservice")
public class LocationServiceRestController {

    @GetMapping(path="/all")
    public List<LocationInformation> getAllLocations(){

        return Arrays.asList(
            new LocationInformation(3806, "Berwick"),
            new LocationInformation(3806, "Harkway"),
            new LocationInformation(3977, "Cranbourne North")
        );
    }




}
