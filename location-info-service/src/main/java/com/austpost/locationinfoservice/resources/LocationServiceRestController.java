/*
    This rest controller expose following list of APIs to manipulate location information
    - /locationservice/add {API use to add post code and suburb name combination into the system}
    - /locationservice/all {API use to get all the available location information (post code, suburb name) as a list}
    - /locationservice/getsuburb/{postCode}
 */

package com.austpost.locationinfoservice.resources;

import com.austpost.locationinfoservice.models.LocationInformation;
import com.austpost.locationinfoservice.service.LocationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/locationservice")
public class LocationServiceRestController {

    @Autowired
    private LocationInformationService locationInformationService;

    /*
        This method implements the /add API and captures location information as a JSON object
     */
    @PostMapping(path="/add" , consumes = "application/json", produces = "application/json")
    public @ResponseBody LocationInformation addNewLocationInformation(@RequestBody LocationInformation locationInformation ){

        // Setting up the location information object to pass into save
        LocationInformation locationInformationResponse = new LocationInformation();
        locationInformationResponse.setPostCode(locationInformation.getPostCode());
        locationInformationResponse.setSuburbName(locationInformation.getSuburbName());

        locationInformationService.save(locationInformationResponse);

        return locationInformationResponse;
    }

    /*
        This method implements the /all API to list all the available location information as a list
     */
    @GetMapping(path="/all", produces = "application/json")
    public @ResponseBody Iterable<LocationInformation> getAllLocations(){

        return locationInformationService.findAll();
    }


    /*
        This method implements the /getsuburb API and returns the location information object as a JSON object with
        suburb name and post code details
     */
    @RequestMapping(path="/getsuburb/{postCode}", produces = "application/json")
    public @ResponseBody List<LocationInformation> getSuburbByPostcode(@PathVariable("postCode") Integer postCode){

        System.out.println("PostCode :"+postCode);
        return locationInformationService.findSuburbByPostcode(postCode);
    }


    /*
        This method implements the /getpostcode API and returns the location information object as a JSON object with
        post code and suburb name details
     */
    @RequestMapping(path="/getpostcode/{suburbName}", produces = "application/json")
    public @ResponseBody List<LocationInformation> findPostcodeBySuburb(@PathVariable("suburbName") String suburbName){

        System.out.println("Suburb Name :"+suburbName);
        return locationInformationService.findPostcodeBySuburb(suburbName);
    }

}
