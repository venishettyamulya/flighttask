package com.myapp.util;

import java.util.Random;

public class FlightUtil {
	public static int getRandomID()
	{
		Random random = new Random();
		
		int flightId = random.nextInt();
		return flightId;
	}

}
