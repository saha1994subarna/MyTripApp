package com.app.trip.responses;

import java.io.Serializable;
import java.sql.Timestamp;

public class DriverResponse implements Serializable{

	private String name;
	
	private String location;
	
	private Double rating;
	
	private Double distance;

	private Timestamp arrivingAt;
	
	public DriverResponse() {
		
	}
	
	public DriverResponse(String name, String location, Double rating, Double distance, Timestamp arrivingAt) {
		super();
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.distance = distance;
		this.arrivingAt = arrivingAt;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Timestamp getArrivingAt() {
		return arrivingAt;
	}

	public void setArrivingAt(Timestamp arrivingAt) {
		this.arrivingAt = arrivingAt;
	}

	@Override
	public String toString() {
		return "DriverResponse [name=" + name + ", location=" + location + ", rating=" + rating + ", distance="
				+ distance + ", arrivingAt=" + arrivingAt + "]";
	}

}
