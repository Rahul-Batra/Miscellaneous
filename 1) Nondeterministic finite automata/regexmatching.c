#include <stdio.h>
#include <string.h>
int match(char a, char b)
{
    return a==b;
}
char** str_split(char *src_str, const char delim, size_t no_substr){
  no_substr = 0;
  char *src_str_tmp = src_str;
  int found_delim = 1;
  while(*src_str_tmp){
    if(*src_str_tmp == delim){
      *src_str_tmp = 0;
      found_delim = 1;
    }
    else if(found_delim){
      no_substr++;
      found_delim = 0;
    }
    src_str_tmp++;
  }
  if(no_substr <= 0){
    return(0);
  }
  char **sub_strings = (char **)malloc( (sizeof(char*) * no_substr) + 1);
  const char *src_str_terminator = src_str_tmp;
  src_str_tmp = src_str;
  int found_null = 1;
  size_t idx = 0;
  while(src_str_tmp < src_str_terminator){
    if(!*src_str_tmp)
      found_null = 1;
    else if(found_null){
      sub_strings[idx++] = src_str_tmp;
        found_null = 0;
    }
    src_str_tmp++;
  }
  sub_strings[no_substr] = NULL;

  return(sub_strings);
}
int matchstar(char c, char *regexp, char *text)
    {
    do {
            if (matchpattern(regexp, text))
                return 1;
       } while (*text != '\0' && (*text++ == c || c == '.'));
        return 0;
    }
int matchpattern(char *regex,char *string){
    char curr_reg,next_reg='\0',cur_string;
    curr_reg=regex[0]; if(strlen(regex)>1)next_reg=regex[1];
        cur_string=string[0];
    if(strlen(regex)==0)
        return strlen(string)==0;
    else if(strlen(string)==0&&next_reg!='*')
        return strlen(regex)==0;
    else {
        if(curr_reg=='.')
         return matchpattern(regex+1,string);
        if(next_reg!='.'&&next_reg!='*')
            return match(curr_reg, cur_string)&& matchpattern(regex+1,string+1);
        else if (next_reg=='*')
            return matchstar(curr_reg, regex+2, string);

        else if(next_reg=='.')
           return match(curr_reg, cur_string)&& matchpattern(regex+2,string+1);

        else return 0;

    }
}
int main() {
	char regex[30],string[30];
	int result=0,results[30],i,j=0,flag=1;
	printf("I have considered only three operators . * and | (Enter regular expression comprising of these operators or none operator like aab or a.a* or a*|b* or a|b or ab*c*d or ab*|c* or a.a*|b.b*|c.c* ...etc)  \n");
	printf("Enter the regular expression...\n");
	gets(regex);
	printf("Enter the String...\n");
	gets(string);
	for(i=0;regex[i]!='\0';i++)
    {
        if(regex[i]=='|')
           {flag=0;break;}
    }
    if(flag)
        result=matchpattern(regex,string);
    else{
            char *str = strdup(regex);
  size_t num_sub_str;
  char **sub_strings = str_split(str, '|', num_sub_str);
  char *endptr;
  if(sub_strings){
    for(i = 0; sub_strings[i]; i++){
      results[i]=matchpattern(sub_strings[i],string);
      if(results[i]){result=1;break;}}
  }
  free(sub_strings);
  free(str);
    }
    if(result)
    printf("Accepted");
    else
    printf("Rejected");
	return 0;
}
