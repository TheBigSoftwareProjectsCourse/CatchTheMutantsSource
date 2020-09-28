package testthetests;
import org.junit.runner.JUnitCore;

/**
 * Tries to "kill the mutants" using the tests
 * 
 * @author Shannon Duvall
 * @author Sara Sprenkle
 */
public class KillMutants {

	public final int NUM_RANDOM_TRIALS = 25;

	/*
	 * Main method to run!
	 */
	public static void main(String[] args) {
		MutantMaker.initMutantMaker();
		KillMutants kill = new KillMutants();
		kill.run();
	}

	public void run() {
		Class<?> killer;
		try {
			killer = Class.forName("Killer");
			boolean wolverineSuccess = killerVWolverine(killer);
			boolean killerSuccess = killerVMutants(killer);
			if (wolverineSuccess && killerSuccess) {
				System.out.println("Good eye, sniper!  YOU KILLED ALL THE BAD MUTANTS!");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Don't kill Wolverine
	 */
	public boolean killerVWolverine(Class<?> killerClass) {
		JUnitCore junit = new JUnitCore();
		System.out.println("Testing Wolverine: ");
		// Test it lots, since there is some randomness involved
		for (int i = 1; i <= NUM_RANDOM_TRIALS; i++) {
			MutantMaker.index = 0;
			if (!junit.run(killerClass).wasSuccessful()) {
				System.out.println("Uh Oh.  You killed Wolverine, but he's the good mutant!");
				return false;
			}
		}
		System.out.println("Wolverine made it out alive!");
		return true;
	}

	/*
	 * Try to kill all the mutants
	 */
	public boolean killerVMutants(Class<?> killerClass) {
		JUnitCore junit = new JUnitCore();
		int gotAway = 0;
		int kills = 0;
		MutantMaker.index = 1; // Mutant 0 is Wolverine.
		for (int i = 0; i < MutantMaker.getNumMutants() - 1; i++) {
			System.out.println("Testing Mutant: " + MutantMaker.index);
			int index = MutantMaker.index;
			if (junit.run(killerClass).wasSuccessful()) {
				System.out.println("Mutant: " + index + " made it out alive!");
				gotAway++;
			} else {
				System.out.println("Mutant: " + index + " killed!");
				kills++;
			}
		}
		System.out.println("Successfully killed: " + kills + " out of " + (gotAway + kills));
		return (kills == MutantMaker.getNumMutants() - 1);
	}

}
