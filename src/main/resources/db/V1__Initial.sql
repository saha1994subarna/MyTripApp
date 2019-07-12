DROP TABLE IF EXISTS driver;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS bookings;

CREATE TABLE IF NOT EXISTS driver (
  	driver_id INT NOT NULL AUTO_INCREMENT,
  	driver_name VARCHAR(128) NOT NULL,
  	location VARCHAR(128) NULL,
  	latitude DECIMAL(8,2) NULL,
  	longitude DECIMAL(8,2) NULL,
  	status VARCHAR(128) NOT NULL,
  	PRIMARY KEY (driver_id)
  	);

CREATE TABLE IF NOT EXISTS customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
  	customer_name VARCHAR(128) NOT NULL,
   	location VARCHAR(128) NULL,
  	latitude DECIMAL(8,2) NULL,
  	longitude DECIMAL(8,2) NULL,
  	PRIMARY KEY (customer_id)
	);
  
CREATE TABLE IF NOT EXISTS bookings (
  	booking_id INT NOT NULL AUTO_INCREMENT,
  	driver INT NOT NULL,
  	customer INT NOT NULL,
  	status VARCHAR(64) NOT NULL,
  	PRIMARY KEY (booking_id)
	);
	
	

INSERT INTO customer (customer_id, customer_name, location, latitude, longitude) VALUES ('1', 'Supaureeya Saha', 'hadapsar', '12.5', '20.40');
INSERT INTO customer (customer_id, customer_name, location, latitude, longitude) VALUES ('2', 'Subarna Saha', 'viman nagar', '32.5', '28.40');

INSERT INTO driver (driver_id, driver_name, location, latitude, longitude, status) VALUES ('1', 'Arvind', 'saswad', '05.5', '02.40', 'Available');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude, status) VALUES ('2', 'Alok', 'kharadi', '25.5', '20.40', 'Available');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude, status) VALUES ('3', 'Bimal', 'pune station', '18.5', '22.40', 'Available');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude, status) VALUES ('4', 'Chayan', 'kalyani nagar', '35.5', '30.40', 'Available');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude, status) VALUES ('5', 'Ravi', 'wakad', '65.5', '60.40', 'Available');

INSERT INTO bookings(booking_id, driver, customer, status) VALUES ('101','1','','Available');
INSERT INTO bookings(booking_id, driver, customer, status) VALUES ('102','2','','Available');
INSERT INTO bookings(booking_id, driver, customer, status) VALUES ('103','3','','Available');
INSERT INTO bookings(booking_id, driver, customer, status) VALUES ('104','4','','Available');
INSERT INTO bookings(booking_id, driver, customer, status) VALUES ('105','5','','Available');
