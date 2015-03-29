package com.hackbulgaria.corejava;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FaultyProblem8Test {
	private FaultyProblem8 faultyProgram;
	
    @Before
    public void setUp(){
        this.faultyProgram = new FaultyProblem8();
    }
    
    //F5 -> IN!
    //F6 
    // |
    // next line
    //F7 <-- out
    
    @Test
    public void test() {
        assertEquals(1, faultyProgram.getNumberOfDigits(2));
        assertEquals(1, faultyProgram.getNumberOfDigits(-1));
        assertEquals(3, faultyProgram.getNumberOfDigits(126));
        assertEquals(3, faultyProgram.getNumberOfDigits(908));
    }

	
}
