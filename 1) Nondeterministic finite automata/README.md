Problem 1-

Write a program to convert a regular expression to NFA. Your program should output steps for
the NFA that is being generated. For example, if the input is:
a.a*|b.b*
the output should be:
1. Building NFA for a
2. Building NFA for a
3. Building NFA for a*
4. Buidling NFA for a.a*
5. Building NFA for b
6. Building NFA for b
7. Building NFA for b*
8. Building NFA for b.b*
9. Building NFA for a.a*|b.b*

Solution 1- nfa.c

Problem 2-

Extend the regular expression parser in Problem 1 to accept or reject strings. It should take as
input one regular expression and one string and output “accepted” or “rejected”.

Solution 2- regexmatching.c

