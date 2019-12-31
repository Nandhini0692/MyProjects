package com.freshwork.solution.FreshWorksAssesment.dto;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	public String Status;
	public String Description;
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@Override
	public String toString() {
		return "Response [Status=" + Status + ", Description=" + Description + "]";
	}

}
