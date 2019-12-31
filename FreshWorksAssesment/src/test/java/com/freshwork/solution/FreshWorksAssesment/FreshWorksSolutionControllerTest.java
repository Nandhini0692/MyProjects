package com.freshwork.solution.FreshWorksAssesment;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshwork.solution.FreshWorksAssesment.controller.FreshWorksSolutionController;
import com.freshwork.solution.FreshWorksAssesment.dto.DataStore;
import com.freshwork.solution.FreshWorksAssesment.dto.Response;
import com.freshwork.solution.FreshWorksAssesment.service.FreshWorkSolution;


@RunWith(SpringRunner.class)
@WebMvcTest(value = FreshWorksSolutionController.class)
public class FreshWorksSolutionControllerTest{
    
    @Mock
    FreshWorkSolution freshWorkSolution;
    
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    DataStore datastore;
    
    @Autowired
    Response response;
    
    @Test
    public void readDataStoreTest() throws Exception{
    	
        Response response = new Response();
        DataStore datastore = new DataStore();
        
        datastore.setKey("abc");
        
        ObjectMapper mapper = new ObjectMapper();
        String req = mapper.writeValueAsString(datastore);
        
		Mockito.when(freshWorkSolution.readDatastore(datastore)).thenReturn(response);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/datastore/read")
                .contentType(MediaType.APPLICATION_JSON)
                .content(req);
                         
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
        
    }
    
    @Test
    public void createDataStoreTest() throws Exception{
        
        Response response = new Response();
        DataStore datastore = new DataStore();
        
        datastore.setKey("abc");
        datastore.setValue("test");
        datastore.setTimetolive(1120L);
        
        ObjectMapper mapper = new ObjectMapper();
        String req = mapper.writeValueAsString(datastore);
        
        
        Mockito.when(freshWorkSolution.createDatastore(datastore)).thenReturn(response);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/datastore/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(req);
                         
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
        
    }
    
    @Test
    public void deleteDataStoreTest() throws Exception{
        
        Response response = new Response();
        DataStore datastore = new DataStore();
        
        datastore.setKey("abc");
        
        ObjectMapper mapper = new ObjectMapper();
        String req = mapper.writeValueAsString(datastore);
        
        
        Mockito.when(freshWorkSolution.deleteDatastore(datastore)).thenReturn(response);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/datastore/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(req);
                         
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(200, result.getResponse().getStatus());
        
    }    

}
