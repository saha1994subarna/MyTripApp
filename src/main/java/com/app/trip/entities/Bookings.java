package com.app.trip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {

	public Bookings() {
		
	}
	
	@Id
	@GeneratedValue
	@Column(name = "booking_id", nullable= false, unique = true)
	private Long BookingId;
	
	@ManyToOne
    @JoinColumn(name = "driver_id")
	private Long DriverId;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	private Long CustomerId;
	
	@Column(name = "status")
	private String Status;

	public Long getBookingId() {
		return BookingId;
	}

	public void setBookingId(Long bookingId) {
		BookingId = bookingId;
	}

	public Long getDriverId() {
		return DriverId;
	}

	public void setDriverId(Long driverId) {
		DriverId = driverId;
	}

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
}
