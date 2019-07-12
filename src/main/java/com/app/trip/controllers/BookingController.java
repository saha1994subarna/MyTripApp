package com.app.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.trip.exceptions.BookingBusinessException;
import com.app.trip.pojos.CustomerDetails;
import com.app.trip.pojos.DriverDetails;
import com.app.trip.responses.DriverResponse;
import com.app.trip.services.BookingService;

@RestController
@RequestMapping("trip")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	//Making a new Booking -- Need to provide Customer Details-Name, Latitude and Longitude
	@PostMapping(path="/book")
	public DriverResponse bookCab(@RequestBody CustomerDetails customerDetails) throws BookingBusinessException{
		
		DriverResponse driverResponse = new DriverResponse();	
		DriverDetails driverDetails = new DriverDetails();

		if(null != customerDetails && null != customerDetails.getName() && !"".equals(customerDetails.getName())) {

			if(null != customerDetails.getLatitude() && null != customerDetails.getLongitude()
					&& !"".equals(customerDetails.getLatitude()) && !"".equals(customerDetails.getLongitude())) {

				driverDetails = bookingService.getNearestCab(customerDetails);
				if(null != driverDetails) {
					driverResponse.setName(driverDetails.getName());
					driverResponse.setLocation(driverDetails.getLocation());
				}
				
				//Update Status of Cab Driver to Busy
				bookingService.updateDriverStatus(driverDetails);
				bookingService.updateBookingsData(driverDetails, customerDetails);
			}
		}
		return driverResponse;

	}
}
