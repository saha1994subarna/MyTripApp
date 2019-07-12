package com.app.trip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.trip.dao.CustomerDao;
import com.app.trip.entities.Customer;
import com.app.trip.entities.Driver;
import com.app.trip.pojos.CustomerDetails;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Transactional
	public void saveCustomer(CustomerDetails customerDetails) {
		
		Customer customer = new Customer();
		customer.setCustomerName(customerDetails.getName());
		customer.setLocation(customerDetails.getLocation());
		customer.setLatitude(customerDetails.getLatitude());
		customer.setLongitude(customerDetails.getLongitude());
		//driver.setStatus("Available");
		customerDao.save(customer);
		
	}
	
public Customer findDriverIdByName(String customerName) {
		
	Customer customer = customerDao.findByCustomerName(customerName);
		
		return customer;
	}

}
