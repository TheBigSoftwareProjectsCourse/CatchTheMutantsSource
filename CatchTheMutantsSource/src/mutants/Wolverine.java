package mutants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Correct implementation of the method thirdShortest
 * 
 * @author Shannon Duvall original concept
 * @author Sara Sprenkle documentation
 *
 */
public class Wolverine implements Mutant {
	
	/**
	 * Returns the third shortest String in the array
	 * 
	 * If there are fewer than 3 words in the array or if the array is null, the method
	 * should throw an IllegalArgumentException.
	 * If there is a tie for the third shortest, any of the tied strings is valid.
	 * If there is a tie for shortest or second shortest, the duplicates do not
	 * affect the calculation of the third shortest.
	 * If there is no third shortest word, then the method returns null.
	 * The original array should not be altered.
	 *  
	 * Examples:
	 *    thirdShortest(["a", "ab", "abc"]) returns "abc"
	 *    thirdShortest(["a", "b", "bc", "ab", "bye", "and"]) returns "bye" or "and" because
	 *        “a” and “b” are the shortest, “ab” and “bc” are the second shortest, and “bye” and “and” are the third shortest.
	 *    thirdShortest(["a"]) should throw an IllegalArgumentException
	 * 
	 * @param words an array of Strings
	 * @return a String giving the third shortest String from the array if it exists; otherwise, returns null
	 * @throws IllegalArgumentException if array is null or if there are fewer than 3 words in the array
	 */
	public String thirdShortest(String[] words) {
		if (words == null)
			throw new IllegalArgumentException();
		if (words.length < 3)
			throw new IllegalArgumentException("Array input too short");
		List<String> list = Arrays.asList(words);
		list.sort(Comparator.comparingInt(String::length));
		List<String> noDuplicates = new ArrayList<String>(list);
		String last = null;
		for (String word : list) {
			if (last == null)
				last = word;
			else if (word.length() == last.length()) {
				noDuplicates.remove(word);
			} else {
				last = word;
			}
		}
		if (noDuplicates.size() < 3)
			return null;
		String ideal = noDuplicates.get(2);
		List<String> answers = new ArrayList<String>();
		for (String s : list) {
			if (s.length() == ideal.length()) {
				answers.add(s);
			}
		}
		int index = (int) (Math.random() * answers.size());
		return answers.get(index);
	}
		

		// -------- PROBLEM 2: Valid DNA
		//  input: dna, an array of characters and tolerance, an integer
		// output: true or false
		// method: tell whether or not the array has only instances of 
		//         dna bases, namely 'A', 'C', 'T', and 'G', with no more
		//    	   than <tolerance> errors
		// examples
		// --------
		// validDNA(['C', 'A', 'A', 'F'], 2) returns true
		// validDNA(['C', 'A', 'A', 'F'], 1) returns true
		// validDNA(['C', 'A', 'A', 'F'], 0) returns false
		// validDNA(['C', 'A', 'A'], 0) returns true
		
		//public boolean validDNA(char[] dna, int tolerance){
		//	return false;
		//}

		// ----- PROBLEM 3: Sequence of Three
		//  input: nums, an array of integers
		// output: true or false
		// method: Return true if there are 3 numbers together in the 
		//		   array that are in numeric sequence.  Any array
		// 		   whose length is less than 3 should return false.
		// example: nums has 5 items: |-3|4|5|6|7|
		//         return true because 4,5, and 6 are in sequence.
		// example: nums has 6 items: |-3|-4|5|16|-5|0|
		//         return false - there are not three numbers together
		//		   that are in sequence.  -3, -4, -5 make a sequence
		//	       but they are not adjacent in the array.
		// 		   
		//public boolean sequenceThree(int[] nums) {

		//	return false;
		//}


		// ----- PROBLEM 4: Test Scorer
		//  input: test, an array of characters representing multiple choice answers
		//		   key, an array of characters the same length as test giving the
		//		        correct answers
		// output: an integer score of the test
		// method: check each character in test with the corresponding character
		//		   in key.  For each question answered correctly they get 2 points.
		//		   If the answer is incorrect they lose 1 point, but if the answer
		//		   is blank, ' ', no points are won or lost.
		// example test has 3 items: |'B'|' '|'A'|
		//         key has 3 values: |'B'|'B'|'C'|
		//         return 2 + 0 -1 = 1.
		// example test has 5 items: |'A'|'A'|'B'|' '|' '|
		//         key has 5 values: |'A'|'A'|'A'|'A'|'A'|
		//         return 2+2-1 = 3

		//public int score(char[] test, char[] key){
		//	return 0;
		//}

		// ----- PROBLEM 5: Poker Dice
		//  input: dice, a SORTED array of integers, length is at least 5.  There
		//		   are no duplicate numbers in the array.
		// output: a String that is either "large straight", "medium straight", 
		//         "small straight", or "no straight"
		// method: for a dice game, a "straight" is made of consecutive numbers.
		// 		   A large straight is a run of 5 or more elements.  A medium 
		//		   straight is a run of 4 elements, and a small straight is a run 
		//		   of 3 elements.
		// example dice is |1|2|3|6|7|
		//         return "small straight"
		// example dice is |1|5|12|13|14|15|16|
		//		   return "large straight"
		// example dice is |1|3|5|7|9|11
		//         return "no straight"

		// Note: if you are planning on completing the extra credit, do that one first.
		// If you get it correct, it makes this problem trivial to solve.
		//
		// Hint: check for each type of straight separately.

		//public String findStraights(int[] dice) {
		//	return "";
		//}

		// ----- EXTRA CREDIT --------------------------------------------------------
		//  input: dice, a SORTED array of integers.  There
		//		   are no duplicate numbers in the array, and size is at least 1.
		// output: a number telling the size of the largest number of consecutive items
		// method: for a dice game, a "straight" is made of consecutive numbers.
		// 		   this method should return the size of the largest straight in the array
		//		   smallest straight possible is a straight of 1.
		// example dice is |1|2|3|6|7|
		//         return 3
		// example dice is |1|5|12|13|14|15|16|
		//		   return 5
		// example dice is |1|3|5|7|9|11
		//         return 1
		// example dice is |1|2|3|5|6|7|8|19|20|21|22|23|24|25|
		// 		   return 7
		//public int biggestStraight(int[] dice){
		//	return 0;
		//}


		/*public static void main(String[] args){
			YourWork myMethods = new YourWork();
			//String[] words = {"hello", "is", "it", "me", "you're", "looking", "for"};
			//System.out.println(myMethods.secondLongest(words));
			//char[] dna = {'C', 'A', 'A', 'F'};
			//System.out.println(myMethods.validDNA(dna, 1));
			//int[] nums = {-3,4,5,6,7};
			//System.out.println(myMethods.sequenceThree(nums));
			//char[] myQuiz = {'B',' ','A'};
			//char[] answerKey = {'B','B','C'};
			//System.out.println(myMethods.score(myQuiz, answerKey));
			//int[] poker = {1,5,12,13,14,15,16};
			//System.out.println(myMethods.findStraights(poker));
			//System.out.println(myMethods.biggestStraight(poker));
			
		}
		
	} */


}
