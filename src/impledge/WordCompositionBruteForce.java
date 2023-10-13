package impledge;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCompositionBruteForce {

	static HashMap<String,Boolean> visited = new HashMap<>();
	
	static String longest = "";
    static String secondLongest = "";

    public static List<String> findCompoundedWords(List<String> words) {
        HashSet<String> set = new HashSet<>(words);
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (isConcatenated(word, set)) {
                ans.add(word);
            }
        }
        return Arrays.asList(longest, secondLongest);
    }

    private static boolean isConcatenated(String word, HashSet<String> set) {
        if (visited.containsKey(word)) {
            return visited.get(word);
        }
        int size = word.length();
        for (int i = 0; i < size; i++) {
            String prev = word.substring(0, i + 1);
            String next = word.substring(i + 1, size);
            if ((set.contains(prev) && set.contains(next)) ||
                    (set.contains(prev) && isConcatenated(next, set))) {
            	visited.put(word, true);
                if (word.length() > longest.length()) {
                    secondLongest = longest;
                    longest = word;
                } else if (word.length() > secondLongest.length() && !word.equals(longest)) {
                    secondLongest = word;
                }
                return true;
            }
        }
        visited.put(word, false);
        return false;
    }

    public static void main(String[] args) {
    	
    	long startTime = System.currentTimeMillis();
    	String input1 = "E:\\Impledge Technologies\\Input_01.txt";
    	String input2 = "E:\\Impledge Technologies\\Input_02.txt";
        String [] filePaths  = {input1,input2};
        
        int inputCount = 0;
        
        for(String filepath : filePaths) {
        	
			List<String> words = new ArrayList<>();
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                words.add(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        long endTime = System.currentTimeMillis();
	        
	        List<String> ans = findCompoundedWords(words);
	        inputCount++;
	        
	        if (ans.size() >= 2) {
	        	System.out.println("Output for Input_0"+inputCount+".txt");
	            System.out.println("Longest Compound Word: " + ans.get(0));
	            System.out.println("Second Longest Compound Word: " + ans.get(1));
	            System.out.println("Time taken to process only Input_0"+inputCount+".txt : " + (endTime - startTime) + " milliseconds");

	        } else {
	            System.out.println("No Compound words found.");
	        }
	        System.out.println("---------------------------------------------------");
        }
    	
    }
}



