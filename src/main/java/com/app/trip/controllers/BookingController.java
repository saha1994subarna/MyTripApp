package com.app.trip.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.trip.exceptions.BookingBusinessException;
import com.app.trip.pojos.BookingDetails;
import com.app.trip.pojos.CustomerDetails;
import com.app.trip.pojos.DriverDetails;
import com.app.trip.responses.DriverResponse;
import com.app.trip.services.BookingService;

@RestController
@RequestMapping("trip")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BookingController.class);
	
	//Making a new Booking -- Need to provide Customer Details-Name, Latitude and Longitude
	@PostMapping(path="/book")
	public DriverResponse bookCab(@RequestBody CustomerDetails customerDetails) throws BookingBusinessException{
		
		DriverResponse driverResponse = new DriverResponse();	
		DriverDetails driverDetails = new DriverDetails();

		if(null != customerDetails && null != customerDetails.getName() && !"".equals(customerDetails.getName())) {
			logger.info("[BookingController]  Received customerDetails: "+customerDetails);
			if(null != customerDetails.getLatitude() && null != customerDetails.getLongitude()
					&& !"".equals(customerDetails.getLatitude()) && !"".equals(customerDetails.getLongitude())) {

				driverDetails = bookingService.getNearestCab(customerDetails);
				logger.info("[BookingController]  driverDetails fetched successfully: "+driverDetails);
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
	
	@RequestMapping(path="/ongoing/view", method=RequestMethod.GET)
	public List<BookingDetails> viewAllCurrentCabsStatus(){
		
		List<BookingDetails> bookingDetails = new ArrayList<>();
		bookingDetails= bookingService.getAllCurrentCabsStatus();
		return bookingDetails;
		
	}
	
}
