package com.janya.mvrg.ers.dto;

import java.util.List;

public class ResultListDto {

	public String eventName;
	public String conductedBy;
	public String location;

	public List<EventActivityDto> eventActivityDto;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getConductedBy() {
		return conductedBy;
	}

	public void setConductedBy(String conductedBy) {
		this.conductedBy = conductedBy;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<EventActivityDto> getEventActivityDto() {
		return eventActivityDto;
	}

	public void setEventActivityDto(List<EventActivityDto> eventActivityDto) {
		this.eventActivityDto = eventActivityDto;
	}
	
	

}
