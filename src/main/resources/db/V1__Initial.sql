CREATE TABLE IF NOT EXISTS driver (
  	driver_id INT NOT NULL AUTO_INCREMENT,
  	driver_name VARCHAR(128) NOT NULL,
  	location VARCHAR(128) NULL,
  	latitude DECIMAL(8,2) NULL,
  	longitude DECIMAL(8,2) NULL,
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
  	driver_id INT NOT NULL,
  	customer_id INT NOT NULL,
  	status VARCHAR(64) NOT NULL,
  	PRIMARY KEY (order_id)
	);