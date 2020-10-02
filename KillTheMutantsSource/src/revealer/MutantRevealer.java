package revealer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import mutants.Mutant;
import testthetests.MutantMaker;

/**
 * Contains the test cases that will reveal the mutants. Creates a mutant that
 * will be used to run the tests against.
 * 
 * Do NOT run this class directly.
 * 
 * @author Shannon Duvall original concept
 * @author Sara Sprenkle refactoring, documentation
 */
public class MutantRevealer {

	static Mutant mutant;

	@BeforeAll
	public static void getMutant() {
		// gets the mutant we're going to try to reveal
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

	@Test
	public void testExceptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			mutant.thirdShortest(null);
		});
	}

	@Test
	public void testExceptionEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			mutant.thirdShortest(new String[] {});
		});
	}

	@Test
	public void testExceptionLength1() {
		assertThrows(IllegalArgumentException.class, () -> {
			mutant.thirdShortest(new String[] { "hey" });
		});
	}

	@Test
	public void testExceptionLength2() {
		assertThrows(IllegalArgumentException.class, () -> {
			mutant.thirdShortest(new String[] { "hey", "there" });
		});
		
	}

	@Test
	public void testExceptionNoThird() {
		assertThrows(IllegalArgumentException.class, () -> {
			mutant.thirdShortest(new String[] { "cba", "abc", "bca" });
		});
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
