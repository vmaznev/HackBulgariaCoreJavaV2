package com.hackbulgaria.corejava;

public class FaultyProblem8 {

	public int getNumberOfDigits(int someNumber) {
<<<<<<< HEAD
	    int digitsCount = 0;
	    
	    while(someNumber != 0) {
	        digitsCount++;
	        someNumber = someNumber / 10;
	    }
	    
	    return digitsCount;
=======
		int digitsCount = 0;
		
		while(someNumber != 0) {
			digitsCount++;
			someNumber = someNumber / 10;
		}
		return digitsCount;
		
>>>>>>> 24f36f1cb1e6b2378694702396e283e095ef74c3
	}
}
