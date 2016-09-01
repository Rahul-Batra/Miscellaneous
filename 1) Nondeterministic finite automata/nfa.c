#include <stdio.h>

int main() {
	char str[20];
	int i,j=0,k,len,count=0,loc[10],step_count=1;
	printf("Enter the regular expression...\n");
	gets(str);
	for(len=0;str[len]!='\0';len++);
	for(i=0;str[i]!='\0';i++)
	{
		if(str[i]=='|')
		{
			loc[j]=i;j++;count++;
		}
	}
	if(count == 0)
    {
        for(i=0;i<len;i++)
		{
			if(str[i]=='.')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i-1]);step_count++;
			}
			else if(str[i+1]=='*'||str[i+1]=='+')
			{
				printf("\n%d\tBuilding NFA for %c%c",step_count,str[i],str[i+1]);step_count++;
			}
			else if(str[i]!='.'&& str[i]!='+' && str[i]!='*' && str[i]!='|')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i]);step_count++;
			}
		}
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=0;i<len;i++)
		printf("%c",str[i]);step_count++;
    }
	if(count == 1)
	{
		for(i=0;i<loc[0];i++)
		{
			if(str[i]=='.')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i-1]);step_count++;
			}
			else if(str[i+1]=='*'||str[i+1]=='+')
			{
				printf("\n%d\tBuilding NFA for %c%c",step_count,str[i],str[i+1]);step_count++;
			}
			else if(str[i]!='.'&& str[i]!='+' && str[i]!='*' && str[i]!='|')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i]);step_count++;
			}
		}
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=0;i<loc[0];i++)
		printf("%c",str[i]);step_count++;
		for(i=loc[0]+1;i<len;i++)
		{
			if(str[i]=='.')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i-1]);step_count++;
			}
			else if(str[i+1]=='*'||str[i+1]=='+')
			{
				printf("\n%d\tBuilding NFA for %c%c",step_count,str[i],str[i+1]);step_count++;
			}
			else if(str[i]!='.'&& str[i]!='+' && str[i]!='*' && str[i]!='|')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i]);step_count++;
			}
		}
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=loc[0]+1;i<len;i++)
		printf("%c",str[i]);step_count++;
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=0;i<len;i++)
		printf("%c",str[i]);step_count++;
	}
	if(count == 2)
	{
		for(i=0;i<loc[0];i++)
		{
			if(str[i]=='.')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i-1]);step_count++;
			}
			else if(str[i+1]=='*'||str[i+1]=='+')
			{
				printf("\n%d\tBuilding NFA for %c%c",step_count,str[i],str[i+1]);step_count++;
			}
			else if(str[i]!='.'&& str[i]!='+' && str[i]!='*' && str[i]!='|')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i]);step_count++;
			}
		}
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=0;i<loc[0];i++)
		printf("%c",str[i]);step_count++;
		for(i=loc[0]+1;i<loc[1];i++)
		{
			if(str[i]=='.')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i-1]);step_count++;
			}
			else if(str[i+1]=='*'||str[i+1]=='+')
			{
				printf("\n%d\tBuilding NFA for %c%c",step_count,str[i],str[i+1]);step_count++;
			}
			else if(str[i]!='.'&& str[i]!='+' && str[i]!='*' && str[i]!='|')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i]);step_count++;
			}
		}
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=loc[0]+1;i<loc[1];i++)
		printf("%c",str[i]);step_count++;
		for(i=loc[1]+1;i<len;i++)
		{
			if(str[i]=='.')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i-1]);step_count++;
			}
			else if(str[i+1]=='*'||str[i+1]=='+')
			{
				printf("\n%d\tBuilding NFA for %c%c",step_count,str[i],str[i+1]);step_count++;
			}
			else if(str[i]!='.'&& str[i]!='+' && str[i]!='*' && str[i]!='|')
			{
				printf("\n%d\tBuilding NFA for %c",step_count,str[i]);step_count++;
			}
		}
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=loc[1]+1;i<len;i++)
		printf("%c",str[i]);step_count++;
		printf("\n%d\tBuilding NFA for ",step_count);
		for(i=0;i<len;i++)
		printf("%c",str[i]);step_count++;
	}
	return 0;
}
