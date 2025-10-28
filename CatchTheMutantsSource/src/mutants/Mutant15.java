package mutants;

public class Mutant15 implements Mutant {

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
	@Override
	public String thirdShortest(String[] words) {
		if (words == null)
			throw new IllegalArgumentException();
		// Here - change 3 to a 4
		if (words.length < 4)
			throw new IllegalArgumentException("Array input too short");
		
		return wolverine.thirdShortest(words);

	}

	@Override
	public String getBugDescription() {
		return "Throws IllegalArgumentException if there are fewer than 4 words (instead of 3)";
	}
}
