package com.hackbulgaria.corejava;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        if(number % 2 != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isPrime(int number) {
        if(number == 2) {
            return true;
        }
        if(number % 2 == 0) {
            return false;
        }
        for(int i = 3; i * i <= number; i = i + 2) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public int min(int... array) {
        int minimumElement = array[0];
        for(int number : array){
            if(number < minimumElement){
                minimumElement = number;
            }
        }
        return minimumElement;
    }

    @Override
    public int kthMin(int k, int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int swap;
                    swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
        return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
        float arrayAverage = 0;
        float arraySum = 0;
        float arrayCount = array.length;
        for(int i = 0; i < array.length; i++) {
            arraySum = arraySum + array[i];
        }
        arrayAverage = arraySum / arrayCount;
        return arrayAverage;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        long smallestMultiple = upperBound;
        int numsCounter = 0;
        boolean myChecker = false;
        do{
            for(int i = 1; i <= upperBound; i++) {
                if((smallestMultiple % i) == 0) {
                    numsCounter++;
                }
                else {
                    smallestMultiple++;
                    numsCounter = 0;
                    break;
                }
            }
            
            if(numsCounter == upperBound){
                myChecker = true;
            }
            
        } while(!(myChecker));  

        return smallestMultiple;
    }

    @Override
    public long getLargestPalindrome(long N) {
        long largestPalindrome = 0;
        long reversedNum = 0;
        
        long j = 0;
        
        for(long i = 10; i <= N; i++){
            j = i;
            while(j > 0) {
                reversedNum = reversedNum * 10 + j % 10;
                j = j / 10;
            }
            if(i == reversedNum){
                if(reversedNum > largestPalindrome){
                    largestPalindrome = reversedNum;
                }
            }
            reversedNum = 0;
        }
        
        return largestPalindrome;
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] result = new int[255];
        
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image.length; j++) {
                result[image[i][j]]++;
            }
        }
        
        return result;
    }

    @Override
    public long doubleFac(int n) {
        long fact = 1;
        for(int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        
        long result = 1;
        
        for(int j = 1; j <= fact; j++) {
            result = result * j;
        }
        return result;
    }

    @Override
    public long kthFac(int k, int n) {
        long result = 1;
        
        for(int i = 0; i < k; i++) {
            result = 1;
            for(int j = 1; j <= n; j++) {
                result = result * j;
            }
            n = (int) result;
        }
        
        return result;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        int oddTimesNumber;
        int myCounter = 0;
        
        for(int i = 0; i < array.length; i++) {
            
            oddTimesNumber = array[i];
            
            for(int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) {
                    myCounter++;
                }
            }
            
            if((myCounter % 2) != 0) {
                return oddTimesNumber;
            }
            
            myCounter = 0;
            
        }
        
        return 0;
    }

    @Override
    public long pow(int a, int b) {
        if(b == 0)
            return 1;
        else if(b == 1)
            return a;
        else if((b % 2) == 0) {
            return pow(a, b/2) * pow (a, b/2);
        }
        else{
            return a * pow(a, b-1);
        }
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        int maxSum = 0;
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int swap;
                    swap = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = swap;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    int swap;
                    swap = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = swap;
                }
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            maxSum = maxSum + (a[i] * b[i]);
        }
        
        return maxSum;
    }

    @Override
    public int maxSpan(int[] array) {
        int maximumSpan = 0;
        int tempSpan = 0;
        
        for(int i = 0; i < array.length; i++) {
            
            if(tempSpan > maximumSpan) {
                maximumSpan = tempSpan;
            }
            
            tempSpan = 0;
            
            for(int j = array.length - 1; j >= 0; j--) {
                if(array[i] == array[j]) {
                    tempSpan = j - i + 1;
                    break;
                }
            } 
        }
        
        return maximumSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        for(int i = 1; i < array.length; i++){
            
            int j;
            int sumFirstHalf = 0;
            int sumSecondHalf = 0;
            
            for(j = 0; j < i; j++) {
                sumFirstHalf += array[j];
            }
            
            for(int k = j; k < array.length; k++){
                sumSecondHalf += array[k];
            }
            
            if(sumFirstHalf == sumSecondHalf){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int sizeWidth = original.length;
        int sizeHeight = original[0].length;
        
        int[][] rescaledImage =new int[newWidth][newHeight];
        int scaledWidth = sizeWidth / newWidth;
        int scaledHeight = sizeHeight / newHeight;
        
        for(int i = 0; i < newWidth; i++){
            for(int j = 0; j < newHeight; j++){
                rescaledImage[i][j] = original[i * scaledWidth][j * scaledHeight];
            }
        }
             
        return rescaledImage;
    }

    @Override
    public String reverseMe(String argument) {
        String reversedString = "";
        
        for(int i = argument.length() - 1; i >= 0; i--) {
            reversedString = reversedString + argument.charAt(i);
        }
        
        return reversedString;
    }

    @Override
    public String copyEveryChar(String input, int k) {
        String endString = "";
        char[] arrayOfChars = input.toCharArray();
        
        for(int i = 0; i < arrayOfChars.length; i++) {
            for(int j = 0; j < k; j++) {
                endString = endString + arrayOfChars[i];
            }
        }
        
        return endString;
    }

    @Override
    public String reverseEveryWord(String arg) {
        String reversedString = "";
        
        String[] wordsSaver = arg.split("[ ]");
        
        for(int i = 0; i < wordsSaver.length; i++) {
            char[] arrayOfChars = wordsSaver[i].toCharArray();
            
            for(int k = arrayOfChars.length - 1; k >= 0; k--) {
                reversedString = reversedString + arrayOfChars[k];
            }
            if(i != wordsSaver.length - 1) {
                reversedString = reversedString + " ";
            }
        }
        
        return reversedString;
    }

    @Override
    public boolean isPalindrome(String argument) {
        String reversedString = "";
        
        for(int i = argument.length() - 1; i >= 0; i--) {
            reversedString = reversedString + argument.charAt(i);
        }
        
        if(argument.equals(reversedString)) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean isPalindrome(int number) {
        int reversedNumber = 0;
        int numberSaver = number;
        
        while(number > 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        if(numberSaver == reversedNumber) {
            return true;
        }
        return false;
    }

    @Override
    public int getPalindromeLength(String input) {
        int palindromeLength = 0;
        
        String[] twoParts = input.split("[*]");
        String firstPart = twoParts[0];
        String secondPart = twoParts[1];
        String firstPartReversed = "";
        
        for(int i = secondPart.length() - 1; i >= 0; i--) {
            firstPartReversed = firstPartReversed + firstPart.charAt(i);
        }
        
       for(int j = 0; j < firstPartReversed.length(); j++) {
           if(firstPartReversed.charAt(j) == secondPart.charAt(j)) {
               palindromeLength++;
           }
           else {
               break;
           }
       }
        
        return palindromeLength;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        int ocurrencesCounted = 0;
        
        java.util.regex.Pattern myPattern = java.util.regex.Pattern.compile(needle);
        java.util.regex.Matcher myMatcher = myPattern.matcher(haystack);
        
        while(myMatcher.find()) {
            ocurrencesCounted++;
        }
        
        return ocurrencesCounted;
    }

    @Override
    public String decodeURL(String input) {
        String decodedURL = input.replace("%20", " ").replace("%3A", ":").replace("%3D", "?").replace("%2F", "/");
        
        return decodedURL;
    }

    @Override
    public int sumOfNumbers(String input) {
        int sumOfIntegers = 0;
        char[] arrayOfChars = input.toCharArray();
        
        String stringSaver = "";
        int integerSaver = 0;
        
        for(int i = 0; i < arrayOfChars.length; i++) {
            if(arrayOfChars[i] == '-') {
                stringSaver = stringSaver + arrayOfChars[i];
            }
            if((arrayOfChars[i] >= '0') && (arrayOfChars[i] <= '9')) {
                stringSaver = stringSaver + arrayOfChars[i];
                
                if(i == (arrayOfChars.length - 1)) {
                    integerSaver = Integer.parseInt(stringSaver);
                }
                
            }
            else {
                if(!(stringSaver.isEmpty())) {
                    if(stringSaver.equals("-")) {
                        continue;
                    }
                    integerSaver = Integer.parseInt(stringSaver);
                    stringSaver = "";
                }
            }
            sumOfIntegers = sumOfIntegers + integerSaver;
            integerSaver = 0;
        }
        
        return sumOfIntegers;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        String stringOne = A.replaceAll("\\s+","");
        String stringTwo = B.replaceAll("\\s+","");
        
        char[] charArrayOne = stringOne.toCharArray();
        char[] charArrayTwo = stringTwo.toCharArray();
        
        int myCounter = 0;
        
        if(stringOne.length() != stringTwo.length()) {
            return false;
        }
        
        for(int i = 0; i < charArrayOne.length; i++) {
            for(int j = 0; j < charArrayTwo.length; j++) {
                if(charArrayOne[i] == charArrayTwo[j]) {
                    myCounter++;
                    break;
                }
            }
        }
        
        if(!(myCounter == charArrayOne.length)) {
            return false;
        }
        
        return true;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        for(int i = 0; i <= string2.length() - string.length(); i++){
            if(areAnagrams(string, string2.substring(i, string.length() + i)))
                return true;
        }
        
        return false;
    }

}
