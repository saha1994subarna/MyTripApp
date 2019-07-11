package com.app.trip.pojos;

import java.io.Serializable;
import java.sql.Timestamp;

public class DriverDetails implements Serializable{

	private String name;
	
	private String location;
	
	private Double latitude;
	
	private Double longitude;
	
	public DriverDetails() {
		
	}
	public DriverDetails(String name, String location, Double latitude, Double longitude) {
		super();
		this.name = name;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	
	


}
