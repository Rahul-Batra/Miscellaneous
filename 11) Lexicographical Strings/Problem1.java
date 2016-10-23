import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Problem1 {

	public static void main(String[] args) {
		String[] names= {"Akshay","Rahul","Parth","Rahul","Parth","Rajeev","Akshay","Akshay","Parth","Rahul"};
		compute(names);
	}

	private static void compute(String[] names) {
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		for(String s:names) {
			if(m.get(s)==null)
				m.put(s,0);
			else m.put(s, m.get(s)+1);
		}
		String result=null;
		int maxValue=Collections.max(m.values());
		for(Map.Entry<String,Integer> entity:m.entrySet()) {
			if(entity.getValue()==maxValue) {
				 if (result == null || result.compareTo(entity.getKey())<0)
				    {
					 result = entity.getKey();
				    }
			}
			
		}
		System.out.println(result);
		
	}
}
