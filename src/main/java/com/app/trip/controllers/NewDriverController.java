package com.app.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	public String addDriver(@RequestBody DriverDetails driverDetails) throws BookingBusinessException{

		driverService.saveDriver(driverDetails);
		
		return "Driver Logged In Successfully";
	}

}