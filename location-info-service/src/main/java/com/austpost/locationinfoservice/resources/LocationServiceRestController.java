/*
This is the class responsible for main rest apis
 */

package com.austpost.locationinfoservice.resources;

import com.austpost.locationinfoservice.models.LocationInformation;
import com.austpost.locationinfoservice.service.LocationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path="/locationservice")
public class LocationServiceRestController {

    @Autowired
    private LocationInformationService locationInformationService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewLocationInformation(@RequestParam int postCode, @RequestParam String suburbName){

        LocationInformation newLocationInfo = new LocationInformation();
        newLocationInfo.setPostalCode(postCode);
        newLocationInfo.setSuburbName(suburbName);

        locationInformationService.save(newLocationInfo);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<LocationInformation> getAllLocations(){

        return locationInformationService.findAll();
    }


    @RequestMapping(path="/getsuburb/{postCode}")
    public @ResponseBody List<LocationInformation> getSuburbByPostcode(@PathVariable("postCode") Integer postCode){

        System.out.println("PostCode :"+postCode);
        return locationInformationService.findSuburbByPostcode(postCode);
    }

    @RequestMapping(path="/getpostcode/{suburbName}")
    public @ResponseBody List<LocationInformation> findPostcodeBySuburb(@PathVariable("suburbName") String suburbName){

        System.out.println("Suburb Name :"+suburbName);
        return locationInformationService.findPostcodeBySuburb(suburbName);
    }

}
