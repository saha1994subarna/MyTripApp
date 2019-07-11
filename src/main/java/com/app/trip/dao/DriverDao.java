package com.app.trip.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.trip.entities.Driver;

@Repository
public interface DriverDao extends JpaRepository<Driver, Long> {

	static final String GET_DRIVER_BY_STATUS = "select d.driver_id, d.driver_name, d.location, d.latitude, d.longitude from driver d"
			+ " left join booking b on b.driver_id=d.driver_id where b.status=?";
	
		/* @PersistenceContext 
	 EntityManager entityManager;*/
	 

	public Optional<Driver> findByDriverId(Long customerId);

	
//	Optional<List<Driver>> findDriversByStatus(String status, Sort sort);
//TO-DO: Fix entity manager issue and use typed query 
	
	
	/*default Optional<List<Driver>> findAvailableDrivers(){
		 Query query = entityManager.createNativeQuery(GET_DRIVER_BY_STATUS);
	        query.setParameter(1, "Available");

	        List<Driver> driverList = new ArrayList<Driver>();

	        if (query != null) {

	            final List<Object[]> stList = (List<Object[]>) query.getResultList();

	            for (Object[] objects : stList) {

	                Driver driver = new Driver();
	                driver.setDriverId(((BigDecimal)objects[0]).longValue());
	                driver.setDriverName(String.valueOf(objects[1]));
	                driver.setLocation(String.valueOf(objects[2]));
	                driver.setLatitude(((BigDecimal)objects[3]).doubleValue());
	                driver.setLongitude(((BigDecimal)objects[4]).doubleValue());
	                driverList.add(driver);
	             }
	        }
		return Optional.ofNullable(driverList);

	}*/
}
