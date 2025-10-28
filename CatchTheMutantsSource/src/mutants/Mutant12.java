package mutants;

import java.util.Arrays;

public class Mutant12 implements Mutant {
	
	private Wolverine wolverine = new Wolverine();


	/**
	 * Returns the third shortest String in the array
	 * 
	 * If there are fewer than 3 words in the array or if the array is null, the
	 * method should throw an IllegalArgumentException. If there is a tie for the
	 * third shortest, any of the tied strings is valid. If there is a tie for
	 * shortest or second shortest, the duplicates do not affect the calculation of
	 * the third shortest. If there is no third shortest word, then the method
	 * returns null. The original array should not be altered.
	 * 
	 * Examples: thirdShortest(["a", "ab", "abc"]) returns "abc" thirdShortest(["a",
	 * "b", "bc", "ab", "bye", "and"]) returns "bye" or "and" because “a” and “b”
	 * are the shortest, “ab” and “bc” are the second shortest, and “bye” and “and”
	 * are the third shortest. thirdShortest(["a"]) should throw an
	 * IllegalArgumentException
	 * 
	 * @param words an array of Strings
	 * @return a String giving the third shortest String from the array if it
	 *         exists; otherwise, returns null
	 * @throws IllegalArgumentException if array is null or if there are fewer than
	 *                                  3 words in the array
	 */
	public String thirdShortest(String[] words) {
		String thirdShortest = wolverine.thirdShortest(words);
		Arrays.sort(words);
		return thirdShortest;
	}

	@Override
	public String getBugDescription() {
		return "Original array is sorted, alphabetically";
	}
	
	public static void main(String[] args) {
		String[] words = {"bc", "a", "def"};
		Mutant12 mutant = new Mutant12();
		System.out.println("Third shortest: " + mutant.thirdShortest(words));
		System.out.println("words:");
		for(int i=0; i < words.length; i++ ) {
			System.out.println(words[i]);
		}
		
		String[] words2 = { "a", "ab", "ab", "ab" };
		System.out.println("Third shortest: " + mutant.thirdShortest(words2));
	}

}
