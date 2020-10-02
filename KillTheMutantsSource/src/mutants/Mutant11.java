package mutants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Mutant11 implements Mutant{
	
	// -------- PROBLEM 1: Third shortest
	//  input: strands, an array of Strings
	// output: a String giving the third shortest String from the array
	// method: return the String in the array that is the
	//         third shortest. 
	//			Return the string "invalid" if there IS NO THIRD SHORTEST in the array or if the array is null.
	//			If there is a tie for the third shortest, any of the tied strings is valid.
	//			If there is a tie for shortest or second shortest, the duplicates do not affect the calculation of the third shortest.
	//			The original array should not be altered.
	// Examples:	
	//		thirdShortest(["a", "ab", "and"]) = "a"
	//		thirdShortest(["a", "b", "bc", "ab", "bye", "and"]) = "a" or "b"
	//		thirdShortest(["a"]) = "invalid"


		public String thirdShortest(String[] words){
			
			if (words == null)
				throw new IllegalArgumentException();
			if (words.length < 3)
				throw new IllegalArgumentException("Array input too short");
			List<String> list = Arrays.asList(words);
			//System.out.println(list);
			list.sort(Comparator.comparingInt(String::length));
			//System.out.println(list);
			List<String> noDuplicates = new ArrayList<String>(list);
			String last = null;
			for(String word: list){
				if(last == null) last = word;
				else if(word.length()<last.length()){
						noDuplicates.remove(word);
				}
				else{
					last = word;
				}
			}
			if(noDuplicates.size()<3) throw new IllegalArgumentException();
			// Here - alter original array
			words[0] = "oops";
			return noDuplicates.get(3);	
		}
		
}
