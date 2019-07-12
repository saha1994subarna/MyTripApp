package com.app.trip.pojos;

import java.io.Serializable;

public class BookingDetails implements Serializable{
	
	private Long bookingId;
	
	private Long driverId;
	
	private Long customerId;
	
	private String status;

	public BookingDetails() {
		
	}
	
	public BookingDetails(Long bookingId, Long driverId, Long customerId, String status) {
		super();
		this.bookingId = bookingId;
		this.driverId = driverId;
		this.customerId = customerId;
		this.status = status;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", driverId=" + driverId + ", customerId=" + customerId
				+ ", status=" + status + "]";
	}

}
