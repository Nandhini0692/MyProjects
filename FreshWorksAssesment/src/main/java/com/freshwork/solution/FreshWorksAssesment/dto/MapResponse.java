package com.freshwork.solution.FreshWorksAssesment.dto;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MapResponse {

	public Map<String,String> dataStoreMap;
	public Map<String,Long> timeMap;
	
	public Map<String, String> getDataStoreMap() {
		return dataStoreMap;
	}
	public void setDataStoreMap(Map<String, String> dataStoreMap) {
		this.dataStoreMap = dataStoreMap;
	}
	public Map<String, Long> getTimeMap() {
		return timeMap;
	}
	public void setTimeMap(Map<String, Long> timeMap) {
		this.timeMap = timeMap;
	}
	
	@Override
	public String toString() {
		return "MapResponse [dataStoreMap=" + dataStoreMap + ", timeMap=" + timeMap + "]";
	}
	
	
}
