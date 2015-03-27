package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        
        StringBuilder reversedWords = new StringBuilder(); 
        String whiteSpace = " ";
        String prefix = "";
        
        for (String word: words){
        	reversedWords.append(prefix);
        	prefix = whiteSpace;
            reversedWords.append(reverse(word));
        }
        
        return reversedWords.toString();
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
