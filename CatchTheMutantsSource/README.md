# CatchTheMutants - Source

For this lab, I will provide you with a method specification, one correct implementation, and 15 mutant implementations. 
Your job is to write a test suite that does NOT flag the correct implementation but does successfully reveal each mutant. 

You will write your tests in the `revealer.MutantRevealer` class and run the `testthetests.CatchMutants` file to see how many mutants you successfully caught.

## Distributing to Students

You'll need to create a jar file of your mutants that should be included with their project.

From the command line: jar cf mutants.jar bin/mutants/*.class

Copy mutants.jar into the project's lib directory