Problem-

Jack and Jane did all the homework and became bored so they decided to play a game. In their game the following rules apply:

1. There are n stacks of coins. Size of these stacks may differ.
2. There are two players who are moving alternately.
3. The player with number 1 starts the game.
4. In each turn player can remove any number of coins from any nonempty stack.
5. The winner is the one who removes the last coin from the last nonempty stack.

Both Jane and Jack plays optimally and make no mistakes. Your task is to determine who is going to win.

Input -
First line of input contains number of tests t(t<=10). Each test consists of two lines. In the first line there is a number of stacks - n (n<=(10^5)) and in the next ones there are n integers corresponding to the sizes of the consecutive stack.

Output -
For each test print 1 if the first player(Jack) is going to win or 2 otherwise.

sample input-

3
1
5
3
1 2 3
3
3 4 5

expected output -

1
2
1
