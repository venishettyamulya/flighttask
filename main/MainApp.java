package com.myapp.main;

import java.util.List;
import java.util.Scanner;

import com.myapp.controller.FlightController;
import com.myapp.entity.Flight;


public class MainApp {
	
	Scanner sc = new Scanner(System.in);
	FlightController server = new FlightController();
	
	public static void main(String[] args) {
		
		MainApp app = new MainApp();
		
		while(true)
		{
			System.out.println("\n\n-------- App MENU ---------");
			System.out.println("1.Insert Flight");
			System.out.println("2.Display All Flights.");
			System.out.println("3.Search Flights by Carrier Name.");
			System.out.println("4.Search All Flight Between Source and Destination Airport");
			System.out.println("5.Search All Flight Between Source and Destination Airport with price filter");
			System.out.println("6.Search All Flight Between Source and Destination Airport & Date");
			System.out.println("0. EXIT ");
			
			System.out.println("-----Enter Choice :-");
			int choice = Integer.parseInt(app.sc.nextLine());
			
			switch (choice) {
			case 1:
				app.takeUserInputFlight();
				break;
			
			case 2:
				app.displayAllFlights();
				break;
			
				
			case 3:
				app.getFlightByCarrier();
				break;
			
			case 4:
				app.getFlightBtwSourceAndDestination();
				break;
				
			case 5:
				app.getFlightByPriceRange();
				break;
				
			case 6:
				app.getAllFlightsByDate();
				break;
				
			case 0:
				System.exit(0);
				break;
				
			default:
				break;
			}
		}
	}

		public void displayAllFlights() {
			List<Flight> allFlights = server.getAllFlights();
			
			System.out.println("\n\n ----All Saved Flights---");
			
			for (Flight flight : allFlights) {
				displayFlights(flight, "");
			}
			
		}
		
		
		private void displayFlights(Flight flight, String string) {
			// TODO Auto-generated method stub
			
		}

		public void takeUserInputFlight() {
			try {
				System.out.println("\n \t Enter Flight Details \n");
				System.out.println("\n Enter Flight carrier name");
				String carrierName = sc.nextLine();
				
				System.out.println("\n Enter source airport");
				String airportName = sc.nextLine();
				
				System.out.println("\n Enter destination airport");
				String destination = sc.nextLine();
				
				System.out.println("\n Enter takeoff time");
				float takeoff = Float.parseFloat(sc.nextLine());
				
				System.out.println("\n Enter landing time");
				float landoff = Float.parseFloat(sc.nextLine());
				
				System.out.println("\n Enter date");
				String date = sc.nextLine();
				
				System.out.println("\n Enter cost");
				int cost = Integer.parseInt(sc.nextLine());
				
				System.out.println("\n Enter flight duration");
				float flightduration=Float.parseFloat(sc.nextLine());
				
				
				Flight userInputFlight = new Flight(0,carrierName,airportName,destination,takeoff,landoff,date,cost,flightduration);
				Flight serverSavedFlight = server.insertFlight(userInputFlight);
				if(serverSavedFlight != null)
					displayFlights(serverSavedFlight,"Flight Inserted ");
				else displayErrors("Flight Not Saved , Try again or check Authority ");
				
			}
			catch (Exception e) {
				displayErrors("Wrong Input,Enter Again");
				takeUserInputFlight();	
			}
		}
		
		private void displayErrors(String string) {
			// TODO Auto-generated method stub
			
		}

		public void getFlightByCarrier() {
			System.out.println("\n Enter search Flight carrier name");
			String carrier = sc.nextLine();
			
			List<Flight> outputFlight=server.getFlightByCarrier(carrier);
			System.out.println("----All"+carrier+"-----");
			for(Flight flight : outputFlight) {
				displayFlights(flight,"");
			}
		}
		public void getFlightBtwSourceAndDestination() {
			System.out.println("\n Enter source of Flight");
			String source=sc.nextLine();
			
			System.out.println("\n Enter Destination of Flight");
			String destination=sc.nextLine();
			
			List<Flight> outputFlight=server.getFlightBtwSourceAndDestination(source, destination);
			System.out.println("----All flights Btw source and destination-----");
			for(Flight flight : outputFlight) {
				displayFlights(flight,"");
		}
		}
		
		public void getFlightByPriceRange() {
			System.out.println("\n Enter source of Flight");
			String source=sc.nextLine();
			
			System.out.println("\n Enter Destination of Flight");
			String destination=sc.nextLine();
			
			System.out.println("\n Enter Search Price Range 1 ");;
			int priceRange1 =Integer.parseInt(sc.nextLine());
			
			System.out.println("\n Enter Search Price Range 2 ");;
			int priceRange2 =Integer.parseInt(sc.nextLine());
			
			List<Flight> outputFlight=server.getFlightByPriceRange(source, destination,priceRange1,priceRange2);
			System.out.println("----All flights Btw "+source+" and"+ destination+"------");
			for(Flight flight : outputFlight) {
				displayFlights(flight,"");	
		}
			
		}
		
		public void getAllFlightsByDate()

		{

		System.out.println("\n Enter source airport:");
		String sourceAirport = sc.nextLine();
		System.out.println("\n Enter destination airport:");
		String destinationAirport = sc.nextLine();
		System.out.println("\n Enter the date:");
		String date = sc.nextLine();
		List<Flight> outputFlight = server.getAllFlightsByDate(sourceAirport , destinationAirport, date);
		System.out.println(" -------- Price of flights between source and destination --------------");

		for (Flight flight : outputFlight) {
			displayFlights(flight, "");

		}

		 

		}
}
		
		

