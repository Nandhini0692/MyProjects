package com.freshwork.solution.FreshWorksAssesment.dto;

import org.springframework.stereotype.Component;

@Component
public class DataStore{
	
	public String key;
	public String value;
	public Long timetolive;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getTimetolive() {
		return timetolive;
	}
	public void setTimetolive(Long timetolive) {
		this.timetolive = timetolive;
	}
	@Override
	public String toString() {
		return "DataStore [key=" + key + ", value=" + value + ", timetolive=" + timetolive + "]";
	}
	
}