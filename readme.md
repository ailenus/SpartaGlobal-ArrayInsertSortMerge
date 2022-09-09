# Array Algorithms

Task for Engineering 149 at Sparta Global.

This project contains a few basic algorithms for manipulating arrays of
comparable elements. The type `int` is chosen for simplicity.

## Insertion and sorting

The class `ArrayInsert` contains two methods for inserting an integer into an
existing integer array and returning a sorted array after insertion. The first
method, `insert1`, uses classes and methods contained in the Java standard
library, while the second method, `insert2`, uses a manual implementation of
the quicksort algorithm.

Specifically, `insert1` first converts the given integer array into an
`java.util.ArrayList` of type `Integer`. It then adds the given primitive
integer value to this array list and invokes the `sort` method from the
`java.util.Collections` class in the standard library to sort the list. It then
returns the sorted list as an array using `java.util.stream.IntStream` via the
`mapToInt` method of the `java.util.stream.Stream` class in the standard
library.

The `insert2` method first instantiates a new integer array and appends the
given integer value to the end of the new array after invoking the `arraycopy`
method of the `java.lang.System` class. It then uses a standard implementation
of the quicksort algorithm to sort the array.

## Merging

The class `ArrayMerge` contains one method for merging two sorted integer
arrays and return the merged array. The implementation of this `merge` method
is fairly standard.

## Unit tests

There are two classes for unit tests, one for insertion and sorting and the
other for merging, using the JUnit framework. The `ArrayInsertTest` class
contains testing for the two insertion and sorting methods from the
`ArrayInsert` class, while the `ArrayMergeTest` class contains testing for the
merging method in the `ArrayMerge` class.

Both unit testing classes use a method from the main class, `App`, to help
generate random integer arrays. The method is named `generateRandomIntArray`
and takes two integer parametres, one for specifying the desired length of the
randomly generated array and the other for specifying the upper bound of the
integer values that should be generated.

Both the `ArrayInsertTest` and the `ArrayMergeTest` classes contain a helper
method `initialise`, containing parametres about the lengths and bound of the
integer arrays to be test, which is invoked in all tests before the assertions
to generate random integer arrays according to the parametres passed. The
purpose is to simplify the process of testing different lengths and bounds
conditions. The `initialise` methods in both unit test classes generate random
integer arrays using the abovementioned `generateRandomIntArray` method. The
initialisation method also initialises the correct result array using methods
from the standard library.

Both unit test classes also contain private helper methods that return boolean
values to be passed into assertions, to help remove redundant code.

The `ArrayInsertTest` class contains four unit tests, two for each of the two
insertion and sorting methods from `ArrayInsert`. One tests large values of
lengths and bounds, and the other tests lower boundary values.

The `ArrayMergeTest` class contains two unit tests for the merging method from
`ArrayMerge`, similarly testing large and lower boundary values.

## Program execution

The main method contains some basic tests that are printed to the standard
output. This is fairly straightforward.

## Remarks on execution speed

Between the two inserting and sorting methods in the `ArrayInsert` class, there
is notable difference in performance. At 100,000 length, on my local personal
machine, the unit test for the `insert2` method usually takes less than 40
milliseconds to finish, while the unit test for the `insert1` method
consistently takes 50 milliseconds longer than `insert2`. The extra execution
time likely comes from the overhead of converting the array into a list and
then converting the list back to an array.