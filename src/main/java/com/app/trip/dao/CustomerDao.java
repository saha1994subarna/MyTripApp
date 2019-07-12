package com.app.trip.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.trip.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	
		public Optional<Customer> findByCustomerId(Long customerId);

		public Customer findByCustomerName(String customerName);
		
	

}