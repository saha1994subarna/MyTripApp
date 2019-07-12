package com.app.trip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.trip.exceptions.BookingBusinessException;
import com.app.trip.pojos.DriverDetails;
import com.app.trip.services.DriverService;

@RestController
@RequestMapping("driver")
public class NewDriverController {

	//Logic to add new drivers to database

	@Autowired
	private DriverService driverService;

	@PostMapping(path="/add")
	public String addDriver(@RequestBody DriverDetails driverDetails) throws BookingBusinessException{

		driverService.saveDriver(driverDetails);
		
		return "Driver Logged In Successfully";
	}
	
	@RequestMapping(path = "/view", method = RequestMethod.GET)
	public List<DriverDetails> getAllAvailableDrivers(){
		List<DriverDetails> driverDetails =	driverService.getAllAvailableDriverDetails();
		return driverDetails;
		
	}

}