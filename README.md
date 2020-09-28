# KillTheMutantsSource

Kill The Mutants - Lab on Testing

We generally assess the functionality of the code we write by running it and writing tests.  But how do we assess the quality of the tests?  Does test suite quality and coverage matter?  Yes!  In some cases, knowing that code is bug-free is literally a matter of life and death.

One way that test suites are assessed is called Mutation Testing.  The idea is to have a piece of code that you believe works.  Then you introduce “mutant” varieties of the code by changing one small thing - like removing a line of code, changing an operator, or changing a literal.  After creating mutant code, you run the test suite on the mutants.  A mutant is “killed” if the test flags the bug, and the total number of mutants you successfully kill gives a measure of how good the test suite coverage is.

For this lab, I will provide you with a method specification, one correct implementation, and 15 mutant implementations.  Your job is to write a test suite that does NOT flag the correct implementation, but does successfully kill each mutant.

Load Up

Begin by downloading and importing this Eclipse Project:  KillTheMutants.zip.  You should see three files that are given: 
Killer.java: This is the test file that you will complete.
Mutant.java: This is the interface that all mutant code implements.  It gives the code’s proMutantsblem description, (also found below)
KillMutants.java: This is the file that you should RUN.  You will run it as a Java Application, NOT as a JUnit file.

Mutant Goals

All Mutants implement this method:

	// -------- PROBLEM: Third shortest
	//  input: strands, an array of Strings
	// output: a String giving the third shortest String from the array
	// method: return the String in the array that is the third shortest. 
	//			If there IS NO THIRD SHORTEST in the array or if the array is null the code should 
	//			throw an IllegalArgumentException.
	//			If there is a tie for the third shortest, any of the tied strings is valid.
	//			If there is a tie for shortest or second shortest, the duplicates do not 
	//						affect the calculation of the third shortest.
	//			The original array should not be altered.
	// Examples:	
	//		thirdShortest(["a", "ab", "and"]) = "and"
	//		thirdShortest(["a", "b", "bc", "ab", "bye", "and"]) = "bye" or "and".  “a” and “b” are the shortest, “ab” and “bc” are the
	//			second shortest, and “bye” and “and” are the third.
	//		thirdShortest(["a"]) should throw an IllegalArgumentException





Your Mission

Write your tests for the “thirdShortest” method in the Killer.java file.  Don’t delete the lines given to you - that lets my code load a new “Mutant” to test.  Don’t rename the class.

Then you will see how good your test code is by running KillMutants.java.
Let me reiterate - DO NOT run your Killer file using the Run As JUnit option.  This would run the file on one mutant only.  You need to run the KillMutants file as a Java Application.  This code in turn will run JUnit on your code in a loop for all the mutants.

First, the test file will be run on Wolverine, who is a good mutant.  This mutant should pass all the tests, 
as it is a correct implementation of the problem.

Then the test file will be run on 15 mutants, which have all incorrectly implemented the method.  If your test accurately shows that the mutant program is incorrect, then you have “killed” that mutant.  

When your test suite accurately kills all mutants except Wolverine, you will see the victory message: “Good eye, sniper!  YOU KILLED ALL THE BAD MUTANTS!”

Getting Backup

If you are stuck on a mutant, make note of the number.  Your professor can only help if she knows which mutant number you are targeting.


Note: Mutant drawing from publicdomainpictures.net
