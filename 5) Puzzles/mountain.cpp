#include <iostream>
using namespace std;

int main() {
int N,i,j,count,k;
        cin>>N;
        int hutsheight[N];
        for(i=0;i<N;i++)
            cin>>hutsheight[i];
        for(j=0;j<N;j++)
        {   k=0;
            count =0;
            if(j>0){
            k=j-1;
            while(j>0&&k>=0)
            {   if(hutsheight[k]<=hutsheight[j])
                { count++;
                    k--;
                }
                else break;
            }
            }
            if(j<N-1){
            k=j+1;
            while(j<N-1&&k<=N)
            {
                if(hutsheight[k]<=hutsheight[j])
                {
                    count++;
                    k++;
                }
                else break;
            }
            }
            cout<<count<<endl;

        }

	return 0;
}
