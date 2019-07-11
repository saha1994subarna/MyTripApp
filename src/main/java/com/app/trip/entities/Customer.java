package com.app.trip.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
		public Customer() {
			
		}
	
		@Id
	    @GeneratedValue
	    @Column(name = "customer_id", unique = true, nullable = false)
		private Long customerId;
		
		@Column(name = "customer_name", nullable = false)
		private String customerName;
		
		@Column(name = "location")
		private String location;
		
		@Column(name = "latitude")
		private String latitude;
		
		@Column(name = "longitude")
		private Long longitude;
		
		@Column(name = "status")
		private String status;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
			result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
			result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
			result = prime * result + ((location == null) ? 0 : location.hashCode());
			result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			return result;
		}

		public Customer(Long customerId, String customerName, String location, String latitude, Long longitude,
				String status) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.location = location;
			this.latitude = latitude;
			this.longitude = longitude;
			this.status = status;
		}

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", location=" + location
					+ ", latitude=" + latitude + ", longitude=" + longitude + ", status=" + status + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Customer other = (Customer) obj;
			if (customerId == null) {
				if (other.customerId != null)
					return false;
			} else if (!customerId.equals(other.customerId))
				return false;
			if (customerName == null) {
				if (other.customerName != null)
					return false;
			} else if (!customerName.equals(other.customerName))
				return false;
			if (latitude == null) {
				if (other.latitude != null)
					return false;
			} else if (!latitude.equals(other.latitude))
				return false;
			if (location == null) {
				if (other.location != null)
					return false;
			} else if (!location.equals(other.location))
				return false;
			if (longitude == null) {
				if (other.longitude != null)
					return false;
			} else if (!longitude.equals(other.longitude))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public Long getLongitude() {
			return longitude;
		}

		public void setLongitude(Long longitude) {
			this.longitude = longitude;
		}
		
		

}
