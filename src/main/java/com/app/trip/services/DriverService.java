package com.app.trip.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.trip.controllers.BookingController;
import com.app.trip.dao.DriverDao;
import com.app.trip.entities.Driver;
import com.app.trip.pojos.DriverDetails;

@Service
public class DriverService {

	@Autowired
	private DriverDao driverDao;
	
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BookingController.class);
	
	public List<Driver> getAllDrivers(){

		List<Driver>  drivers = new ArrayList<Driver>();
		drivers = driverDao.findAll();

		return drivers;
	}
	
	public List<DriverDetails> getAllAvailableDriverDetails(){
		
		List<Driver> drivers = getAvailableDrivers("Available");
		if(null != drivers)
			System.out.println("Drivers are: "+drivers);
		List<DriverDetails> driverDetails = new ArrayList<>();
		
		if(null != drivers)
		for(Driver d: drivers) {
			DriverDetails driverDetail = new DriverDetails();
			if(null != d) {
				driverDetail.setName(d.getDriverName());
				driverDetail.setLocation(d.getLocation());
				driverDetail.setLatitude(d.getLatitude());
				driverDetail.setLongitude(d.getLongitude());
				driverDetail.setStatus(d.getStatus());
			}
			driverDetails.add(driverDetail);
		}
		return driverDetails;
	}
	
	@Transactional
	public void saveDriver(DriverDetails driverDetails) {
		
		Driver driver = new Driver();
		driver.setDriverName(driverDetails.getName());
		driver.setLocation(driverDetails.getLocation());
		driver.setLatitude(driverDetails.getLatitude());
		driver.setLongitude(driverDetails.getLongitude());
		driver.setStatus("Available");
		driverDao.save(driver);
		
	}
	
	public void updateDriverStatus(DriverDetails driverDetails) {
		
		Driver driver = findDriverIdByName(driverDetails.getName());
		if(null != driver) {
		driver.setStatus("Busy");
		driverDao.save(driver);
		}
	}
	
	public Driver findDriverIdByName(String driverName) {
		
		Driver driver = driverDao.findByDriverName(driverName);
		
		return driver;
	}
	
//TO-DO: Get Drivers by Status: Available
	
	public List<Driver> getAvailableDrivers(String status){
		
		List<Driver>  drivers = new ArrayList<Driver>();
		drivers = driverDao.findDriversByStatus(status);
		return drivers;
		
	}
}
