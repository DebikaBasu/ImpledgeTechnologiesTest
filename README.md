
# Word Composition Problem

To find words constructed by concatenating shorter words also found in the file.

## 🛠 Installation and Setup Instructions

- Fork & Clone this repository. 

- Ensure you have `jdk` installed on your system.

- Compile the program : 
```
javac WordCompositionOptimized.java
```
- Run the program:
```
java WordCompositionOptimized
```
## Overview
This repository contains Java solution for solving the Word Composition problem. The goal is to identify the longest and second-longest compound words in a given list of words from input files.


## Problem Statement

Write a program that :

- Reads provided files (Input_01.txt and Input_02.txt) containing alphabetically sorted words list (one
word per line, no spaces, all lower case)

- Identifies & display below given data in logs/console/output file
  - longest compounded word
  - second longest compounded word
  - time taken to process the input file

- Note: A compounded word is one that can be constructed by combining (concatenating) shorter words
also found in the same file.

## Input

* Input_01.txt
* Input_02.txt

## BruteForce Approach
Here's a simplified procedure for solving the Word Composition problem:

- **Initialization:**
   - Initialize data structures: `visited` HashMap, `longest`, and `secondLongest` strings.

- **Find Compound Words:**
  - Create a method `findCompoundedWords` that takes a list of words as input.
   - Convert the input words to a `set` for efficient lookup.
   - Iterate through the words:
     - Check if a word is a compound word using the `isConcatenated` method.
     - If `TRUE`, add it to the result list.

- **Check If a Word is a Compound Word :**
   - Created a method `isConcatenated` to identify compound words.
   - Used the `visited` map to avoid recomputation.
   - For each word:
     - Split it into parts and check their existence in the `set`.
     - If it's a compound word, mark it as visited, and update `longest` and `secondLongest`.
     - Return `TRUE` if it's a compound word.

- **Main Method:**
   - In the `main` method:
     - Initialize start time.
     - Define input file paths.
     - Process each file:
       - Read and store words from the file.
       - Record end time for processing time measurement.
       - Find the longest and second-longest compound words.
       - Print results and processing time for each input file.
## Optimized Approach
Here's a simplified procedure for solving the Word Composition problem:

- **Initialization:**
    
    - Instead of HashMap here created a HashSet called `wordSet` to efficiently check if any word exists or not.

    - Additionally created a PriorityQueue called `sortedWords` to store words, sorted by length in descending order.

    - Created an empty list called `ans` to store the compound words.

- **Finding Compound Words :**
   - While `sortedWords` is not empty:
     - Get the longest word from `sortedWords`.
     - Check if it can be constructed from other words in the `wordSet`.
     - If it can, add it to the `ans` list.
     - Break once found the two longest compound words.

- **Checking Word Composition :**
   - Splits a word into two parts and check if it exists in the HashSet.
   - Recursively checks if the second part is also a compound word or not.
   - Returns `TRUE` if it's a compound word, `FALSE` otherwise.

- **Main Method:**
    - In the `main` method:
    - Initialize start time.
     - Define input file paths.
     - Process each file:
       - Read and store words from the file.
       - Record end time for processing time measurement.
       - Find the longest and second-longest compound words.
       - Print results and processing time for each input file.