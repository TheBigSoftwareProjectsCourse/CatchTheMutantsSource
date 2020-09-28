package testthetests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mutants.Mutant;

public class Killer {

	static Mutant mutant;

	@BeforeClass
	public static void getMutant() {
		mutant = MutantMaker.getNextMutant();
	}

	@Test
	public void testMutant() {
		String[][] tests = { { "a", "ab", "abc" }, { "1", "12", "12345", "12345345", "234oi34iuwer" }, {},
				{ "cba", "abc", "bca" }, { "cba", "abc", "bca", "a", "a", "a", "ab", "ab", "ab" } };
		// assertEquals(mutant.thirdShortest(null),"invalid");
		assertEquals(mutant.thirdShortest(tests[0]), "abc");
		assertEquals(mutant.thirdShortest(tests[1]), "12345");
		// assertEquals(mutant.thirdShortest(tests[2]),"invalid");
		// assertEquals(mutant.thirdShortest(tests[3]),"invalid");
		assert (mutant.thirdShortest(tests[4]).equals("cba") || mutant.thirdShortest(tests[4]).equals("abc")
				|| mutant.thirdShortest(tests[4]).equals("bca"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionNull() {
		mutant.thirdShortest(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionEmpty() {
		mutant.thirdShortest(new String[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLength1() {
		mutant.thirdShortest(new String[] { "hey" });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLength2() {
		mutant.thirdShortest(new String[] { "hey", "there" });
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptionNoThird() {
		mutant.thirdShortest(new String[] { "cba", "abc", "bca" });
	}

	@Test
	public void testMoreInArrayTie() {
		String[] words = { "a", "b", "c", "d", "ab", "ba", "de", "few", "answers" };
		String[] original = { "a", "b", "c", "d", "ab", "ba", "de", "few", "answers" };
		String result = mutant.thirdShortest(words);
		assertTrue(result.equals("few") || result.equals("answers"));

		// make sure the array hasn't changed
		assertEquals(Arrays.asList(words), Arrays.asList(original));

	}

	@Test
	public void testMoreInArray() {
		String[] words = { "abcds", "b", "bc", "ab", "bye", "and" };
		String[] original = { "abcds", "b", "bc", "ab", "bye", "and" };
		String result = mutant.thirdShortest(words);
		assertTrue(result.equals("bye") || result.equals("and"));

	}

	@Test
	public void testMoreInArray2() {
		String[] words = { "a", "b", "bc", "ab", "bye", "and" };
		String[] original = { "a", "b", "bc", "ab", "bye", "and" };
		String result = mutant.thirdShortest(words);
		assertTrue(result.equals("bye") || result.equals("and"));

	}

}
