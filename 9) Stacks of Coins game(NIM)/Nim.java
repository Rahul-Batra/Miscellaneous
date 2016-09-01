import java.util.*;
import java.lang.*;
import java.io.*;

public class Nim {
	static int nimSolver (int nimarray[], int length) {
	int nimXOR=0;
	for (int n=0; n<length; n++) {
		nimXOR ^= nimarray[n];
	}
	return nimXOR;
}
  public static void main(String [] args) {
    try {
      Scanner scan = new Scanner(System.in);
       int t= scan.nextInt();     
    for(int i=0;i<t;i++) {
    int n = scan.nextInt();          
        int[] a = new int[n];
        for(int j=0;j<n;j++)
        a[j]=scan.nextInt();  
       int output=nimSolver(a,n);
    if(output==0)
    output=2;
    else output =1;
        System.out.print(output);
        if(i!=(t-1))
        System.out.println();
    }
    
    } catch (Exception e) {
    }
  }
}
