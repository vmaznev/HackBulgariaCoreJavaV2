package com.hackbulgaria.corejava;

public class FaultyProblem8 {
	public int getNumberOfDigits(int someNumber) {
		int digitsCount = 0;
		
		while(someNumber != 0) {
			digitsCount++;
			someNumber = someNumber / 10;
		}
		return digitsCount;
	}
}
