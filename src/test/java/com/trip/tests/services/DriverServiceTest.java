package com.trip.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.trip.entities.Driver;
import com.app.trip.pojos.DriverDetails;
import com.app.trip.services.DriverService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {
	
	@Autowired
	private DriverService driverService;
	
	@Test
	public void testGetAllDrivers() {
		List<Driver> drivers =driverService.getAllDrivers();
		assertNotNull(drivers);
	}
	
	@Test
	public void testGetAllAvailableDriverDetails() {
		List<DriverDetails> driverDetails = driverService.getAllAvailableDriverDetails();
		assertNotNull(driverDetails);
	}

	@Test
	public void testFindDriverIdByName() {
		Driver driver =driverService.findDriverIdByName("Chayan");
		assertNotNull(driver);
	}
}
