package com.app.trip.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.trip.dao.BookingDao;
import com.app.trip.entities.Bookings;
import com.app.trip.entities.Customer;
import com.app.trip.entities.Driver;
import com.app.trip.pojos.CustomerDetails;
import com.app.trip.pojos.DriverDetails;

@Service
public class BookingService {

	@Autowired
	private DriverService driverService;

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerService customerService;

	public DriverDetails getNearestCab(CustomerDetails customerDetails) {
		
		// Get the list of all drivers
		//TO-DO: Fetch List of only Available Drivers
		List<Driver>  drivers = new ArrayList<Driver>();
		drivers = driverService.getAllDrivers();
		DriverDetails driverDetails = new DriverDetails();
		
		//Save new customer
		customerService.saveCustomer(customerDetails);
		
		Map<Driver, Double> distancesOfDrivers = new HashMap<Driver, Double>();
		
		if(null != drivers)
		for(Driver d: drivers) {
			if(null != d) {
			Double distance = Math.sqrt((d.getLatitude()-customerDetails.getLatitude())*(d.getLatitude()-customerDetails.getLatitude()) + (d.getLongitude()-customerDetails.getLongitude())*(d.getLongitude()-customerDetails.getLongitude()));
			distancesOfDrivers.put(d, distance);
			}
		}
		Driver finalDriver = getMinKey(distancesOfDrivers);
		
		if(null != finalDriver && null != finalDriver.getDriverId() && !"".equals(finalDriver.getDriverName()) && !"".equals(finalDriver.getLocation())){
			driverDetails.setName(finalDriver.getDriverName());
			driverDetails.setLocation(finalDriver.getLocation());
			//driverDetails.setDistance(distance);
			//driverDetails.setArrivingAt(sysDate + distance/40);
		}
		return driverDetails;

	}

	private Driver getMinKey(Map<Driver, Double> map) {
		Driver minKey = new Driver();
		Double minValue = (double) Integer.MAX_VALUE;
		for(Driver key : map.keySet()) {
			Double value = map.get(key);
			if(value < minValue) {
				minValue = value;
				minKey = key;
			}
		}
		return minKey;	
	}

	public void updateDriverStatus(DriverDetails driverDetails) {
		Driver driver = new Driver();
		
		if(null != driverDetails) {
		driver = driverService.findDriverIdByName(driverDetails.getName());
		}
			driverService.updateDriverStatus(driverDetails);
		
	}

	public void updateBookingsData(DriverDetails driverDetails, CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		driver = driverService.findDriverIdByName(driverDetails.getName());
		if(null != driver) {
		Customer customer = new Customer();
		customer = customerService.findDriverIdByName(customerDetails.getName());
		//bookingDao.findByBookingId(customerId)
		
		Bookings booking = new Bookings();
		if(null != customer) {
		booking.setDriverId(driver);
		booking.setCustomerId(customer);
		booking.setStatus("In-Transit");
		bookingDao.save(booking);
		}
		}
	}

	
}
