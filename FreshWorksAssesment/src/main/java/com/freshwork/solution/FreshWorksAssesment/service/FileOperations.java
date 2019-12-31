package com.freshwork.solution.FreshWorksAssesment.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshwork.solution.FreshWorksAssesment.dto.MapResponse;

@Service
public class FileOperations {
	
	@Autowired
	MapResponse mapResponse;
	
	public synchronized MapResponse initialize(){

    Map<String, String> dataStoreMap = new ConcurrentHashMap<String, String>();
    Map<String, Long> timeMap = new ConcurrentHashMap<String, Long>();
    
        BufferedReader readerFile;
        
        try {
        	readerFile = new BufferedReader(new FileReader("data.txt"));
            String line = readerFile.readLine();
            while (line != null) {
                String delims = ",";
                String[] tokens = line.split(delims);
                for (int i = 0; i < tokens.length; i++) {
                    System.out.println(tokens[i]);
                }
                if (!(tokens[0] == null)) {
                	dataStoreMap.put(tokens[0], tokens[1]);
                	if(!(tokens[2] == null)) {
                		timeMap.put(tokens[0], Long.parseLong(tokens[2]));
                	}
                }
                line = readerFile.readLine();
            }
            System.out.println(dataStoreMap+","+timeMap);
            
            mapResponse.setDataStoreMap(dataStoreMap);
            mapResponse.setTimeMap(timeMap);
            
            readerFile.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return mapResponse;
	}
	
    public static synchronized void removeLine(String lineContent) throws IOException
    {   
    	System.out.println("File removeLine");
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
        
        System.out.println("File removeLine: " + lineContent);
        
        File file = new File("data.txt");
        File temp = File.createTempFile("temp", "temp");
        PrintWriter out = new PrintWriter(new FileWriter(temp));
        Files.lines(file.toPath())
            .filter(line -> !line.contains(lineContent))
            .forEach(out::println);
        out.flush();
        out.close();

        FileReader fr=new FileReader(temp);  
        File fileR =new File("data.txt");
        FileWriter writer = new FileWriter(fileR);  
        int i;    
        while((i=fr.read())!=-1) {   
        	System.out.print((char)i);
        	writer.write((char)i);
        }
        fr.close(); 
        writer.close();
    }
    
    public static synchronized void addLine(String lineContent) throws IOException
    {	
    	File file =  new File("data.txt");
    	System.out.println("File opened");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter writer = new BufferedWriter(fw);
		writer.write(lineContent+"\r\n");
		writer.close();
    }
    
}
