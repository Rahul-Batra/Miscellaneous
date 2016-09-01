#include <iostream>
using namespace std;
#include <stdio.h>
#include <string.h>
#define RANGE 255

int sub[100000];

void next(int max, int length) {

	int pos = length - 1;

	//find first digit that can be increased
	while(pos >= 0)
	{
		if(sub[pos] == max - (length - 1 - pos))
			pos--;

		else
			break;
	}

		sub[pos]++; //increase digit

		//update other digits
		for(int a = pos+1; a < length; a++)
			sub[a] = sub[a-1] + 1;

}
// The main function that sort the given string str in alphabatical order
void countSort(char *str)
{
    // The output character array that will have sorted str
    char output[strlen(str)];

    // Create a count array to store count of inidividul characters and
    // initialize count array as 0
    int count[RANGE + 1], i;
    memset(count, 0, sizeof(count));

    // Store count of each character
    for(i = 0; str[i]; ++i)
        ++count[str[i]];

    // Change count[i] so that count[i] now contains actual position of
    // this character in output array
    for (i = 1; i <= RANGE; ++i)
        count[i] += count[i-1];

    // Build the output character array
    for (i = 0; str[i]; ++i)
    {
        output[count[str[i]]-1] = str[i];
        --count[str[i]];
    }

    // Copy the output array to str, so that str now
    // contains sorted characters
    for (i = 0; str[i]; ++i)
        str[i] = output[i];
}
 bool isSubSequence(char str1[], char str2[], int m, int n)
{
   int j = 0; // For index of str1 (or subsequence

   // Traverse str2 and str1, and compare current character
   // of str2 with first unmatched char of str1, if matched
   // then move ahead in str1
   for (int i=0; i<n&&j<m; i++)
       if (str1[j] == str2[i])
         j++;

   // If all characters of str1 were found in str2
   return (j==m);
}
// Driver program to test above function
int main()
{
    char str1[100000],str2[100000],str3[100000],str4[100000];int a,b,d,e,c,n,max,i,j,k,flag1=0,flag2=0;
	gets(str1);
	gets(str2);
	gets(str3);

    countSort(str1);
	countSort(str2);
	countSort(str3);
 	d=strlen(str1);
	e=strlen(str2);
	c=strlen(str3);
    if(c>d+e||c%2==1)
    cout<<"NO";
	else{
	max=c-1;
	n=c/2;
	for(i = 0; i < n; i++)
		{
			sub[i] = i;
		}

		for(a = 0; ; a++)
		{	if(flag1 && flag2)
			break;
			for( b=0; b < max+1; b++)
			{	//cout << str3[sub[b]];
				str4[b]=str3[sub[b]];

			}
			str4[b]='\0';
			if(isSubSequence(str4, str1, n, d)==true)	{
			flag1=1;
			}
			else if(isSubSequence(str4, str2, n, e)==true) {
			flag2=1;
			}
			//cout << '\n';

			if(sub[0] == max - (n - 1))
				break;

			else
				next(max, n); //maximum value and last position
		}
if(flag1 && flag2)
	cout<<"YES";
else cout<<"NO";


    }
    return 0;
}
