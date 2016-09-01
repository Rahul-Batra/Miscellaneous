
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{	
	static int lengthsubarray (int arr[], int n, int k) {
	int max_len=0;
	for (int i=0; i<n-1; i++)
    {int count=0; int len =1;
    if(arr[i]==1) count++; 
    for (int j=i+1; j<n; j++)
        {	len++; 
		if(arr[j]==1) count++;
		if(len>max_len)
        	 max_len =len;
        	if(count>=k)
        	{  
        		break;
        	}
        }
    }
	return max_len+1;
}
	public static void main (String[] args)
	{
	try {
      Scanner scan = new Scanner(System.in);
       int k= scan.nextInt();     
	    for(int i=0;i<k;i++) {
	    int n = scan.nextInt();
	    int t = scan.nextInt();
	     String array = scan.next(); 
	    int[] a = new int[n];
	     for(int j=0;j<n;j++) {
		a[j]=Integer.parseInt(String.valueOf(array.charAt(j)));
	     }
        
        int output=lengthsubarray(a,n,t);
        System.out.print(output);
        if(i!=(k-1))
        System.out.println();
	} 
	
	}catch (Exception e) {
    }
	}
}
