package com.freshwork.solution.FreshWorksAssesment.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshwork.solution.FreshWorksAssesment.dto.DataStore;
import com.freshwork.solution.FreshWorksAssesment.dto.MapResponse;
import com.freshwork.solution.FreshWorksAssesment.dto.Response;

@Service
public class FreshWorkSolution{
	
	
	@Autowired
	FileOperations fileOpertions;
	
	@Autowired
	Response response;
	
	static Long start_time = System.currentTimeMillis();
	
	public Response createDatastore(DataStore dataStore) {

             //for(Object emp:employeeList) {
                // DataStore dataStore = (DataStore)freshWorkSolution.parseEmployeeObject( (JSONObject) emp );
                 System.out.println(dataStore);
                 
                 MapResponse mapResponse = fileOpertions.initialize();
                 
                 Map<String,String> dataStoreMap = mapResponse.getDataStoreMap();
                 Map<String,Long> timeMap = mapResponse.getTimeMap();

                 if (!dataStoreMap.containsKey(dataStore.getKey())) {
                     dataStoreMap.put(dataStore.getKey(),dataStore.getValue());
                     
                     if(!(dataStore.getTimetolive() == null)) {
                         timeMap.put(dataStore.getKey(),dataStore.getTimetolive());
                     }
       
                     try {
						fileOpertions.addLine(dataStore.getKey()+","+ dataStoreMap.get(dataStore.getKey())+
						         ","+ timeMap.get(dataStore.getKey())+System.currentTimeMillis());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                     response.setStatus("Create is successful");  
                     String description = dataStore.getKey() + "Key-Value pair is created";
                     response.setDescription(description);
                     
                     mapResponse.setDataStoreMap(dataStoreMap);
                     mapResponse.setTimeMap(timeMap);
                     
                	 }else {
                		 response.setStatus("Create Error"); 
                         response.setDescription("Key is already Found"); 
                	 }
                 
                 return response;
                 
	}
	public Response readDatastore(DataStore dataStore) {
		
		MapResponse mapResponse = fileOpertions.initialize();
        
        Map<String,String> dataStoreMap = mapResponse.getDataStoreMap();
        Map<String,Long> timeMap = mapResponse.getTimeMap();
              
        Long timeToLive = 0L;
        if(timeMap.containsKey(dataStore.getKey())) { 
        	timeToLive =  timeMap.get(dataStore.getKey());
        }
        System.out.println("Inside Read Operation: "+ dataStoreMap +  " Key:"+ dataStore.getKey());
                     
        if (dataStoreMap.containsKey(dataStore.getKey())) {
                    	 
        	if (timeToLive >= System.currentTimeMillis()||timeToLive == 0) {
        		System.out.println("Key "+ dataStore.getKey());
        		String description = dataStore.getKey() +"-"+dataStoreMap.get(dataStore.getKey());
                response.setStatus("Read is successful");  
                response.setDescription(description);    
             }else {
            	System.out.println("Key is expired "+ dataStore.getKey());
                dataStoreMap.remove(dataStore.getKey());
                if (timeMap.containsKey(dataStore.getKey())) {
                	timeMap.remove(dataStore.getKey());
                }
                response.setDescription("Read Error"); 
                response.setDescription("Key expired"); 
              }
						
         }else {
             response.setStatus("Read Error"); 
             response.setDescription("Key Not Found"); 
         }
                     
         return response;
	}
	public Response deleteDatastore(DataStore dataStore) {
                     
		MapResponse mapResponse = fileOpertions.initialize();
        
        Map<String,String> dataStoreMap = mapResponse.getDataStoreMap();
        Map<String,Long> timeMap = mapResponse.getTimeMap();
        
                     if (dataStoreMap.containsKey(dataStore.getKey())) {
                    	 try {
							fileOpertions.
							 removeLine(dataStore.getKey()+","+ dataStoreMap.get(dataStore.getKey())+
							         ","+ timeMap.get(dataStore.getKey()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                         dataStoreMap.remove(dataStore.getKey());
                         timeMap.remove(dataStore.getKey());

                         String description = dataStore.getKey() +" is deleted";
                         response.setStatus("Delete is successful"); 
                         response.setDescription(description);       
                     }else {
                    	 response.setStatus("Delete Error"); 
                         response.setDescription("Key Not Found");                          
                     }
                     
                     System.out.println("After Delete Operation");
                     
                     BufferedReader readerFile;
                     try {
                         readerFile = new BufferedReader(new FileReader("data.txt"));
                         String line = readerFile.readLine();
                         while (line != null) {
                             System.out.println(line);
                             line = readerFile.readLine();
                         }
                         readerFile.close();
                         
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                     return response;
	}
}