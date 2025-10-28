# CatchTheMutantsSource

This is the parent directory.  To get the code for Eclipse, select the CatchTheMutantsSource directory, right-click and choose "Import Projects..."

## Distributing to Students

You'll need to create a jar file of your mutants that should be included with their project.

From the command line, go to the bin directory and run: `jar cf mutants.jar mutants/*.class` or `jar cf mutants.jar mutants`.  Can also make it from Eclipse's Export menu.

Copy mutants.jar into the project's lib directory

In 2022, Students had issues with the default version of Java in Eclipse --
which is 17 -- and the jar file I gave them (which was 18.)

## Mutants

1. Does not return null if there is no third shortest
2. Does not sort based on length, just returns third non-duplicate word
3. Changing operation from < to >= when looking at duplicates
4. Does not throw IllegalArgumentException for words parameter being null
5. Does not throw IllegalArgumentException when array is too short
6. Reverses the sorted list (from largest to smallest)
7. Does not handle duplicates in the array of words
8. Returns the second shortest, not the third
9. Returns the fourth shortest, not the third
10. Returns "invalid" instead of IllegalArgumentException if null passed in
11. Original array is altered
12. Original array is null
13. Throws IllegalArgumentException almost always
14. Doesn't handle duplicates in the array
15. Throws IllegalArgumentException if there are fewer than 4 words (instead of 3)