package com.janya.mvrg.ers.dto;

import java.util.List;

import org.springframework.data.domain.Pageable;

public class ResultListDto {

	public String eventName;
	public String conductedBy;
	public String location;
	public Pageable pageable;
	public int currentSize;
	public int totalSize;

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

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

}
