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
	private Long bookingId;
	
	@ManyToOne
    @JoinColumn(name = "driver_id")
	private Driver driver;
	
	@ManyToOne
    @JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "status")
	private String status;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Driver getDriverId() {
		return driver;
	}

	public void setDriverId(Driver driverId) {
		this.driver = driverId;
	}

	public Customer getCustomerId() {
		return customer;
	}

	public void setCustomerId(Customer customerId) {
		this.customer = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
