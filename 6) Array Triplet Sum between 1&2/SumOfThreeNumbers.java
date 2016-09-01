/* Problem 1
 * Given an array of +ve numbers
 * Print Yes/No if there exists any combination of triplet s.t.-
 * 1 < a+b+c < 2
 * Rahul Batra
 */

import java.util.Arrays;

class SumOfThreeNumbers
{
		/*Range of numbers P(0,1/3],Q(1/3,2/3],R(2/3,1],S(1,4/3],T(4/3,5/3],U(5/3,2)
			which can be further reduced to A(0,2/3],B(2/3,1),C[1,2)
			Now 3 variables can be chosen from - AAA,AAB,ABB,AAC,ABC
			possible combinations for surity about triplet b/w 1 and 2--
			AAA-if(sum of top 3 max elements of A e.g.- 0.66+0.66+0.66 = 1.99 belongs to(1,2))
			ABC-if(sum of min elements in A,B,C e.g. - 0.01+0.67+1= 1.68 belongs to(1,2))
			ABB-if(sum of top 2 max elements of B and min element of A e.g.- 0.99+0.99+0.01 = 1.99 belongs to(1,2))
			ABB-if(sum of top 2 min elements of B and min element of A e.g.- 0.67+0.67+0.01 = 1.35 belongs to(1,2))
			AAC-if(sum of top 2 min elements of A and min element of C e.g.- 0.01+0.01+1 = 1.02 belongs to(1,2))
			AAB-if(sum of top 2 min elements of A and max element of B e.g.- 0.01+0.01+0.99 = 1.01 belongs to(1,2))		
				Now these are the bare minimum cases to guarantee if such a triplet exists or not */
	String check(double[] x) {
		double twothird=(double)2/3;
		double maxOneA=Double.MIN_VALUE,maxTwoA=Double.MIN_VALUE,maxThreeA=Double.MIN_VALUE,minOneA=Double.MAX_VALUE,minTwoA=Double.MAX_VALUE,maxOneB=Double.MIN_VALUE,maxTwoB=Double.MIN_VALUE,minOneB=Double.MAX_VALUE,minTwoB=Double.MAX_VALUE,minOneC=Double.MAX_VALUE;
		for(double n:x) {
			if(n<=twothird) {
					if(maxOneA<n) {
						maxThreeA=maxTwoA;
						maxTwoA=maxOneA;
						maxOneA=n;
					} else if(maxTwoA<n) {
						maxThreeA=maxTwoA;
						maxTwoA=n;
					} else if(maxThreeA<n) {
						maxThreeA=n;
					} 
					if(minOneA>n) {
						minTwoA=minOneA;
						minOneA=n;
					} else if(minTwoA>n) {
						minTwoA=n;
					}
			} else if(n>twothird && n<1) {
					if(maxOneB<n) {
						maxTwoB=maxOneB;
						maxOneB=n;
					} else if(maxTwoB<n) {
						maxTwoB=n;
					} 
					if(minOneB>n) {
						minTwoB=minOneB;
						minOneB=n;
					} else if(minTwoB>n) {
						minTwoB=n;
					}
			} else if(n>=1 && n<2)
				if(minOneC>n) {
					minOneC=n;
				}	
		} 
		if(maxOneA!=Double.MIN_VALUE && maxTwoA!=Double.MIN_VALUE && maxThreeA!=Double.MIN_VALUE && maxOneA+maxTwoA+maxThreeA>1 && maxOneA+maxTwoA+maxThreeA<2) 
			return "Yes";
		else if(minOneA!=Double.MAX_VALUE && minOneB!=Double.MAX_VALUE && minOneC!=Double.MAX_VALUE && minOneA+minOneB+minOneC>1 && minOneA+minOneB+minOneC<2)
			return "Yes";
		else if(maxOneB!=Double.MIN_VALUE && maxTwoB!=Double.MIN_VALUE && minOneA!=Double.MAX_VALUE && maxOneB+maxTwoB+minOneA>1 && maxOneB+maxTwoB+minOneA<2)
			return "Yes";
		else if(minOneB!=Double.MAX_VALUE && minTwoB!=Double.MAX_VALUE && minOneA!=Double.MAX_VALUE && minOneB+minTwoB+minOneA>1 && minOneB+minTwoB+minOneA<2)
			return "Yes";
		else if(minOneA!=Double.MAX_VALUE && minTwoA!=Double.MAX_VALUE && minOneC!=Double.MAX_VALUE && minOneA+minTwoA+minOneC>1 && minOneA+minTwoA+minOneC<2)
			return "Yes";
		else if(minOneA!=Double.MAX_VALUE && minTwoA!=Double.MAX_VALUE && maxOneB!=Double.MIN_VALUE && minOneA+minTwoA+maxOneB>1 && minOneA+minTwoA+maxOneB<2)
			return "Yes";
		return "No";
	}
	public static void main (String[] args)
	{
		double input[] = {0.25,1.2,11,0.7,0.4,89};
		SumOfThreeNumbers sumOfThreeNumbers = new SumOfThreeNumbers();
		String output = sumOfThreeNumbers.check(input);
		System.out.println("Output for input array-"+Arrays.toString(input)+"; is:"+output);
		
		double input1[] = {0.66,13,1,0.66,1.4,0.68};
		double input2[] = {1.2,3,5,0.4,0.2,1};
		double input3[] = {0.99,0.99,0.45,0.70,0.20};
		double input4[] = {3,0.01,0.66,0.99,4};
		double input5[] = {3,0.01,0.66,1,4};
		double input6[] = {0,2,0.5,0.8,1.7,0.22,1.9};
		double input7[] = {0.67,0.99,2,3,1,0.01};
		double input8[] = {0.99,3,0.01,2,1.11,1};
		double input9[] = {0.98,3,0.01,2,1.11,1};
		double input10[] = {0.33,0.33,0.33,0.33,0.33};
		double input11[] = {0.66,0.66,0.66,0.66,0.66};
		double input12[] = {0.99,0.99,0.99,0.99,0.99};
		double input13[] = {1,2,3,4,5};
		String output1 = sumOfThreeNumbers.check(input1);
		System.out.println("Output for input array-"+Arrays.toString(input1)+"; is:"+output1);
		String output2 = sumOfThreeNumbers.check(input2);
		System.out.println("Output for input array-"+Arrays.toString(input2)+"; is:"+output2);
		String output3 = sumOfThreeNumbers.check(input3);
		System.out.println("Output for input array-"+Arrays.toString(input3)+"; is:"+output3);
		String output4 = sumOfThreeNumbers.check(input4);
		System.out.println("Output for input array-"+Arrays.toString(input4)+"; is:"+output4);
		String output5 = sumOfThreeNumbers.check(input5);
		System.out.println("Output for input array-"+Arrays.toString(input5)+"; is:"+output5);
		String output6 = sumOfThreeNumbers.check(input6);
		System.out.println("Output for input array-"+Arrays.toString(input6)+"; is:"+output6);
		String output7 = sumOfThreeNumbers.check(input7);
		System.out.println("Output for input array-"+Arrays.toString(input7)+"; is:"+output7);
		String output8= sumOfThreeNumbers.check(input8);
		System.out.println("Output for input array-"+Arrays.toString(input8)+"; is:"+output8);
		String output9 = sumOfThreeNumbers.check(input9);
		System.out.println("Output for input array-"+Arrays.toString(input9)+"; is:"+output9);
		String output10 = sumOfThreeNumbers.check(input10);
		System.out.println("Output for input array-"+Arrays.toString(input10)+"; is:"+output10);
		String output11 = sumOfThreeNumbers.check(input11);
		System.out.println("Output for input array-"+Arrays.toString(input11)+"; is:"+output11);
		String output12 = sumOfThreeNumbers.check(input12);
		System.out.println("Output for input array-"+Arrays.toString(input12)+"; is:"+output12);
		String output13 = sumOfThreeNumbers.check(input13);
		System.out.println("Output for input array-"+Arrays.toString(input13)+"; is:"+output13);
	}
}
