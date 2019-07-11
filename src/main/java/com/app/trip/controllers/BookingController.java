package com.app.trip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.trip.exceptions.BookingBusinessException;
import com.app.trip.pojos.CustomerDetails;
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

		DriverResponse driverDetails = new DriverResponse();

		if(null != customerDetails && null != customerDetails.getName() && !"".equals(customerDetails.getName())) {

			if(null != customerDetails.getLatitude() && null != customerDetails.getLongitude()
					&& !"".equals(customerDetails.getLatitude()) && !"".equals(customerDetails.getLongitude())) {

				driverDetails = bookingService.getNearestCab(customerDetails);
			}
		}
		return driverDetails;

	}
}
