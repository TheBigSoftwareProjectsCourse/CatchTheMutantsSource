package mutants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Mutant14 implements Mutant {

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
		if (words == null)
			throw new IllegalArgumentException();
		if (words.length < 3)
			throw new IllegalArgumentException("Array input too short");
		String[] wordsCopy = Arrays.copyOf(words, words.length);
		List<String> list = Arrays.asList(wordsCopy);
		list.sort(Comparator.comparingInt(String::length));
		// System.out.println(list);
		List<String> noDuplicates = new ArrayList<String>(list);
		String last = null;
		for (String word : list) {
			if (last == null)
				last = word;
			else if (word.length() == last.length()) {
				// Here
				// noDuplicates.remove(word);
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
		return ideal;
	}

}
