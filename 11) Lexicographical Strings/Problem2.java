
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem2 {
	public static void main(String[] args) {
		String s = "aba";
		compute(s);
	}
	private static void compute(String s) {
		HashMap<Character,Integer> vowel = new HashMap<Character,Integer>();
		HashMap<Character,Integer> consonants = new HashMap<Character,Integer>();
		for(char ch='a';ch<='z';ch++) {
			if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u')
				vowel.put(ch, 0);
			else
				consonants.put(ch, 0);			
		}
		List<String> ls = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {  
			   for (int j = i+1; j <= s.length(); j++) {  
				   char[] a =s.toCharArray();
				     String sub = new String(Arrays.copyOfRange(a, i,i+(j-i)));
				
			      if(vowel.get(sub.charAt(0))!=null && consonants.get(sub.charAt(sub.length()-1))!=null) {
			    	  ls.add(sub);
			      }
			   }  
		}
		String result1=null;
		String result2=null;
		for(String c:ls) {
			 if (result1 == null || result1.compareTo(c)>0)
			    {
				 result1 = c;
			    }
			 if (result2 == null || result2.compareTo(c)<0)
			    {
				 result2 = c;
			    }
		}
		  System.out.println(result1);
		  System.out.println(result2);
	}
}
