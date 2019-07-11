package com.app.trip.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.trip.entities.Bookings;
import com.app.trip.entities.Customer;

@Repository
public interface BookingDao extends JpaRepository<Bookings, Long> {

	public Optional<Bookings> findByBookingId(Long customerId);
	
}
