package mutants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mutant4 implements Mutant {

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
		/*
		if (words == null) {
			throw new IllegalArgumentException();
		}
		*/
		if (words.length < 3) {
			throw new IllegalArgumentException("Array input too short");
		}
		
		Map<Integer, List<String>> lengthToSize = new HashMap<>();
		
		for( String word: words) {
			int wordLength = word.length();
			if( ! lengthToSize.containsKey(wordLength)) {
				lengthToSize.put(wordLength, new ArrayList<String>());
			} 	
			lengthToSize.get(wordLength).add(word);
		}
		
		Set<Integer> keys = lengthToSize.keySet();
				
		if( keys.size() < 3 ) {
			return null;
		}
		
		
		Object[] keyArray = keys.toArray();
		Arrays.sort(keyArray);
		
		
		int thirdLongest = (int) keyArray[2];
		
		List<String> options = lengthToSize.get(thirdLongest);
		Collections.shuffle(options); // get one of the options
		return options.get(0);
	}

	@Override
	public String getBugDescription() {
		return "Does not throw IllegalArgumentException for words parameter being null";
	}

}
