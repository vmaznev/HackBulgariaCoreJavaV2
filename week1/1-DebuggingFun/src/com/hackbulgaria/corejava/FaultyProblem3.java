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
<<<<<<< HEAD
        	reversedWords.append(reverse(word));
=======
            reversedWords.append(reverse(word));
            
>>>>>>> 24f36f1cb1e6b2378694702396e283e095ef74c3
        }
        
        return reversedWords.toString();
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
