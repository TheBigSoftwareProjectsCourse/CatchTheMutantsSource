package testthetests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.runner.JUnitCore;

/**
 * Evaluates how good your tests in MutantRevealer are against good and bad
 * mutants.
 * 
 * @author Shannon Duvall - original conception
 * @author Sara Sprenkle - documentation, updated displayed output, minor
 *         revisions
 */
public class CatchMutants {

	public final int NUM_RANDOM_TRIALS = 25;
	private static final String EVALUATION_PACKAGE = "testthetests";
	private static final String TESTS_FILE = "MutantRevealer";
	private static final String ASCII_FILE = "xmen.txt";

	public static void main(String[] args) {
		MutantMaker.initMutantMaker();
		CatchMutants kill = new CatchMutants();
		kill.run();
	}

	/**
	 * Evaluates the test suite against all the mutants -- good and bad -- and
	 * displays the results of those tests
	 */
	public void run() {
		Class<?> killer;
		try {
			killer = Class.forName(EVALUATION_PACKAGE + "." + TESTS_FILE);
			boolean wolverineSuccess = evaluateTestsOnGoodMutants(killer);
			System.out.println();

			boolean killerSuccess = evaluateTestsOnBadMutants(killer);
			if (wolverineSuccess && killerSuccess) {
				displaySuccessMessage();
			} else {
				System.out.println("\nProfessor X says, \"Looks like you have more work to do\"");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Try *not* to reveal the good mutants
	 * 
	 * @param revealerTestClass the class used to try to reveal the mutants
	 * @return true if all the good mutant passed all tests; otherwise, false
	 */
	public boolean evaluateTestsOnGoodMutants(Class<?> revealerTestClass) {
		JUnitCore junit = new JUnitCore();
		System.out.println("~~~~~~~~~~ Testing Wolverine: ~~~~~~~~~~ ");
		// Test it lots, since there is some randomness involved when there are options
		// for the correct answer
		for (int i = 1; i <= NUM_RANDOM_TRIALS; i++) {
			MutantMaker.index = 0;
			if (!junit.run(revealerTestClass).wasSuccessful()) {
				System.err.println("Uh Oh.  You caught Wolverine, but he's the good mutant!");
				return false;
			}
		}
		System.out.println("Wolverine passed all the tests!");
		return true;
	}

	/**
	 * Try to reveal all the mutants
	 * 
	 * @param revealerTestClass the class used to try to reveal the mutants
	 * @return true if all the bad mutants were revealed; otherwise, false
	 */
	public boolean evaluateTestsOnBadMutants(Class<?> revealerTestClass) {
		JUnitCore junit = new JUnitCore();
		int gotAway = 0;
		int caught = 0;
		MutantMaker.index = 1; // Mutant 0 is Wolverine.
		System.out.println("~~~~~~~~~~ Testing the Mutants ~~~~~~~~~~");
		for (int i = 0; i < MutantMaker.getNumMutants() - 1; i++) {
			System.out.println("Testing Mutant: " + MutantMaker.index);
			int index = MutantMaker.index;
			if (junit.run(revealerTestClass).wasSuccessful()) {
				System.err.println("Mutant: " + index + " made it out alive!\n");
				gotAway++;
			} else {
				System.out.println("Mutant: " + index + " caught!\n");
				caught++;
			}
		}
		System.out.println("Successfully caught " + caught + " out of " + (gotAway + caught));
		return (caught == MutantMaker.getNumMutants() - 1);
	}

	/**
	 * Displays the message upon success
	 */
	private void displaySuccessMessage() {
		System.out.println("\n ~~~~~~~ Good testing!  YOU CAUGHT ALL THE BAD MUTANTS! ~~~~~~~\n");
		try {
			BufferedReader br = new BufferedReader(new FileReader(ASCII_FILE));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't read in ascii art file " + ASCII_FILE);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error reading ascii art file " + ASCII_FILE);
			e.printStackTrace();
		}
	}
}
