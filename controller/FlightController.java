package com.myapp.controller;

import java.util.List;

import com.myapp.db.FlightDB;
import com.myapp.entity.Flight;

//server code
public class FlightController {
	FlightDB db;

	public FlightController() {
		db = new FlightDB();
	}

	public List<Flight> getAllFlights() {
		return db.getAllFlight();
	}

	public Flight insertFlight(Flight userInputflight) {
		System.out.println(userInputflight);
		Flight savedFlight = db.saveFlightInDB1(userInputflight);
		return savedFlight;

	}

	public List<Flight> getFlightByCarrier(String userInputCarrier) {
		return db.getAllFlightByCarrier(userInputCarrier);
	}
	
	public List<Flight> getFlightBtwSourceAndDestination(String userInputCarrier, String destination) {
		return db.getFlightBtwSourceAndDestination(userInputCarrier, userInputCarrier);
	}
	
	public List<Flight> getFlightByPriceRange(String source, String destination, int priceRange1, int priceRange2) {
		return db.getFlightByPriceRange(source,destination,priceRange1,priceRange2);
	}
	public List<Flight> getAllFlightsByDate(String source, String destination, String date) {
		return db.getAllFlightsByDate(source,destination,date);
	}


	

}
