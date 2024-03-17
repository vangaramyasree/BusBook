package com.busbook.BusBook.model;

public class Booking {
 
	 private Long id;
	    private Long busId;
	    private String passengerName;
	    private String status;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getBusId() {
			return busId;
		}
		public void setBusId(Long busId) {
			this.busId = busId;
		}
		public String getPassengerName() {
			return passengerName;
		}
		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

}
