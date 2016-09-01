
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	class ArrayStructure {
	    private HashMap<Point, Character> map = new HashMap<Point, Character>();
	    private int maxRow = 0;
	    private int maxColumn = 0;

	    public ArrayStructure() {
	    }

	    public void add(int row, int column, char ch) {
	        map.put(new Point(row, column), ch);
	        maxRow = Math.max(row, maxRow);
	        maxColumn = Math.max(column, maxColumn);
	    }

	    public char[][] toArray() {
	        char[][] result = new char[maxRow + 1][maxColumn + 1];
	        for (int row = 0; row <= maxRow; ++row)
	            for (int column = 0; column <= maxColumn; ++column) {
	                Point p = new Point(row, column);
	                result[row][column] = (char) (map.containsKey(p) ? map.get(p) : '\u0000');
	            }
	        return result;
	    }
	}
	static List<Integer> KMPSearch(String pat, String txt)
    {	
    	List<Integer> list=new ArrayList<Integer>();
    	int z=0;
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;  
        computeLPSArray(pat,M,lps);
        int i = 0;
        int k=0;
        while(i < N)
        {	
            if(pat.charAt(j) == txt.charAt(i))
            {
                j++;
                if(k==0)k=i+1;
                i++;
            }
            if(j == M)
            {
            	list.add(i-j);
                j = lps[j-1];
                if(k!=0)i=k;
                k=0;
            }
            else if(i < N && pat.charAt(j) != txt.charAt(i))
            {
                if(j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
        return list;
    }
     
    static void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0; 
        int i = 1;
        lps[0] = 0; 
        while(i<M)
        {
            if(pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[len] = len;
                i++;
            }
            else  
            {
                if(len != 0)
                {
                    len = lps[len-1];
                }
                else 
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
         
    }
  public static void main(String [] args) {
      List<String> str = new ArrayList<String>();
         int p=0;
         int q=0;
         int r=0;
    try {
      BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
      String line = null;
      while((line=scanner.readLine())!="\n") {
    	  int length = Integer.valueOf(line);
          char[] needleArray = new char[length];
          for(int i = 0; i < length; i++) {
        	  needleArray[i]=(char)scanner.read();
          }
          scanner.read();
          String needle = new String(needleArray);
          Main e = new Main();
          Main.ArrayStructure g = e.new ArrayStructure();
          char ch; int i=0,j=0;
          while((ch=(char)scanner.read())!='\n') {
        	  if(j<(length*8)) {
        		  g.add(i, j, ch);
        		  j++;
        	  } else {
        		  i=i+1;
        		  j=0;
        		  g.add(i, j, ch);
        		  j++;
        	  }
          }
          length=length*8;
          char[][] a = g.toArray();
          List<Integer> list=new ArrayList<Integer>();
          for(int k=0;k<a.length;k++) {
        	  String haystack = new String(a[k]);
        	  List<Integer> index = KMPSearch(needle,haystack);
        	  if(index!=null){
          	  for(int s=0;s<index.size();s++) {
          			list.add(index.get(s)+(k*length));
          	  }
        	  }
          }
          for(int k=0;k<(a.length-1);k++) {
        	  StringBuilder sb = new StringBuilder(length*2);
        	  sb.append(a[k]);
        	  sb.append(a[k+1]);
        	  char[] b = sb.toString().toCharArray();
        	  String haystack = new String(b);
        	  List<Integer> index = KMPSearch(needle,haystack);
        	  if(index!=null){
        		  for(int s=0;s<index.size();s++) {
          			list.add(index.get(s)+(k*length));
          	  }	
        	  }
          }
          list = new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
          Collections.sort(list);
  			for(Integer v :list)
  			System.out.println(v);
  			System.out.println();
          }
          scanner.close();
      } catch (Exception e) {
          e.printStackTrace();
      } 
    
  }
}
