package com.freshwork.solution.FreshWorksAssesment.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.freshwork.solution.FreshWorksAssesment.dto.DataStore;
import com.freshwork.solution.FreshWorksAssesment.dto.Response;
import com.freshwork.solution.FreshWorksAssesment.service.FreshWorkSolution;

@RestController
public class FreshWorksSolutionController {

	@Autowired
	public DataStore dataStore;
	
	@Autowired
	public FreshWorkSolution freshWorkSolution;


	@PostMapping("/datastore/read")
	public Response readDataStore(@Valid @RequestBody DataStore dataStore) {
		
		Response response = freshWorkSolution.readDatastore(dataStore);

		return response;

	}

	@PostMapping("/datastore/create")
	public Response createDataStore(@RequestBody DataStore dataStore) {
		
		System.out.println("/datastore/create : " +dataStore);
		Response response = freshWorkSolution.createDatastore(dataStore);

		return response;

	}
	
	@DeleteMapping("/datastore/delete")
	public Response deleteDataStore(@RequestBody DataStore dataStore) {
		
		System.out.println("/datastore/create : " +dataStore);
		Response response = freshWorkSolution.deleteDatastore(dataStore);

		return response;

	}

}

