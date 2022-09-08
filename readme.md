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

The `ArrayInsertTest` class generates a random integer array using the
abovementioned method as well as a random integer value. It then declares a
new integer array that would be the correct result after inserting and sorting.
The correct result is obtained using the `initialise` method, which copies the
randomly generated array into the result array and assigns the last value as the
randomly generated integer value, before invoking the `sort` method from the
`java.util.Arrays` class. This method is invoked before all unit tests via the
`@Before` annotation.

Two unit tests can then be performed for either of the two insertion and
sorting methods. Both use the `equals` method of the `java.util.Arrays` class
to compare the return result of their respective testee methods and the
initialised result array.

The `ArrayMergeTest` class similarly generates two random integer arrays using
the `generateRandomIntArray` method from the main class. It similarly contains
an `initialise` method that generates a correct result for merged array as well
as sorting the two arrays using library method. The unit test then also
similarly compares the return result of its testee and the initialised correct
result.

The use of randomly generated integer arrays and integer values, notably, makes
each run of the unit tests unique and further ensure correctness.

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