/*Problem 2
 *Adding 1 to a number represented by linked list
 *Rahul Batra
 */
#include <iostream>
#include<stdlib.h>
using namespace std;
struct node
{
    long info;
    node *next;
};
struct node *start=NULL, *rear=NULL;
struct node *newnode;
void InsertatBeg(long data)
{   newnode=new node;
    if(newnode!=NULL)
    {  newnode->info=data;
       newnode->next=NULL;
    if(start==NULL)
        start=rear=newnode;
        else{
            newnode->next=start;
            start=newnode;
        }
}
}
void Addition()
{struct node *temp1=start,*temp2=start;
 long loc=0,count=0;
    while(temp1!=NULL)
    {
        count++;
        if(temp1->info%10!=9){
            loc=count;
            temp2=temp1;
        }
        temp1=temp1->next;
    }
    if(count!=0){
        if(loc!=0){
                temp2->info=temp2->info+1;
            while(loc<count){
                temp2=temp2->next;
                temp2->info=0;
                loc++;
            }
        } else{
            InsertatBeg(1);
            while(loc<count){
                temp2->info=0;
                loc++;
                temp2=temp2->next;
            }
        }
    }
}
void Display()
{struct node *temp=start;
while(temp!=NULL)
{
    cout<<temp->info;
    if(temp->next!=NULL) cout<<"->";
    temp=temp->next;
}
    cout<<endl;
}
int main()
{   long n,r;
    cout<<"Enter any number: ";
    cin>>n;
    while(n>0) {
        r=n%10;
        InsertatBeg(r);
        n=n/10;
    }
    cout<<"The input number is: ";
    Display();
    Addition();
    cout<<"The output after adding 1 is: ";
    Display();
     return 0;
}
