package revealer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import mutants.Mutant;
import testthetests.MutantMaker;

/**
 * Contains the test cases that will reveal the mutants. Creates a mutant that
 * will be used to run the tests against.
 * 
 * DO NOT DISTRIBUTE THIS VERSION TO STUDENTS
 * 
 * Do NOT run this class directly.
 * 
 * @author Shannon Duvall original concept
 * @author Sara Sprenkle refactoring, documentation, updated for JUnit 5, updated examples
 */
public class MutantRevealer {

	// In typical JUnit tests, this would be a non-static variable.
	static Mutant mutant;

	@BeforeAll
	public static void getMutant() {
		// gets the mutant we're going to try to reveal
		mutant = MutantMaker.getNextMutant();
	}

	@Test
	public void testTypicalBehavior() {
		String[][] tests = { { "a", "ab", "abc" }, { "1", "12", "12345", "12345345", "234oi34iuwer" }};
		assertEquals("abc", mutant.thirdShortest(tests[0]));
		assertEquals("12345", mutant.thirdShortest(tests[1]));
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
	public void testNoThirdShortest() {
		assertNull(mutant.thirdShortest(new String[] { "cba", "abc", "bca" }));
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
		
		// make sure the array hasn't changed
		assertArrayEquals(original, words);

	}
	
	@Test
	public void testMoreInArray2() {
		String[] words = { "a", "b", "bc", "ab", "bye", "and" };
		String[] original = { "a", "b", "bc", "ab", "bye", "and" };
		String result = mutant.thirdShortest(words);
		assertTrue(result.equals("bye") || result.equals("and"));
	}

}
