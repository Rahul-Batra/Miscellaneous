Travel Information Center Problem -

Aps Island has many cities. In the summer, many travellers will come to the island and attend festive
events in different cities. The festive events in Aps Island are crazy. Once it starts, it will never end. In
the following sentences, the cities which have festive events are called festive cities.
At the beginning, only city No. 1 is festive city. If a new city becomes festive city, the government will tell
the information center about this news.
Everyday, the information center will receive many inquiries from travellers from different cities of this
land. They want to know the closest festive city, and calculate the distance (If current city has festive
event, the distance is 0).
Due to the growing number of the travellers, the information center is overloaded. The government
wants to fix the problem by developing a system to handle the inquiries automatically.
As a fact, cities in Aps Island are connected with highways(bidirectional, length of every highway is 1).
Any two cities are connected directly or indirectly, and there is ONLY one path between any 2 cities.
Input
There are two integers in the first line, n (2  ≤  n   ≤  10 5 ) and m (   1   ≤  m   ≤  10 5 ), n is the number of cities in
the Aps Island and m is the number of queries. The coming n-1 lines are the highways which connect
two cities. In the line, there are two integers ai and bi (1  ≤  ai,   bi  ≤  n,   ai ≠
    bi), representing two cities.
Each line means the highway connecting the two cities.
Next m lines are inquiries from travellers or news from government. Each line has two integers qi
and   ci (1  ≤  qi   ≤  2,   1  ≤  ci   ≤  n). If qi   =   1, the government announce s a new festive city ci. If qi   =   2, you have
to find and print the shortest distance from the city ci to the closest festive city.
Output
Results from each (qi = 2) Questions. Print every result with a new line.
Limits
• Memory limit per test: 256 megabytes
• Time limit per test: The faster the better

Sample Test
input
5 5
1 2
1 3
3 4
3 5
2 5
2 3
1 3
2 3
2 4
output
2
1
0
1


