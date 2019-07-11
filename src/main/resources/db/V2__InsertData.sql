
INSERT INTO customer (customer_id, customer_name, location, latitude, longitude) VALUES ('1', 'Supaureeya Saha', 'hadapsar', '12.5', '20.40');
INSERT INTO customer (customer_id, customer_name, location, latitude, longitude) VALUES ('2', 'Subarna Saha', 'viman nagar', '32.5', '28.40');

INSERT INTO driver (driver_id, driver_name, location, latitude, longitude) VALUES ('1', 'Arvind', 'saswad', '05.5', '02.40');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude) VALUES ('2', 'Alok', 'kharadi', '25.5', '20.40');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude) VALUES ('3', 'Bimal', 'pune station', '18.5', '22.40');
INSERT INTO driver (driver_id, driver_name, location, latitude, longitude) VALUES ('2', 'Chayan', 'kalyani nagar', '35.5', '30.40');

INSERT INTO bookings (booking_id, driver_id, customer_id, status) VALUES ('100', '1', '2',  'AVAILABLE');
INSERT INTO bookings (booking_id, driver_id, customer_id, status) VALUES ('101', '1', '1', 'AVAILABLE');
INSERT INTO bookings (booking_id, driver_id, customer_id, status) VALUES ('102', '1', '6',  'AVAILABLE');
INSERT INTO bookings (booking_id, driver_id, customer_id, status) VALUES ('103', '1', '7', 'AVAILABLE');
