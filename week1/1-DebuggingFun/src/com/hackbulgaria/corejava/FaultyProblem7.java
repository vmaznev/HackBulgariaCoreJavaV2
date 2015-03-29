package com.hackbulgaria.corejava;

import java.lang.Thread.State;

public class FaultyProblem7 {
    public static int binarySearch(int element, int... array) {

        int low = 0;
        int high = array.length - 1;
        
        while (high - low > 1) {
        	
            int mid = (low + high) / 2;

            if (element == array[mid]) {
                return mid;
            }
            if (element < array[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (array[high] == element)
            return high;
        if (array[low] == element)
            return low;

        return -1; // Not Found...!
    }
}
