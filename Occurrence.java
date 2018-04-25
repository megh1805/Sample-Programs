package program_challenge;

import java.util.HashMap;
import java.util.Map;
//Print number of occurrence of number in sorted array
public class Occurrence {

	public static void main(String[] args) {
		int x[]= {1,2,3,3,3,3,3,6};
		getVal(x);
	}

	private static void getVal(int[] x) {
		Map<Integer,Integer> m= new HashMap<>();
		for (int i=0;i<x.length;i++) {
			int count=0;
			for (int j=i;j<x.length;j++) {
				if (x[i]==x[j]&&!m.containsKey(x[i])) {
					count++;
				}
			}
			if (!m.containsKey(x[i]))
			  m.put(x[i], count);
		}
        for (Map.Entry<Integer, Integer> map: m.entrySet()) {
        	System.out.println(map.getKey()+"="+map.getValue());
        	
        }
        
	}

}
