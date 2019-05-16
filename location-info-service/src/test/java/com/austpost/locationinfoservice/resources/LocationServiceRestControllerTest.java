/*
    Basic unit testing class for LocationServiceRestController
 */
package com.austpost.locationinfoservice.resources;

import com.austpost.locationinfoservice.models.LocationInformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value=LocationServiceRestController.class, secure = false)
public class LocationServiceRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationServiceRestController locationServiceRestController;

    private String suburbApiUri = "/locationservice/getsuburb/";
    private String postCodeApiUri = "/locationservice/getpostcode/";
    private String addApiUri = "/locationservice/add";

    @Test
    public void should_get_valid_suburb_by_passing_postcode() throws Exception{

        LocationInformation mockLocationInformation = new LocationInformation(3008, "Docklands");
        List<LocationInformation> mockLocationInformationList = Arrays.asList(mockLocationInformation);

        Mockito.when(locationServiceRestController.getSuburbByPostcode(Mockito.anyInt())).thenReturn(mockLocationInformationList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(suburbApiUri+"3008").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String expectedResult = "[{postCode:3008,suburbName:Docklands}]";
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void should_get_valid_postcode_by_passing_suburbname() throws Exception{

        LocationInformation mockLocationInformation = new LocationInformation(3806, "Berwick");
        List<LocationInformation> mockLocationInformationList = Arrays.asList(mockLocationInformation);

        Mockito.when(locationServiceRestController.findPostcodeBySuburb(Mockito.anyString())).thenReturn(mockLocationInformationList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(postCodeApiUri+"Berwick").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String expectedResult = "[{postCode:3806,suburbName:Berwick}]";
        JSONAssert.assertEquals(expectedResult, mvcResult.getResponse().getContentAsString(), false);
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void should_create_valid_location_and_retrun_ok_status() throws Exception{
        LocationInformation mockLocationInformation = new LocationInformation(3806, "Berwick");
        String mockLocationInfoStr = "{\"postCode\":\"3806\",\"suburbName\":\"Berwick\"}";

        Mockito.when(locationServiceRestController.addNewLocationInformation(Mockito.any(LocationInformation.class))).thenReturn(mockLocationInformation);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(addApiUri).accept(MediaType.APPLICATION_JSON).content(mockLocationInfoStr).contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
        System.out.println(mvcResult.getResponse().getStatus());
    }

}
