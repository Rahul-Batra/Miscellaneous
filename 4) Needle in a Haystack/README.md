Needle in a Haystack problem-

You need to write a program that searches for a needle in the haystack and returns every position within searching line. Put differently, write a program that finds all occurrences of a given pattern in a given input string. 

A needle – is a sequence of characters (0-255), the length can be any
The haystack – is a sequence of characters (big string) to search in
The program has to detect all occurrences of the needle in the haystack. It should take the needle and the haystack as input, and output the positions of each occurrence, as shown below. The suggested implementation is the KMP algorithm, but this is not a requirement. However, a naive approach will probably exceed the time limit, whereas other algorithms are more complicated... The choice is yours.

Input

The input consists of a number of test cases. Each test case is composed of three lines, containing:

the length of the needle,
the needle itself,
the haystack.
The length of the needle is only limited by the memory available to your program, so do not make any assumptions - instead, read the length and allocate memory as needed. The haystack is not limited in size, which implies that your program should not read the whole haystack at once. The KMP algorithm is stream-based, i.e. it processes the haystack character by character, so this is not a problem.

The test cases come one after another, each occupying three lines, with no additional space or line breaks in between.

Output

For each test case your program should output all positions of the needle's occurrences within the haystack. If a match is found, the output should contain the position of the first character of the match. Characters in the haystack are numbered starting with zero.

For a given test case, the positions output should be sorted in ascending order, and each of these should be printed in a separate line. For two different test cases, the positions should be separated by an empty line.

Example

Sample input:

2
na
banananobano
6
foobar
foo
9
foobarfoo
barfoobarfoobarfoobarfoobarfoo

Sample output:

2
4

3
9
15
21
Note the double empty line in the output, which means that no match was found for the second test case.

Warning: Keep in mind that needles & haystack can be long. Large Input/Output data, so be careful with certain languages!




