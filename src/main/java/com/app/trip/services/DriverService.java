package com.app.trip.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.trip.dao.DriverDao;
import com.app.trip.entities.Driver;
import com.app.trip.pojos.DriverDetails;

@Service
public class DriverService {

	@Autowired
	private DriverDao driverDao;
	
	public List<Driver> getAllDrivers(){

		List<Driver>  drivers = new ArrayList<Driver>();
		drivers = driverDao.findAll();

		return drivers;
	}
	
	@Transactional
	public void saveDriver(DriverDetails driverDetails) {
		
		Driver driver = new Driver();
		driver.setDriverName(driverDetails.getName());
		driver.setLocation(driverDetails.getLocation());
		driver.setLatitude(driverDetails.getLatitude());
		driver.setLongitude(driverDetails.getLongitude());
		driverDao.save(driver);
		
	}
	
//TO-DO: Get Drivers by Status: Available
	
	/*public List<Driver> getAvailableDrivers(){
		
		List<Driver>  drivers = new ArrayList<Driver>();
		drivers = driverDao.findAll(arg0)
		return drivers;
		
	}*/
}
