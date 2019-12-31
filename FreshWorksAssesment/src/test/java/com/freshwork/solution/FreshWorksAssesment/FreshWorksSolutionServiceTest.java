package com.freshwork.solution.FreshWorksAssesment;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.freshwork.solution.FreshWorksAssesment.dto.DataStore;
import com.freshwork.solution.FreshWorksAssesment.dto.MapResponse;
import com.freshwork.solution.FreshWorksAssesment.service.FileOperations;
import com.freshwork.solution.FreshWorksAssesment.service.FreshWorkSolution;


@RunWith(SpringRunner.class)
public class FreshWorksSolutionServiceTest {
	
	@InjectMocks
	FreshWorkSolution freshWorksSolution;
	
	@InjectMocks
	FileOperations fileOpertions;
	
	@Autowired
	DataStore dataStore;
	
	@Autowired
	MapResponse mapResponse;


    @Test
    public void createDataStoreTest() throws Exception{
  
        DataStore dataStore = new DataStore();
        dataStore.setKey("abc");
        dataStore.setTimetolive(112L);
        dataStore.setValue("test");
        
		Mockito.when(fileOpertions.initialize()).thenReturn(mapResponse);
		PowerMockito.mockStatic(FileOperations.class);
		Assert.assertNotNull(freshWorksSolution.createDatastore(dataStore));
	} 
    
    @Test
    public void readDataStoreTest() throws Exception{
 
        DataStore dataStore = new DataStore();
        dataStore.setKey("abc");       
		Mockito.when(fileOpertions.initialize()).thenReturn(mapResponse);
		Assert.assertNotNull(freshWorksSolution.readDatastore(dataStore));

	} 
    
    @Test
    public void deleteDataStoreTest() throws Exception{
  
        DataStore dataStore = new DataStore();
        dataStore.setKey("abc");

		Mockito.when(fileOpertions.initialize()).thenReturn(mapResponse);
		PowerMockito.mockStatic(FileOperations.class);
		Assert.assertNotNull(freshWorksSolution.deleteDatastore(dataStore));

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
