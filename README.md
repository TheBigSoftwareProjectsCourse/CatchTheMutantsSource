# CatchTheMutantsSource

This is the parent directory.  To get the code for Eclipse, select the CatchTheMutantsSource directory, right-click and choose "Import Projects..."

## Distributing to Students

You'll need to create a jar file of your mutants that should be included with their project.

From the command line, go to the bin directory and run: `jar cf mutants.jar mutants/*.class` or `jar cf mutants.jar mutants`

Copy mutants.jar into the project's lib directory

## Mutants

1. Does not return null if there is no third shortest
2. 
3.
4.
5.
6.
7.
8.
9.
10. Returns "invalid" instead of IllegalArgumentException if null passed in
11. Original array is altered
12. Original array is null
13. Throws IllegalArgumentException almost always
14. Doesn't handle duplicates in the array
15. Throws IllegalArgumentException if there are fewer than 4 words (instead of 3)