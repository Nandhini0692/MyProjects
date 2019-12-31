package com.freshwork.solution.FreshWorksAssesment;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freshwork.solution.FreshWorksAssesment.dto.DataStore;
import com.freshwork.solution.FreshWorksAssesment.dto.MapResponse;
import com.freshwork.solution.FreshWorksAssesment.dto.Response;
import com.freshwork.solution.FreshWorksAssesment.service.FileOperations;


@RunWith(SpringRunner.class)
public class FreshWorksSolutionServiceTest {
	
	@MockBean
	FileOperations fileOpertions;
	
	@Autowired
	DataStore dataStore;
	
	@Autowired
	MapResponse mapResponse;


    @Test
    public void createDataStoreTest() throws Exception{
  
        
        dataStore.setKey("abc");
        dataStore.setTimetolive(112L);
        dataStore.setValue("test");
        
		Mockito.when(fileOpertions.initialize()).thenReturn(mapResponse);
		PowerMockito.mockStatic(FileOperations.class);

	} 
    
    @Test
    public void readDataStoreTest() throws Exception{
 
        dataStore.setKey("abc");       
		Mockito.when(fileOpertions.initialize()).thenReturn(mapResponse);
		

	} 
    
    @Test
    public void deleteDataStoreTest() throws Exception{
  
        
        dataStore.setKey("abc");

		Mockito.when(fileOpertions.initialize()).thenReturn(mapResponse);
		PowerMockito.mockStatic(FileOperations.class);

	} 
    
    @Before 
    public void setAddLine() throws IOException {
    	FileOperations.addLine("test");
     }
    
    @Before 
    public void setRemoveLine() throws IOException {
    	FileOperations.removeLine("test");
     }

}
