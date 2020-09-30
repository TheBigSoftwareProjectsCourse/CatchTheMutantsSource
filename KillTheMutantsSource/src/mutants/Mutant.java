package mutants;

/**
 * All mutants must adhere to this interface.  It contains the method you are testing.
 * 
 * @author Shannon Duvall - original idea
 * @author Sara Sprenkle - documentation, organization
 */
public interface Mutant {
	/**
	 * Returns the third shortest String in the array
	 * 
	 * If there IS NO THIRD SHORTEST in the array or if the array is null, the code
	 * should throw an IllegalArgumentException.
	 * If there is a tie for the third shortest, any of the tied strings is valid.
	 * If there is a tie for shortest or second shortest, the duplicates do not
	 * affect the calculation of the third shortest. 
	 * The original array should not be altered.
	 *  
	 * Examples:
	 *    thirdShortest(["a", "ab", "and"]) returns "a"
	 *    thirdShortest(["a", "b", "bc", "ab", "bye", "and"]) returns "bye" or "and" because
	 *        “a” and “b” are the shortest, “ab” and “bc” are the second shortest, and “bye” and “and” are the third shortest.
	 *    thirdShortest(["a"]) should throw an IllegalArgumentException
	 * 
	 * @param words an array of Strings
	 * @return a String giving the third shortest String from the array
	 */
	public String thirdShortest(String[] words);
}
