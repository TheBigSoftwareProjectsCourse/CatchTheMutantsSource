package testthetests;
import mutants.Mutant;
import mutants.Wolverine;

/**
 * Generates the mutants used in testing
 * 
 * @author Shannon Duvall - original concept
 * @author Sara Sprenkle
 */
public class MutantMaker {
	private static Mutant[] mutants; 
	public static int index = 0;
	private static final int numMutants = 16; // This # is 1 + number of baddies
	
	public static void initMutantMaker(){
		mutants = new Mutant[numMutants];
		mutants[0] = new Wolverine();
		for(int i = 1; i< numMutants; i++){
			Class<?> mutantClass;
			try {
				mutantClass = Class.forName("mutants.Mutant"+i);
				mutants[i] = (Mutant) mutantClass.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static Mutant getNextMutant(){
		Mutant ret =  mutants[index];
		index =(index + 1) % mutants.length;
		return ret;
	}
	
	public static int getNumMutants(){
		return mutants.length;
	}
}
