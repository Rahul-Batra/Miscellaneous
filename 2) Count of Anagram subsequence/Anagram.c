/* author: Rahul Batra */
/* Program for: Finding the count of anagram sub-sequence from input string of length 3 or more */
/* input: a String S */
/* output: Print the count value */

#include <stdio.h>
#include <malloc.h>
#include <string.h>
#define MAX 256
int count=0;                                     /* A variable to store the count of anagram subsequence of length 3 or more */
int length[MAX]={-1},prefixstart[MAX]={-1},r=0;  /* Two arrays to store the starting position and length of anagram searched
                                                    so far to avoid duplicates */

/* Function that compares two strings and return 1 or 0
if the strings are same or not */
int equate(char a1[], char a2[])
{   size_t i;
    for (i=0; i<MAX; i++)
        if (a1[i] != a2[i])
            return 0;
    return 1;
}

/* Functions that accepts an input subsequence and remaining string and returns 1 or 0
depending on whether the subsequence anagram is present in the remaining string or not
and that anagram should not have been considered before i.e. it must be unique */
int anagram_searching(char *prefix, char *suffix,int start)
{   int flag=0,flag1=1;
    size_t i,k;
    int p = strlen(prefix), q = strlen(suffix);
    char countP[MAX] = {0}, countTW[MAX] = {0};
    for (i = 0; i < p; i++)
    {
        (countP[prefix[i]])++;
        (countTW[suffix[i]])++;
    }
    for (i = p; i < q; i++)
    {
         if (equate(countP, countTW))
             {  for(k=0;k<r;k++)
             {  if(((i - p)+p+start)==prefixstart[k]&&p==length[k]){
                flag1=0;break;}
             }
             if(flag1)
             {   prefixstart[r]=(i - p)+p+start;
                 length[r]=p;
                 r++; flag=1;}
             }
        (countTW[suffix[i]])++;
        (countTW[suffix[i-p]])--;
    }
    if (equate(countP, countTW))
        {   for(k=0;k<r;k++)
        {   if(((i - p)+p+start)==prefixstart[k]&&p==length[k]){
            flag1=0;break;}
        }
        if(flag1)
        {   prefixstart[r]=(q - p)+p+start;
            length[r]=p;
            r++; flag=1;}
        }
    return flag;
}

/* Function that accepts a subsequence,
divide the original string into input subsequence and remaining string,
then searches for the subsequence anagrams in the remaining string
by calling anagram_searching function, if the anagram is present and
unique then it increments the count of anagram subsequence */
void substr(char *prefix, char *suffix,int start ,int end)
{   size_t i,j,k;
    int flag=1;
    char *pointer;
    for(i=0;i<r;i++){
    if(start==prefixstart[i]&&end - start==length[i]){
    flag=0;break;
    }
    }
    if(flag){
    j=0;
    for(i = start;i < end;i++){
    prefix[j] = suffix[i];j++;}
    prefix[j] = '\0';
    j=strlen(suffix);
    pointer = (char *)malloc(j-end+1);
    k=0;
    for(i=end;i<j;i++){
    pointer[k] = suffix[i];k++;}
    pointer[k] = '\0';
    k=anagram_searching(prefix,pointer,start);
    if(k) count++;
  }
}

/* Function that creates each subsequence of the input string,
if the subsequence is of length 3 or more, then passes it to substr function */
void subsequence(int start, int end, char* prefix, char* suffix){
       char *pointer;
       if(start == strlen(suffix) && end == strlen(suffix)){
            return;
        } else {
            if(end == strlen(suffix)+1){
                subsequence(start+1,start+1,prefix,suffix);
            } else {
                  if (end - start>= 3)
                  substr(prefix, suffix ,start, end);
                  subsequence(start, end+1,prefix,suffix);
            }
        }
}

int main()
{
    char String[MAX];
    gets(String);                                       /* Accept a String S from user */
    char *prefix = (char*) malloc(strlen(String) + 1);
    subsequence(0,1,prefix,String);
    printf("%d",count);                                 /* Print the count of anagram subsequences of length 3 or more */
    return 0;
}
