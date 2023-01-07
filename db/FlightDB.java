package com.myapp.db;

import java.util.ArrayList;
import java.util.List;

import com.myapp.entity.Flight;
import com.myapp.util.FlightUtil;

public class FlightDB {
  
	List<Flight> allFlights = new ArrayList<>();
	
	
	public List<Flight> getAllFlight()
	{
		return allFlights;
	}
	public Flight saveFlightInDB1(Flight flight)
	{
		if(flight != null)
		{
			flight.setFlightId(FlightUtil.getRandomID());
			boolean status = allFlights.add(flight);
			if(status) return flight;
			else return  null;
		}
		else
		{
			return null;
		}
		
	}
	
	public List<Flight> getAllFlightByCarrier(String searchCarrier)
	{
	
		
		List<Flight> outputFlights = new ArrayList<>();
		
		for (Flight flight : allFlights) {
			if(flight.getCarrierName().equalsIgnoreCase(searchCarrier))
			{
				outputFlights.add(flight);
			}
		}
		
		return outputFlights;
	}
	
	public List<Flight> getFlightBtwSourceAndDestination(String source,String destination)
	{
	
		
		List<Flight> outputFlights = new ArrayList<>();
		
		for (Flight flight : allFlights) {
			if(flight.getSourceAirport().equalsIgnoreCase(source) && flight.getSourceAirport().equalsIgnoreCase(destination))
			{
				outputFlights.add(flight);
			}
		}
		
		return outputFlights;
	}
	
	
	public List<Flight> getFlightByPriceRange(String source,String destination,int priceRange1,int priceRange2)
	{
		
		
		List<Flight> outputFlights = new ArrayList<>();
		
		for (Flight flight : allFlights) {
			if(flight.getSourceAirport().equalsIgnoreCase(source) && flight.getSourceAirport().equalsIgnoreCase(destination))
			{
				outputFlights.add(flight);
			}
		}
		
		return outputFlights;
	}
	
	public List<Flight> getFlightByDate(String source,String destination,String date)
	{
		
		
		List<Flight> outputFlights = new ArrayList<>();
		
		for (Flight flight : allFlights) {
			if(flight.getSourceAirport().equalsIgnoreCase(source) && flight.getSourceAirport().equalsIgnoreCase(destination) && flight.getDate().equalsIgnoreCase(date))
			{
				outputFlights.add(flight);
			}
		}
		
		return outputFlights;
	}
	public List<Flight> getAllFlightByCategoryAndPriceRange(String userInputCategory, int searchRange1,
			int searchRange2) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Flight> getAllFlightsByDate(String source, String destination, String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	}
