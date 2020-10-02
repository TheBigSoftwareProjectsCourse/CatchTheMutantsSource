# KillTheMutantsSource

This is the parent directory.  To get the code for Eclipse, select the CatchTheMutantsSource directory, right-click and choose "Import Projects..."

## Distributing to Students

You'll need to create a jar file of your mutants that should be included with their project.

From the command line, go to the bin directory and run: jar cf mutants.jar mutants/*.class

Copy mutants.jar into the project's lib directory