public class Problem3 {
	static int numDigits(int  n) {
	    if (n < 10) return 1;
	    return 1 + numDigits(n / 10);
	} 
	 public static int solution(int x) {
		 int len = numDigits(x);
		 int[] array = new int[len];
		 int i,j,max=0,loc=0;
		 for (i = 0,j = len-1; i < len; i++,j--) {
		     array[j] = x % 10;
		     x /= 10;
		 }
		 for (j = 0; j < len; j++) {
			 	 int sum = 0;
				 int[] larray = new int[len + 1];
				 for (i = 0; i < len + 1; ) {
					while(i<j && i!=j)  {
						larray[i] = array[i];i++;
					}
					if(i==j){
						larray[i] = array[j];i++;}
					else{
						larray[i] = array[i-1];i++;}
				 }
				 for (i = 0; i < len+1; i++) {
					    sum = 10 * sum + larray[i];
				 }
				 if(sum > max) {
					 max = sum;
				 }
		 }
		 return max;
	    }
	 
	 public static void main(String args[]){
		 int x = 12511;
		 System.out.println(solution(x));
		 int a = 12121;
		 System.out.println(solution(a));
		 int b = 12234455;
		 System.out.println(solution(b));
		 int c = 12543;
		 System.out.println(solution(c));
	 }
}
