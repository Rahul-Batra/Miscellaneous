Problem 1-
Carol is a great alchemist.

In her world, each metal has a name of 2N (N is an integer) letters long, which consists of uppercase alphabets.

Carol can create metal S3 from S1 and S2 alchemical when she can make the name of S3 by taking N letters each from S1 and S2 then rearranging them properly.

You are given 3 names of the metal S1, S2, S3. Determine wether Carol can create S3 from S1 and S2 or not.

Input
The input will be given in the following format from the Standard Input.

S1
S2
S3
On the first line, you will be given the name of the first metal material S1.
On the second line, you will be given the name of the second metal material S2.
On the third line, you will be given the name of the metal S3, which Carol wants to create.
Each character in the S1, S2, and S3 will be an uppercase English alphabet letter.
Each string S1, S2 and S3 has same number of letters and the number is always even.
It is guaranteed that 2≦|S1|≦105
Output
If Carol can create S3 from S1 and S2, output YES, if not, output NO in one line. Make sure to insert a line break at the end of the output.

Input Example 1
Copy
AABCCD
ABEDDA
EDDAAA
Output Example 1
Copy
YES
You can make EDDAAA by picking AAD from the first metal, and AED from the second metal.

Input Example 2
Copy
AAAAAB
CCCCCB
AAABCB
Output Example 2
Copy
NO
To make AAABCB, you have to take at least four letters from the first material. So this can't be created alchemical.

Solution 1 - ALCHEMIST.cpp

Problem 2 -
Dave is a mountaineer. He is now climbing a range of mountains.

On this mountains, there are N huts located on a straight lining from east to west..

The huts are numbered sequentially from 1 to N. The west most hut is 1, the east most hut is N. The i-th hut is located at an elevation of hi meters.

Dave wants to know how many huts he can look down and see from each hut.

He can see the j-th hut from the i-th hut if all huts between the i-th hut and the j-th hut including the j-th one are located at equal or lower elevation than hi.

Note that the i-th hut itself is not included in the hut he can see from the i-th hut.

Input
The input will be given in the following format from the Standard Input.

N
h1
h2
:
hN
On the first line, you will be given N(1≦N≦105), the number of huts.
Then N lines follow, each of which contains hi(1≦hi≦105) the elevation of the i-th hut.

Output
On the i-th line, output the number of huts Dave can see from the i-th hut. Make sure to insert a line break at the end of the output.

Input Example 1
Copy
3
1
2
3
Output Example 1
Copy
0
1
2
From each hut he can see every huts on the west.

Input Example 2
Copy
5
1
2
3
2
1
Output Example 2
Copy
0
1
4
1
0
From the 1st and 5th hut he can't see any other huts.

From the 2nd hut he can only see the 1st hut.

From the 4th hut he can only see the 5th hut.

From the 3rd hut he can see every other huts.

Input Example 3
Copy
5
3
2
1
2
3
Output Example 3
Copy
4
2
0
2
4
Note that he can see the huts on the equal elevation.

Input Example 4
Copy
8
4
3
2
3
4
3
2
1
Output Example 4
Copy
7
2
0
2
7
2
1
0

Solution 2 - mountain.cpp
