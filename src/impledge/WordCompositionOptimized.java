package impledge;
import java.io.*;

import java.util.*;

public class WordCompositionOptimized {
    public static List<String> findCompoundedWords(List<String> words) {
    	// Sort words by length in descending order
    	PriorityQueue<String> sortedWords = new PriorityQueue<>(
            (x, y) -> y.length() - x.length()); 
        sortedWords.addAll(words);
        
        Set<String> wordSet = new HashSet<>(words);
        List<String> ans = new ArrayList<>();
        
        while (!sortedWords.isEmpty()) {
            String word = sortedWords.poll();
            wordSet.remove(word);
            
            if (isConstructed(word, wordSet)) {
                ans.add(word);
                if (ans.size() >= 2) {
                    break; 
                }
            }
        }
        
        return ans;
    }
    
    private static boolean isConstructed(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) {
            return false;
        }
        
        int size = word.length();
        for (int i = 1; i < size; i++) {
            String prev = word.substring(0, i);
            String next = word.substring(i);
            if (wordSet.contains(prev) && (wordSet.contains(next) || isConstructed(next, wordSet))) {
                return true;
            }
        }
        
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
	        System.out.println("---------------------------------------------------------------");
        }
    }
}
