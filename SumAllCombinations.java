package program_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
//All possible combinations (+,-) from given array to match the total
public class SumAllCombinations {
	static int total=2;
	static Integer sum=new Integer(0);
	static String s=new String();
	static List<String> str= new ArrayList<>();

	public static void main(String[] args) {
		int[] x= {1,2,3};

		loopMethod(x,total);
		if (!str.isEmpty()) {
			str.stream().forEach(c->System.out.println("Matched combination"+c));
		}else {
			System.out.println("not possible");
		}

	}

	private static void loopMethod(int[] x, int total) {
		int counter=0;
		List<Integer> queue = Arrays.stream(x).boxed().collect(Collectors.toList());
		SortedMap<Integer,Integer> totalMap= new TreeMap<Integer,Integer>();
		for (int r=0;r<x.length;r++) {
			totalMap.put(x[r],(int) Math.pow(2, x.length-(r+1)));
		}
		SortedMap<Integer,Integer> plusMap= new TreeMap<Integer,Integer>();
		for (int r=0;r<x.length;r++) {
			plusMap.put(x[r],(int) Math.pow(2, x.length-(r+1)));
		}
		SortedMap<Integer,Integer> minussMap= new TreeMap<Integer,Integer>();
		for (int r=0;r<x.length;r++) {
			minussMap.put(x[r],(int) Math.pow(2, x.length-(r+1)));
		}
		for (int i=0;i<(int) (Math.pow(2, x.length));i++) {
			sum = new Integer(0);
			s = new String();
			for (int n=0;n<queue.size();n++) {
				int val = queue.get(n);
				int key1=getValueforel(val,plusMap);
				if (key1>0) {
					sum=sum+val;
					s=s+"+"+val;
					plusMap.put(val, --key1);
				}else {
					int key2=getValueforel(val,minussMap);
					if (key2>0) {
						sum=sum-val;
						s=s+"-"+val;
						if (--key2==0) {
							plusMap.put(val, totalMap.get(val));
							minussMap.put(val, totalMap.get(val));
						}else
							minussMap.put(val, key2);
					}
				}
			}	
			System.out.println(counter++ + ":" + s+"="+sum);
			if (sum==total) {
				str.add(s);
			}
		}

	}

	private static Integer getValueforel(int val, Map<Integer, Integer> map) {
		for (Entry<Integer, Integer> m:map.entrySet()) {
			if (m.getKey().equals(val)) {
				return m.getValue();
			}
		}
		return null;
	}


}
